package Rational;
/* Anwendung5_1.java
Version 1.1
Vorlesung Programmieren 1 HAW Hamburg
@Author: M. Hübner; Erweitert von Blagovesta Stanoeva und Yashar Sadeghi
Zweck: Datentyp für Brüche, Beispielcode Kap. 5.1; Dabei Serialisierung.
*/
import javax.swing.*;
import java.util.regex.Pattern;
import java.io.Serializable;

public class Anwendung5_1 implements Serializable {
	private static final long serialVersionUID = 1L;
   static Reader r=new Reader();
   static Writer w=new Writer();
   
   public static void testeUhrzeit(){
      // Uhrzeit-Beispiel für regulären Ausdruck
      String uhrzeit = JOptionPane.showInputDialog(null, "Bitte Uhrzeit eingeben (hh:mm)");
      if (Pattern.matches("[0-2][0-9]:[0-5][0-9]", uhrzeit)) {
         JOptionPane.showMessageDialog( null, "Uhrzeit scheint syntaktisch KORREKT zu sein!");
      } else {
         JOptionPane.showMessageDialog( null, "Uhrzeit-Format ist falsch!");
      }
   }

   public static void main( String[] args ) throws ClassNotFoundException {

	  Rational5_1 c=new Rational5_1(3,5);
      w.writeFirstInitialising(c);
	
      System.out.println("Bruch: " + c);
  

      // Reguläre Ausdrücke
      testeUhrzeit();
      w.writeProgramEnd(c);
      r.read();

   }
}