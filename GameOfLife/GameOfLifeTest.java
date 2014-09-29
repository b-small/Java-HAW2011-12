package GameOfLife;
/* GameOfLifeTest.java
Version 1.1 - mit Serialisierung
Vorlesung Programmieren 2 HAW Hamburg
@authors: Blagovesta Stanoeva und Yashar Sadeghi
*/
import java.io.Serializable;

public class GameOfLifeTest implements Serializable {
private static final long serialVersionUID = 1L;
public static void main(String[] args) throws ClassNotFoundException {
	  GameOfLife a = new  GameOfLife(5);
	  Lesen l=new Lesen();
	  Schreiben s=new Schreiben();
	  s.schreibErsteInitialisierung(a);
	  
	    boolean veraendert = true;

         a.setLebendig(1,1);
         a.setLebendig(1,2);
         a.setLebendig(2,1);
         a.setLebendig(2,3);
        
         while (veraendert){
         veraendert = a.naechsteGeneration();
      }
         
         s.schreibProgrammEnde(a);
         l.read();
      
      
 
   
     
  }
}

