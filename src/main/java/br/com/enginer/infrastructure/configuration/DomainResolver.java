package br.com.enginer.infrastructure.configuration;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.UUID;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import br.com.enginer.domain.Constants;
import br.com.enginer.domain.ui.annotation.instance.UIDomain;
import br.com.enginer.domain.ui.schema.instance.Domain;
import br.com.enginer.domain.utils.StringsUtils;
import br.com.enginer.infrastructure.helper.PackageScannerHelper;
import jakarta.servlet.http.HttpServletRequest;

/**
 * 
 */
@Component
public class DomainResolver implements HandlerMethodArgumentResolver {

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
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);

		String domainName = request.getHeader("X-UIDomain");
		String rawId = extractIdFromUri(request.getRequestURI());

		if (domainName != null) {
			Class<?> clazz = PackageScannerHelper.findClassBySimpleName(Constants.PACKAGE_NAME_DOMAIN, StringsUtils.firstUpper(domainName));

			if (clazz != null) {
				
				if (clazz.isInterface() || Modifier.isAbstract(clazz.getModifiers())) {
				    throw new IllegalArgumentException("Classe " + clazz.getName() + " não pode ser instanciada diretamente.");
				}

				Constructor<?> constructor = clazz.getDeclaredConstructor();
				constructor.setAccessible(true); // só se for necessário
				Domain<?> domainInstance = (Domain<?>) constructor.newInstance();
				
				if (rawId != null && !rawId.isEmpty()) {
					Field idField = clazz.getDeclaredField("id");
					Class<?> idType = idField.getType();
					Method setIdMethod = clazz.getMethod(StringsUtils.setMethod("id"), idType);
					Object typedId = convertId(rawId, idType);
					setIdMethod.invoke(domainInstance, typedId);
				}

				return domainInstance;
			}
		}
		return null;
	}

	/**
	 * @param uri
	 * @return
	 */
	private String extractIdFromUri(String uri) {
		String[] parts = uri.split("/");
		if (parts.length >= 1) {
			String last = parts[parts.length - 1];
			return last.matches("[a-zA-Z0-9\\-]+") && !last.equalsIgnoreCase("form") ? last : null;
		}
		return null;
	}
	
	/**
	 * @param rawId
	 * @param targetType
	 * @return
	 */
	private Object convertId(String rawId, Class<?> targetType) {
		if (targetType == Long.class) return Long.valueOf(rawId);
		if (targetType == Integer.class) return Integer.valueOf(rawId);
		if (targetType == String.class) return rawId;
		if (targetType == UUID.class) return UUID.fromString(rawId);
		throw new IllegalArgumentException("Tipo de ID não suportado: " + targetType);
	}
}
