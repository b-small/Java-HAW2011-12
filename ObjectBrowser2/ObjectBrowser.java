package ObjectBrowser2;

/** ObjectBrowser.java
 * @author Blagovesta Stanoeva
 * @author Yashar Sadeghi
 */
 
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Method;

import java.util.Scanner;


public class ObjectBrowser {
    private Object object;
    
    Scanner scanner = new Scanner(System.in);
    /**
     * Returns the object value.
     * @return Current object.
     * @see #setObject
     */
	public Object getObject() {
		return object;
	}
	
	 /**
     * Specifies the object value.
     * @param obj Object to work with.
     * @see #getObject
     */
	public void setObject(Object obj) {
		this.object = obj;
	}
	public ObjectBrowser(){
		this(new Object());
	}
	
	public ObjectBrowser(Object o) {
		this.object = o;
	}
    /**
     * Prints toString() information about the object.
     */
    public void printToString() {
	System.out.println(object.toString());
    }

    /**
     * Prints object fields names and values.
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    
	public void printFields() throws IllegalArgumentException, IllegalAccessException { //22.5!!!not with throws
			Class<? extends Object> cl = object.getClass(); // returns the runtime class of the object we are browsing
	System.out.println("Class: " + cl.getName()); //prints the name of that class
	System.out.println("Fields: ");
	Field[] fields = cl.getDeclaredFields();
	for(int i = 0; i < fields.length; i++) { //checks if there are any fields of the class
		/* Prints the modifiers, type and name of the class attributes*/
		System.out.println(Modifier.toString(fields[i].getModifiers()) + " " + 
			  fields[i].getType().getCanonicalName() + " " + 
			  fields[i].getName());
		if (!fields[i].isAccessible()) {
			fields[i].setAccessible(true);
		}
		
		if (fields[i].getType().isPrimitive() || fields[i].getType().equals(String.class)) {
			try {
				System.out.print(" = " + fields[i].get(object));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		for (int j=0; j<fields.length; j++) {
			/*checks if one or more of the attributes is an array, if yes - prints the size of this array */
			if (fields[j].getType().isArray()) { 
				/* we are printing the size of the array of fields,because we didn't find out
				 * how to print the size of the array that is in the array of fields.	*/
				//System.out.println(Arrays.toString(fields[i].toString(fields[i].get(obj)));
				//Rekursiv wenn Elementares Feld, kato ne kak ?
				//Arrays. toString() bei der Ausgabe von primitiven Typen
				
				System.out.println(fields.length);  
			}
		
	 else {
		 // ? was für weitere Eigenschaften sollen wir für Attribute von Referenztypen  ausgeben ? Annotationen
				
	 }
			}
		}
	}

    /**
     * Prints object methods names and parameters.
     */
  
	public void printMethods() {
	
	Class<? extends Object> cl = object.getClass();
	/*printing the class name*/
	System.out.println("Class: " + cl.getName());
	System.out.println("Methods: ");
	Method[] methods = cl.getMethods(); 
	for(int i = 0; i < methods.length; i++) {
		/* printing the method signature */
		System.out.println(Modifier.toString(methods[i].getModifiers()) + " " + 
			 methods[i].getReturnType().getName() + " " + 
			 methods[i].getName()); 
	    Class<?> [] params = methods[i].getParameterTypes(); 
	    for(int j = 0; j < params.length; j++) {
	    	System.out.println("    " + params[j].getName()); // prints the parameters of the methods
	    }
	}
    }


    /**
     * Prints everything.
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    public void printFull() throws IllegalArgumentException, IllegalAccessException { //22.05!!! not with throws
    	System.out.println("ToString() Information about the Object:");
    printToString();
     System.out.println("Object fields' names and values:");
	printFields();
	printMethods();
    }
    
    
    /* 3. */
   
public void changeValues(){  // oder hier mit setChar(),setLong() usw. Methoden der java.lang.reflect.Field für primitive Typen??
	   try {
	    String s1;
	    String s2;
		Class<? extends Object> cl = object.getClass();
		s1=scanner.nextLine();
        Field fld = cl.getField(s1);
        Object f2obj = fld.get(object);
        System.out.println(s1 + " = " + f2obj.toString()); //prints the old values of the Object
        System.out.println("Enter new values:");
        s2=scanner.nextLine();
        s1=s2;
        Object newValue=fld.get(object);
        fld.set(f2obj, newValue); // changes the values of the old object with the new given from the user ones.
        System.out.println(s1 + " = " + f2obj.toString()); //prints the new values of the Object
       
     }
     catch (Throwable e) {
        System.err.println(e);
        scanner.close();
     }
	   scanner.close();
  }
}
