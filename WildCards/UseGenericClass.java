package Aufg5;

/**
 * Demonstriert etwas, das schief gehen muss.
 * @author Bernd Kahlbrandt
 *
 */
public class UseGenericClass {

	/**
	 * @param args nicht verwendet.
	 */
	public static void main(String[] args) {
		
		@SuppressWarnings("unchecked")
		GenericClass<String>[] stringArray = new GenericClass[] {new GenericClass<>("Hallo")};
		GenericClass<?> [] wildcardArray = stringArray;
	
		@SuppressWarnings("rawtypes")
		GenericClass [] rawArray = stringArray;
		wildcardArray[0] = new GenericClass<Integer>(1);
		rawArray[0] = new GenericClass<Integer>(2);
		try {
		@SuppressWarnings("unused")
		String s = stringArray[0].getT();
		}catch (Exception e) {
		}
		try {
		@SuppressWarnings("unused")
		String t = stringArray[0].getT();
		}catch (Exception e) {
		}
	}

}
