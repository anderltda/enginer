package br.com.enginer.infrastructure.configuration;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Map;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import br.com.enginer.domain.Constants;
import br.com.enginer.domain.ui.usercase.annotation.instance.UIDomain;
import br.com.enginer.domain.ui.usercase.schema.instance.Domain;
import br.com.enginer.domain.ui.usercase.schema.instance.DomainId;
import br.com.enginer.domain.ui.usercase.utils.ReflectionUtils;
import br.com.enginer.domain.ui.usercase.utils.StringsUtils;
import br.com.enginer.domain.ui.usercase.utils.UUIDGenerator;
import br.com.enginer.infrastructure.tracking.TrackingLogConfigurer;
import br.com.enginer.infrastructure.utils.PackageScannerUtils;
import jakarta.servlet.http.HttpServletRequest;

/**
 * 
 */
@Component
public class DomainResolver implements HandlerMethodArgumentResolver {

    private final TrackingLogConfigurer trackingLogConfigurer;

    public DomainResolver(TrackingLogConfigurer trackingLogConfigurer) {
        this.trackingLogConfigurer = trackingLogConfigurer;
    }

	/**
	 *
	 */
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(UIDomain.class);
	}

	/**
	 *
	 */
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		
		trackingLogConfigurer.setInnerId(UUIDGenerator.generate());

		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);

		String domainName = request.getHeader("X-UIDomain");
		String modal = request.getHeader("X-UIModal");
		String disabled = request.getHeader("X-UI-Mode");
		
		String id = extractIdFromUri(request.getRequestURI());

		if (domainName != null) {
			
			Boolean isModal = modal != null && !modal.isEmpty() ? Boolean.valueOf(modal) : Boolean.FALSE;
			Boolean isDisabled = disabled.equals(Constants.HASH1) ? disabled.equals(Constants.HASH1) : !disabled.equals(Constants.HASH2);
			
			Object object = PackageScannerUtils.findClassBySimpleName(Constants.PACKAGE_NAME_DOMAIN, StringsUtils.firstUpper(domainName));

			Class<?> clazz = object.getClass();

			if (clazz != null) {

				if (clazz.isInterface() || Modifier.isAbstract(clazz.getModifiers())) {
					throw new IllegalArgumentException("Classe " + clazz.getName() + " não pode ser instanciada diretamente.");
				}

				Constructor<?> constructor = clazz.getDeclaredConstructor();
				constructor.setAccessible(true);
				Domain<?> domain = (Domain<?>) constructor.newInstance();
				
				if (id != null && !id.isEmpty()) {
					
					if (domain instanceof DomainId) {
						
						extractKeyComposited(id, domain);
						
					} else {
						
						extractKey(id, clazz, domain);
					}
				}

				Method setModalMethod = clazz.getMethod(StringsUtils.setMethod("modal"), Boolean.class);
				setModalMethod.invoke(domain, isModal);
				
				Method setDisabledMethod = clazz.getMethod(StringsUtils.setMethod("disabled"), Boolean.class);
				setDisabledMethod.invoke(domain, isDisabled);

				return domain;
			}
		}
		return null;
	}

	/**
	 * @param rawId
	 * @param clazz
	 * @param domain
	 * @throws Exception
	 */
	private void extractKey(String rawId, Class<?> clazz, Domain<?> domain) throws Exception {

		Field field = clazz.getDeclaredField("id");

		Class<?> type = field.getType();

		if (DomainId.class.isAssignableFrom(type)) {

			Domain<?> domainId = (Domain<?>) type.getDeclaredConstructor().newInstance();

			ReflectionUtils.set(domain, StringsUtils.setMethod("id"), new Class<?>[] { domainId.getClass() }, new Object[] { domainId });
			
			extractKeyComposited(rawId, domainId);

		} else if (ReflectionUtils.isTypeMatching(domain.getClass(), "id", rawId)) {

			Method setIdMethod = clazz.getMethod(StringsUtils.setMethod("id"), type);

			Object typedId = ReflectionUtils.extractedTypeValue(type, rawId);

			setIdMethod.invoke(domain, typedId);

		}
	}

	/**
	 * @param rawId
	 * @param domain
	 */
	private void extractKeyComposited(String rawId, Domain<?> domain) {
		
		Map<String, Object> ids = ReflectionUtils.parseQueryParams(rawId);
		
		ids.forEach((k, v) -> { 
			try {
				String key = k.substring(k.lastIndexOf(".") + 1);
				Field field = domain.getClass().getDeclaredField(key);
				Class<?> type = field.getType();
				Object value = ReflectionUtils.extractedTypeValue(type, v);
				ReflectionUtils.set(domain, StringsUtils.setMethod(key), new Class<?>[] { type }, new Object[] { value });
			} catch (NoSuchFieldException | SecurityException ex) {
				ex.printStackTrace();
			}
		});
	}

	/**
	 * @param uri
	 * @return
	 */
	private String extractIdFromUri(String uri) {
		String[] parts = Arrays.stream(uri.split("/")).filter(s -> !s.isEmpty()).toArray(String[]::new);
		if (parts.length > 2) {
			String last = parts[parts.length - 1];
			String[] reserved = Constants.WORDS_RESERVED;
			for (String keyword : reserved) {
				if (keyword.equalsIgnoreCase(last)) {
					return null;
				}
			}
			if (last.matches("[a-zA-Z0-9\\-]+")) {
				return last;
			} else if(last.contains("id.")) {
				return last;
			}
		}
		return null;
	}
}
