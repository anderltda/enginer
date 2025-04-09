package br.com.enginer.infrastructure.helper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.ClassUtils;

/**
 *  PACKAGE SCANNER
 */
public class PackageScannerHelper {
	
	
	/**
	 * @param basePackage
	 * @param className
	 * @return
	 * @throws Exception 
	 */
	public static Class<?> findClassBySimpleName(String basePackage, String className) throws Exception {
		return findAllClasses(basePackage).stream().filter(c -> c.getSimpleName().equalsIgnoreCase(className)).findFirst().orElse(null);
	}

	/**
	 * @param basePackage
	 * @param className
	 * @return
	 * @throws Exception 
	 */
	public static String findClassPackageByName(String basePackage, String className) throws Exception {
		Set<Class<?>> classes = findAllClasses(basePackage);
		for (Class<?> clazz : classes) {
			if (clazz.getSimpleName().equalsIgnoreCase(className)) {
				return clazz.getPackageName();
			}
		}
		return null;
	}
	

	/**
	 * Lista todas as classes em tempo de execução dentro de um pacote.
	 *
	 * @param basePackage Ex: "br.com.enginer.domain"
	 * @return Set<Class<?>> com todas as classes encontradas
	 * @throws Exception
	 */
	private static Set<Class<?>> findAllClasses(String basePackage) throws Exception {
		Set<Class<?>> classes = new HashSet<>();
		try {
			String className = null;
			String path = ClassUtils.convertClassNameToResourcePath(basePackage);
			String classPattern = "classpath*:" + path + "/**/*.class";

			PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			Resource[] resources = resolver.getResources(classPattern);

			for (Resource resource : resources) {
				String resourcePath = resource.getURL().toString();
				if (resourcePath.contains("/classes/")) {
					className = resourcePath.substring(resourcePath.indexOf("/classes/") + 9).replace("/", ".").replace(".class", "");
					Class<?> clazz = Class.forName(className);
					classes.add(clazz);
					// System.out.println(clazz.getSimpleName());
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
		return classes;
	}
}
