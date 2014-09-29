package Kiosk;
/* Zeitschrift.java
Version 1.1 - mit Serialisierung
Vorlesung Programmieren 2 HAW Hamburg
@authors: Blagovesta Stanoeva und Yashar Sadeghi
*/
import java.io.Serializable;

public class Zeitschrift implements Serializable, Ware {
	
private static final long serialVersionUID = 1L;
	
   String titel;
   String erscheinungsDatum;
   double preisProStueck;
   int stueckZahl;
   
   public Zeitschrift(String titel, String erscheinungsDatum,
         double preiProStueck, int stueckZahl) {
      this.titel = titel;
      this.erscheinungsDatum = erscheinungsDatum;
      this.preisProStueck = preiProStueck;
      this.stueckZahl = stueckZahl;
   }
   
   public String getBezeichnung() {
      return titel+" / "+getErscheinungsDatum();
   }
   
   public double getPreis() {
      return preisProStueck;
   }
   
   public String getErscheinungsDatum() {
      return erscheinungsDatum;
   }
   
   public boolean istGesundheitsgefaehrdend() {
      return false;
   }
   
   public int getVorhandeneStueckzahl() {
      return stueckZahl;
   }
   
   public void setStueckZahl(int stueckZahl) {
      this.stueckZahl = stueckZahl;
   }
}