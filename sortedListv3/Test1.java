package sortedListv3;

/** Test1.java
 * @author Blagovesta Stanoeva
 * @author Yashar Sadeghi
 */

public class Test1 {

	
	public static void main(String[] args) {
		
		SortedList<Integer> intList;
		intList = new SortedList<Integer>(new Factory<Integer>() {
			@Override
			public Integer[] create(int size) { return new Integer[size]; }
			});
		
		intList.add(200); 
		intList.add(158);  
		intList.add(78);  	
		intList.add(10);   
		intList.add(5);   
		intList.add(78); 
		intList.add(50); 
		intList.add(2);
		intList.add(201);
		
		intList.correctCapacity();
	
		
		/* Löschung der eine Zahl 78 */
		intList.removeInt(4); 
		
		/* Ausgabe */
		intList.ausgabe();
				
		/* Test ob die Methode sortiert hat (und somit add usw) funktioniert */
		if( !intList.getHigh().equals(201))System.out.println("Fehler!");
		if( !intList.getLow().equals(2))System.out.println("Fehler!");
		/* Test ob die Elemente richtig gelöscht wurden */
		if( intList.findPosition(10) != 2)System.out.println("Fehler!");
		/* Test ob size die erwartete Größe hat */
		if(intList.size() != 8)System.out.println("Fehler!");
		/* Test ob isEmpty erwarteten Wert ausgibt */
		if(intList.isEmpty() != false)System.out.println("Fehler!");
		
		

	}


}

