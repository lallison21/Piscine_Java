package app;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

public class CallMethod {

	static void callMethod(Object object, Scanner scanner) {
		System.out.print("Enter name of the method for call:\n-> ");
		String methodName = scanner.nextLine();
		Method[] oMethods = object.getClass().getDeclaredMethods();

		for (Method oMethod : oMethods) {
			String returnType = oMethod.getReturnType().getSimpleName();
			String name = oMethod.getName();
			Class<?>[] parameters = oMethod.getParameterTypes();
			String res;

			if (parameters.length > 0) {
				StringBuilder stringBuilder = new StringBuilder(parameters[0].getSimpleName());

				for (int i = 1; i < parameters.length; i++) {
					stringBuilder.append(", ");
					stringBuilder.append(parameters[i].getSimpleName());
				}

				res = name + "(" + stringBuilder + ")";
			} else {
				res = name + "()";
			}

			if (res.equals(methodName)) {
				ArrayList<Object> objects = new ArrayList<>();

				for (Class<?> parameter : parameters) {
					System.out.print("Enter " + parameter.getSimpleName() + " value:\n-> ");

					try {
						switch (parameter.getSimpleName().toLowerCase()) {
							case "int":
							case "integer":
								objects.add(Integer.parseInt(scanner.nextLine()));
								break;
							case "double":
								objects.add(Double.parseDouble(scanner.nextLine()));
								break;
							case "boolean":
								objects.add(Boolean.parseBoolean(scanner.nextLine()));
								break;
							case "long":
								objects.add(Long.parseLong(scanner.nextLine()));
								break;
							default:
								objects.add(scanner.nextLine());
								break;
						}
					} catch (NumberFormatException e) {
						System.err.println("Error: wrong input type!");
						System.exit(1);
					}
				}

				oMethod.setAccessible(true);

				try {
					if (returnType.equals("void")) {
						oMethod.invoke(object, objects.toArray());
					} else {
						System.out.println("Method returned:");
						System.out.println(oMethod.invoke(object, objects.toArray()));
					}
				} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}

				oMethod.setAccessible(false);
				return;
			}
		}
		System.err.println("Error: can't find such method");
	}
}
