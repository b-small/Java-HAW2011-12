package Kiosk;
/* Zigarettenmarke.java
Version 1.1 - mit Serialisierung
Vorlesung Programmieren 2 HAW Hamburg
@authors: Blagovesta Stanoeva und Yashar Sadeghi
*/
import java.io.Serializable;

public class Zigarettenmarke implements Serializable ,Ware {
	

private static final long serialVersionUID = 1L;
	
   String markenName;
   double preisProSchachtel;
   int stueckZahl;
   
   public Zigarettenmarke(String markenName, double preisProSchachtel,
         int stueckZahl) {
      this.markenName = markenName;
      this.preisProSchachtel = preisProSchachtel;
      this.stueckZahl = stueckZahl;
   }
   
   public String getBezeichnung() {
      return markenName;
   }
   
   public double getPreis() {
      return preisProSchachtel;
   }
   
   public boolean istGesundheitsgefaehrdend() {
      return true;
   }
   
   public int getVorhandeneStueckzahl() {
      return stueckZahl;
   }
   
   public void setStueckZahl(int stueckZahl) {
      this.stueckZahl = stueckZahl;
   }
   
   public double getFlaschenGroesse() {
      return 0;
   }
}
