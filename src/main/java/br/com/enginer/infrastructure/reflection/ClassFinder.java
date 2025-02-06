package br.com.enginer.infrastructure.reflection;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.enginer.domain.Constants;

public class ClassFinder {

	public static Object findClassUsingClassLoader(String className) {

		try {

			String packagePath = (Constants.DIRECTORY_APPLICATION + Constants.PACKAGE_NAME_DOMAIN).replaceAll("[.]", "/");

			List<Path> dirs = Files.walk(Paths.get(packagePath), 1).filter(Files::isDirectory).collect(Collectors.toList());

			for (Path path : dirs) {

				String packageName = (path.toString().replaceAll("[/]", ".").replace(Constants.DIRECTORY_APPLICATION, ""));

				try (InputStream stream = ClassFinder.class.getClassLoader() .getResourceAsStream(packageName.replace(".", "/"));

					BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {

					Set<Class<?>> classes = reader.lines().filter(line -> line.endsWith(".class"))
							.map(line -> getClass(line, packageName)).collect(Collectors.toSet());

					for (Class<?> clazz : classes) {
						if (clazz.getSimpleName().equals(className)) {
							Constructor<?> constructor = clazz.getDeclaredConstructor();
							return constructor.newInstance();
						}
					}
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	private static Class<?> getClass(String classFileName, String packageName) {
		try {
			String className = classFileName.replace(".class", "");
			return Class.forName(packageName + "." + className);
		} catch (ClassNotFoundException e) {
			System.err.println("Class not found: " + packageName + "." + classFileName);
		}
		return null;
	}

}
