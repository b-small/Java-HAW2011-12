package Kiosk;
/* Leser.java
Vorlesung Programmieren 2 HAW Hamburg
@authors: Blagovesta Stanoeva und Yashar Sadeghi
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Leser {
    Kiosk one=null;
	Kiosk two=null;
	
	public void read() {
		try {
			FileInputStream fis=new FileInputStream("fInitK.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			one=(Kiosk) ois.readObject();
			System.out.println("First Initialising:");
			System.out.println(one);
			
			fis=new FileInputStream("pEndK.ser");
			ois=new ObjectInputStream(fis);
			two=(Kiosk) ois.readObject();
			System.out.println("End of Program:");
			System.out.println(two);
			
			
		// Comparing the objects
			System.out.println("~~Comparing the objects~~");
			System.out.println(one.equals(two));
			System.out.println(one.hashCode());
			System.out.println(two.hashCode());
			
		  } 
		catch (IOException ex) 
		{
			   ex.printStackTrace();
			  } 
		catch (ClassNotFoundException e) 
		{
			   e.printStackTrace();
			  }
	}
}
		
