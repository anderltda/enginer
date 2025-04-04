package br.com.enginer.infrastructure.helper;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 */
public class PackageScannerHelper {


	public static void main(String[] args) {
		String basePackage = "br.com.enginer.domain.ui.annotation";
		String className = "EntityOne";

		String packageName = findClassPackageByName(basePackage, className);

		//Class<?> clazz = findClassBySimpleName(basePackage, className);

		//System.out.println(clazz);

		if (packageName != null) {
			System.out.println("Pacote da classe '" + className + "': " + packageName);
		} else {
			System.out.println("Classe '" + className + "' não encontrada no pacote " + basePackage);
		}
	}
	

	/**
	 * @param basePackage
	 * @param className
	 * @return
	 */
	public static Class<?> findClassBySimpleName(String basePackage, String className) {
		return findAllClasses(basePackage)
				.stream()
				.filter(c -> c.getSimpleName().equalsIgnoreCase(className))
				.findFirst().orElse(null);
	}

	/**
	 * @param basePackage
	 * @param className
	 * @return
	 */
	public static String findClassPackageByName(String basePackage, String className) {
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
	 */
	private static Set<Class<?>> findAllClasses(String basePackage) {
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
					try {
						className = resourcePath.substring(resourcePath.indexOf("/classes/") + 9).replace("/", ".").replace(".class", "");
						Class<?> clazz = Class.forName(className);
						classes.add(clazz);
						//System.out.println(clazz.getSimpleName());
					} catch (Exception e) {
						// Ignora classes que não podem ser carregadas
					}
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return classes;
	}
}