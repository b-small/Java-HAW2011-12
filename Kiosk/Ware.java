package Kiosk;
/* Ware.java
Vorlesung Programmieren 1 HAW Hamburg
@authors: Blagovesta Stanoeva und Yashar Sadeghi
*/
public interface Ware {
   
   public String getBezeichnung();
   
   public double getPreis();
   
   public boolean istGesundheitsgefaehrdend();
   
   public int getVorhandeneStueckzahl();
   
   public void setStueckZahl(int stueckZahl);
   
}
