package ObjectBrowser2;

/** ObjectBrowserAnwendung.java
 * @author Blagovesta Stanoeva
 * @author Yashar Sadeghi
 */

import java.lang.reflect.Constructor;
import java.util.InputMismatchException;
import java.util.Scanner;

import objectBrowserV2.ObjectBrowser;

public class ObjectBrowserAnwendung {
	/**
	 * @param args
	 * @throws Exception
	 */

	public static void main(String[] args) throws Exception {
	//	 ObjectBrowser ob=new ObjectBrowser();
		Scanner scanner = new Scanner(System.in);
		 String s;
	//	Object objectt;
		 System.out.println("Bitte, Klasse oder Objekt eingeben:");
		 s=scanner.next(); // reads the String written on the console
		Class<?> cls = Class.forName(s); // searches
																	// for a
																	// class
																	// with a
																	// name
																	// equal to
																	// the
																	// String
																	// written
																	// on the
																	// console

		@SuppressWarnings("rawtypes")
		Constructor[] constructers = cls.getConstructors();
		for (int i = 0; i < constructers.length; i++) {
			System.out.println("Konstruktor " + i + " " + constructers[i]);
		}
		System.out.println("Bitte wählen Sie einen Konstruktor aus!");

		int derGewaehlteKonstruktor = scanner.nextInt();

//		System.out.println("Kontrolle der gwaehlte Konstruktor="
//				+ constructers[derGewaehlteKonstruktor]);

		Class<?>[] parameterArray = constructers[derGewaehlteKonstruktor]
				.getParameterTypes();

		Object[] parameters = new Object[parameterArray.length];
		for (int i = 0; i < parameterArray.length; i++) {
			System.out.println("Bitte geben Sie nun Ihre Paramter ein:");
			if (parameterArray[i].isPrimitive()
					|| parameterArray[i].getName().equals(
							String.class.getName())) {
				System.out.println("Der nächste Parameter ist ein : "
						+ parameterArray[i]);

				Object input = null;

				try {
					if (parameterArray[i].equals(Integer.TYPE))
				
					input = scanner.nextInt();
					if (parameterArray[i].getName().equals(
							String.class.getName()))
						input = scanner.next();
					if (parameterArray[i].equals(Double.TYPE))
						input = scanner.nextDouble();
					if (parameterArray[i].equals(Boolean.TYPE))
						input = scanner.nextBoolean();
					if (parameterArray[i].equals(Character.TYPE))
						input = scanner.next().trim().charAt(0);
					if (parameterArray[i].equals(Float.TYPE))
						input = scanner.nextFloat();
					if (parameterArray[i].equals(Byte.TYPE))
						input = scanner.nextByte();
					if (parameterArray[i].equals(Long.TYPE))
						input = scanner.nextLong();
					if (parameterArray[i].equals(Short.TYPE))
						input = scanner.nextShort();
				} catch (InputMismatchException e) {
					System.out.println("Falsche Eingabe");

				}

				parameters[i] = input;

			} else if (parameterArray[i].isArray()) {
				System.out
						.println("Ein Array als Parameter kann leider nicht vernünftig eingeben werden");
				parameters[i] = null;

			} else if (parameterArray[i].isEnum()) {
				System.out
						.println("Ein Enum kann nicht einfach so eingegeben werden");
				parameters[i] = null;
			} else {
				System.out
						.println("Der Parameter ist ein Refernztyp. Hiervon wird nun eine Instanz erzeugt.");
				parameters[i] = new ObjectBrowser(parameterArray[i].getName())
						.getObject();
			}

		}

		Constructor<?> constructor = constructers[derGewaehlteKonstruktor];

		Object obj = constructor.newInstance(parameters);
		System.out.println(obj.toString()
				);

		scanner.close();
	}

}
