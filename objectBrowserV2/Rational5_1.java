package objectBrowserV2;
/** Rational5_1.java
 * @author Blagovesta Stanoeva
 * @author Yashar Sadeghi
*/



public class Rational5_1 {
 

	/* -------- Konstanten -------- */

    /* -------- Variablen -------- */
    private static int objektZaehler = 0;

    private final int seriennummer;
    private int zaehler;
    private int nenner;

    /* -------- Konstruktoren -------- */
    public Rational5_1() {
      // Default-Konstruktor
    	this(0, 1); // Aufruf Rational5_1(int, int)
    }

    public Rational5_1(Rational5_1 original) {
      // Kopier-Konstruktor
    	this(original.zaehler, original.nenner);
    }

    public Rational5_1(int z, int n) {
      // Konstruktor mit Initialisierung der Objektvariablen
      objektZaehler++;
      seriennummer = objektZaehler;

    	zaehler = z;
		nenner = n;
    }

   /* -------- Setter - Methoden -------- */
   public void setzeWert(){
    	zaehler = 0;
   	nenner = 1;
    }

    public void setzeWert(int zaehler){
		this.zaehler = zaehler;
		nenner = 1;
    }

    public void setzeWert(int zaehler, int nenner){  // 2 Parameter
      this.zaehler = zaehler;
      this.nenner = nenner;
    }

    public void setZaehler(int zaehler) {  // Setter für Zähler
      this.zaehler = zaehler;
    }

    public void setNenner(int nenner) {   // Setter für Nenner
    	this.nenner = nenner;
    }

    /* -------- Getter - Methoden -------- */
    public int getZaehler() {  // Getter für Zähler
    	return zaehler;
    }

    public int getNenner() {   // Getter für Nenner
    	return nenner;
    }

    public double getReal() { // Bruch als reelle Zahl liefern
    	 // Typecast nötig, sonst int-Division
    	return ((double)zaehler)/nenner;
    }

    public int getSeriennummer() {  // Getter für Objekt-Seriennummer
    	return seriennummer;
    }

    public static int getObjektZaehler() {  // Getter für Objekt-Anzahl
    	return objektZaehler;
    }

    //* -------- Haupt-Methoden -------- */  
    public String toString(){
    	return zaehler + "/" + nenner;
    }

    public void ausgeben(){
    	System.out.format("%d/%d%n", zaehler, nenner);
    }

    public void zaehlerReiheAusgeben() {
      reiheAusgeben(zaehler);
    }

    public void nennerReiheAusgeben() {
      reiheAusgeben(nenner);
    }

    public void kuerzenUndAusgeben(){
      kuerzen();
      ausgeben();
    }

    public void kuerzen(){
      int ggT = berechneGGT(zaehler, nenner);
      zaehler = zaehler / ggT;
      nenner = nenner / ggT;
    }

    public void erweitern (int f){ //Methodenkopf mit Parameter
      zaehler = zaehler * f;
 	   nenner = nenner * f;
    }

    public Rational5_1 mult(Rational5_1 faktorBruch){ // Wertesemantik
	   int z = zaehler * faktorBruch.zaehler;
 	   int n = nenner * faktorBruch.nenner;
      return new Rational5_1(z, n);
 	}

    public void multBoese(Rational5_1 faktorBruch){
	   zaehler = zaehler * faktorBruch.zaehler;
 	   nenner = nenner * faktorBruch.nenner;
 	   faktorBruch.nenner = 0; // böse!
 	}

    public int signum(){
    /* Gibt +1, 0 oder -1 zurück, wenn der Bruch
       positiv, null oder negativ ist */
	   int ergebnis = -1;

      if(zaehler * nenner > 0){
	     ergebnis = 1;
	   } else {
	     if(zaehler == 0){
	        ergebnis = 0;
		  }
	   }
	   return ergebnis;
    }

    public static int berechneGGT (int n, int m){
       /* Euklid-Algorithmus */
        int rest = m % n;
        while (rest != 0) {
            m = n;
            n = rest;
            rest = m % n;
        }
        return n;
   }

   /* -------- Hilfsmethoden ---------- */
   private void reiheAusgeben (int n){
      if (n == 0){
         return;
      }
      //System.out.println(n);
      reiheAusgeben(n-1);
      System.out.println(n);
   }





}




