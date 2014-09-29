package Kiosk;
/* Getraenk.java
Version 1.1 - mit Serialisierung
Vorlesung Programmieren 2 HAW Hamburg
@authors: Blagovesta Stanoeva und Yashar Sadeghi
*/
import java.io.Serializable;

public class Getraenk implements Serializable ,Ware {
	
private static final long serialVersionUID = 1L;
	 
   Getraenketyp typ;
   String markenName;
   double preisProFlasche;
   double flaschenGroesse;
   int stueckZahl;
   
   public Getraenk(Getraenketyp typ, String markenName,
         double preisProflasche, double flaschenGroesse, int stueckZahl) {
      this.typ = typ;
      this.markenName = markenName;
      this.preisProFlasche = preisProflasche;
      this.flaschenGroesse = flaschenGroesse;
      this.stueckZahl = stueckZahl;
   }
   
   public String getBezeichnung() {
      return markenName;
   }
   
   public double getPreis() {
      return preisProFlasche;
   }
   
   public boolean istGesundheitsgefaehrdend() {
      boolean b = false;
      
      if (typ == Getraenketyp.BIER || typ == Getraenketyp.SCHNAPS
            || typ == Getraenketyp.WEIN) {
         b = true;
      }
      
      return b;
   }
   
   public void setStueckZahl(int stueckZahl) {
      this.stueckZahl = stueckZahl;
   }
   
   public int getVorhandeneStueckzahl() {
      return stueckZahl;
   }
   
   
   public double getFlaschenGroesse() {
      return flaschenGroesse;
   }
}