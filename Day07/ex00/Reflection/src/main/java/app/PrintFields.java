package app;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class PrintFields {

	static ArrayList<String> printFields(Class<?> resultClass) {

		ArrayList<String> strings = new ArrayList<>();
		System.out.println("fields:");

		for (Field field : resultClass.getDeclaredFields()) {

			strings.add(field.getName());
			System.out.println("\t" + field.getType().getSimpleName() + " " + field.getName());
		}
		return strings;
	}
}
