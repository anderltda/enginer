package br.com.enginer.infrastructure.configuration;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import br.com.enginer.domain.Constants;
import br.com.enginer.domain.ui.annotation.instance.UIDomain;
import br.com.enginer.domain.ui.schema.field.type.Id;
import br.com.enginer.domain.ui.schema.instance.Domain;
import br.com.enginer.domain.utils.ReflectionUtils;
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
    @SuppressWarnings("unchecked")
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

	    HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);

	    String domainName = request.getHeader("X-UIDomain");
	    String rawId = extractIdFromUri(request.getRequestURI());

	    if (domainName != null) {
	        // Buscar classe pelo nome
	        Class<?> clazz = PackageScannerHelper.findClassBySimpleName(Constants.PACKAGE_NAME_DOMAIN, StringsUtils.firstUpper(domainName));
	        if (clazz != null) {
	            // Criar instância
	            Domain<?> domainInstance = (Domain<?>) clazz.getDeclaredConstructor().newInstance();
	            if (rawId != null) {
	                // Descobre o tipo genérico do ID
	                Field idField = clazz.getDeclaredField("id");
	                ParameterizedType genericType = (ParameterizedType) idField.getGenericType();
	                Class<?> expectedType = (Class<?>) genericType.getActualTypeArguments()[0];
	                // Converte rawId para o tipo esperado (ex: Long, UUID, etc...)
	                Id<?> typedId = ReflectionUtils.convertIdToExpectedType(Id.of(rawId), expectedType);
	                // Cast seguro e atribuição
	                Domain<Object> casted = (Domain<Object>) domainInstance;
	                casted.setId((Id<Object>) typedId);
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
}
