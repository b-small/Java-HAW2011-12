package GameOfLife;
/* Schreiben.java
Vorlesung Programmieren 2 HAW Hamburg
@authors: Blagovesta Stanoeva und Yashar Sadeghi
*/

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Schreiben {
	public void schreibErsteInitialisierung(GameOfLife c){
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream("fInitGOL.ser");
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
		
	public void schreibProgrammEnde(GameOfLife c) {
		 /* Speichern */
		  FileOutputStream fos = null;
		  try 
		  {
           fos = new FileOutputStream("pEndGOL.ser");
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

