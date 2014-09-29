package Kiosk;
/* Schreiber.java
Vorlesung Programmieren 2 HAW Hamburg
@authors: Blagovesta Stanoeva und Yashar Sadeghi
*/

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Schreiber {
	public void schreibErsteInitialisierung(Kiosk c){
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream("fInitK.ser");
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
		
	public void schreibProgrammEnde(Kiosk c) {
		 /* Speichern */
		  FileOutputStream fos = null;
		  try 
		  {
           fos = new FileOutputStream("pEndK.ser");
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


