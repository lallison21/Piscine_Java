package app;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Program {

	public static void main(String[] args) {

		Reflections reflections = new Reflections("classes", new SubTypesScanner(false));
		Set<Class<?>> set = reflections.getSubTypesOf(Object.class);

		List<String> classes = set.stream()
				.map(Class::getSimpleName)
				.collect(Collectors.toList());

		System.out.println("Classes:");

		for (String aClass : classes) {
			System.out.println("\t" + aClass);
		}

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("---------------------");
			System.out.print("Enter class name:\n-> ");

			String result = scanner.nextLine();

			if (!classes.contains(result)) {
				System.err.println("Error: there is no such class!");
				return;
			}

			Class<?> clazz = Class.forName("classes" + "." + result);
			System.out.println("---------------------");
			ArrayList<String> strings = PrintFields.printFields(clazz);
			PrintMethods.printMethods(clazz);
			System.out.println("---------------------");
			Object object = UpdateObject.createInstance(strings, clazz, scanner);

			if (object == null) {
				return;
			}

			System.out.println("---------------------");
			UpdateObject.updateObject(object, scanner, strings);
			System.out.println("---------------------");
			CallMethod.callMethod(object, scanner);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}