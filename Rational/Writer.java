package Rational;
/* Writer.java
Vorlesung Programmieren 2 HAW Hamburg
@authors: Blagovesta Stanoeva und Yashar Sadeghi
*/
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Writer {
	public void writeFirstInitialising(Rational5_1 c){
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream("fInitRat.ser");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(c);
			oos.close();
		}
		catch (IOException ex) 
		{
			ex.printStackTrace();
		}
		finally
		{
			try {
				fos.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
		
	public void writeProgramEnd(Rational5_1 c) {
		 /* Speichern */
		  FileOutputStream fos = null;
		  try 
		  {
           fos = new FileOutputStream("pEndRat.ser");
		   ObjectOutputStream oos = new ObjectOutputStream(fos);
		   oos.writeObject(c);
		   oos.close();
		  } 
		  catch (IOException ex) 
		  {
		   ex.printStackTrace();
		  }
		  finally 
		  {
		   try {
		    fos.close();
		   } 
		   catch (Exception e) 
		   {
		    e.printStackTrace();
		   }
		  }
	}
}		  
