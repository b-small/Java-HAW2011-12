package Kiosk;
/* Kiosk.java
Version 1.1 - mit Serialisierung
Vorlesung Programmieren 2 HAW Hamburg
@authors: Blagovesta Stanoeva und Yashar Sadeghi
*/

import java.io.Serializable;


public class Kiosk implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	
   int maxWarenAnzahl;
   private Ware[] warenBestand;
   int letzteWarenPosition = 0;

   public Kiosk(int maxWarenAnzahl) {
      this.maxWarenAnzahl = maxWarenAnzahl;

      warenBestand = new Ware[maxWarenAnzahl];

      /* Array in der Größe der maxWarenAnzahl mit null befüllen */
      for (int i = 0; i < maxWarenAnzahl; i++) {

         warenBestand[i] = null;
      }

      

   }

   public void addWare(Ware neueWare) {
      /* Ware anstelle der letzten Warenposition einfügen */
      warenBestand[letzteWarenPosition] = neueWare;

      /* letzteWarenPosition hochzählen und speichern */
      letzteWarenPosition++;

   }

   public void removeWare(Ware alteWare) {

      /*int i = 0;
         while (i < warenBestand.length && warenBestand[i] != null) {
         // Teleliste narücken objekte
         // warenBetands Position des Arrays mit null ersetzen
         // Zu ersetzende Ware wird gesucht
         if (warenBestand[i].equals(alteWare)) {
         warenBestand[i] = null;
         }
         i++;
         } */


      if (alteWare != null) {
         /* Eintrag vorhanden */
      removeWareAusListe(alteWare);
      }

   }


   private void removeWareAusListe(Ware ware) {
      /* Haenge das WarenObjekt aus der Liste aus */
      int index;

      if (ware != null) {
         /* WarenBestands-Index des Eintrags bestimmen */
         index = getIndex(ware.getBezeichnung());
         System.out.println(index);
         if (index < 0){
            System.out.println("Ware ist nicht im Warenbestand vorhanden!");
         } else {
            letzteWarenPosition--;
            /* Arrayplatz durch verschieben loeschen */
            for (int i = index; i <= letzteWarenPosition; i++){
               warenBestand[i] = warenBestand[i+1];
            }
         }
      }
   }


   int getIndex (String name){
      /* Liefere den WarenBestands-Index der Ware mit dem Uebergebenen Namen
         oder -1, falls nicht vorhanden */
      int index = 0;
      boolean gefunden = false;

      while (!gefunden && index < letzteWarenPosition){
         /* Array durchlaufen und jedes Element pruefen, bis Name gefunden */
         if (warenBestand[index].getBezeichnung().equals(name)){
            gefunden = true;
         } else {
            index++;
         }
      }
      /* Pruefen, ob das Element gefunden wurde */
      if (!gefunden){
         index = -1;
      }
      return index;
   }




   public Ware getWare(Ware alteWare) {
      int i = 0;
      while (i < warenBestand.length && warenBestand[i] != null) {

         /* Bezeichnung der gesuchten Ware suchen und zurueckgeben */
         if (warenBestand[i].getBezeichnung().equals(alteWare)) {
            return warenBestand[i];
         }
         i++;
      }
      /* Gegebenenfalls wenn nicht gefunden null zurueckgeben */
      return null;
   }

   public void aendereStueckzahl(Ware ware, int anzahl) {
      int i = 0;
      while (i < warenBestand.length && warenBestand[i] != null) {

         /* Übergebenes Objekt vom Typ Ware suchen und die Stückzahl erhöhen */

         if (warenBestand[i].equals(ware)) {
            ware.setStueckZahl(ware.getVorhandeneStueckzahl() + (anzahl));
         }
         i++;
      }
   }
   
   public void druckeInventarliste() {
      System.out
            .println("*********************************** Aktueller Warenbestand **********************************************");
      
      System.out.printf("%20s %20s %20s %31s %n", "Bezeichnung", "Preis" , "Stueckzahel", "Gesundheitsgefaehrdent");
      
      int i = 0;
      while (i < warenBestand.length && warenBestand[i] != null) {
         
         
         System.out.printf("%20s %20s %20s", warenBestand[i].getBezeichnung(), warenBestand[i].getPreis(), warenBestand[i].getVorhandeneStueckzahl());
         
         if (warenBestand[i].istGesundheitsgefaehrdend() == true)
               System.out.println("\t\tGesundheitsgefaehrdent");
         else
               System.out.println();
         
         i++;
      }
      
   }
}




