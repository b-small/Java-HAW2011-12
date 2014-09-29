package Rational;
/* Reader.java
Vorlesung Programmieren 2 HAW Hamburg
@authors: Blagovesta Stanoeva und Yashar Sadeghi
*/
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Reader {
	Rational5_1 one=null;
	Rational5_1 two=null;
	
	public void read() {
		try {
			FileInputStream fis=new FileInputStream("fInitRat.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			one=(Rational5_1) ois.readObject();
			System.out.println("~~~First Initialising~~~");
			System.out.println(one);
			
			fis=new FileInputStream("pEndRat.ser");
			ois=new ObjectInputStream(fis);
			two=(Rational5_1) ois.readObject();
			System.out.println("~~~End of Program~~~");
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
		