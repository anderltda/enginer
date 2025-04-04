package br.com.enginer.infrastructure.configuration;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import br.com.enginer.domain.Constants;
import br.com.enginer.domain.Domain;
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
		return parameter.hasParameterAnnotation(Domain.class);
	}

	/**
	 *
	 */
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
		
        String domain = request.getHeader("X-Domain");
        
		String uri = request.getRequestURI();
		
		String[] parts = uri.split("/");
		//String domain = parts.length >= 5 ? parts[4] : null;
		System.out.println("uri " + uri);
		System.out.println("parts " + parts);

		if (domain != null) {
			
			Class<?> clazz = PackageScannerHelper.findClassBySimpleName(Constants.PACKAGE_NAME_DOMAIN, StringsUtils.firstUpper(domain));
			
			if (clazz != null) {
				return clazz.getDeclaredConstructor().newInstance();
			}
		}

		return null;
	}
}
