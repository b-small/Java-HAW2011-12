package Kiosk;
/* Test.java
Version 1.1 - mit Serialisierung
Vorlesung Programmieren 2 HAW Hamburg
@authors: Blagovesta Stanoeva und Yashar Sadeghi
*/
import java.io.Serializable;
public class Test implements Serializable {
  
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args){


		Kiosk k = new Kiosk(100);
		Leser l=new Leser();
		Schreiber s=new Schreiber();
		s.schreibErsteInitialisierung(k);
		     

		Zeitschrift spiegel = new Zeitschrift("Spiegel", "12.12.2011", 4, 10);
		Zeitschrift stern = new Zeitschrift("Stern", "15.12.2011", 3.25, 12);
		Zigarettenmarke marlboro = new Zigarettenmarke("Marlboro", 6.0, 50);
		Zigarettenmarke west = new Zigarettenmarke("West", 6.20, 30);
		Zigarettenmarke nil = new Zigarettenmarke("Nil", 5.8, 20);
		Ware cola = new Getraenk(Getraenketyp.LIMONADE, "Coca Cola", 2.0,
				1, 10);
		Getraenk flens = new Getraenk(Getraenketyp.BIER, "Flensburger Pilsener",
				1.2, 0.33, 30);
		Getraenk klarer = new Getraenk(Getraenketyp.SCHNAPS, "Klarer", 11.9,
				0.7, 5);

		k.addWare(spiegel);
		k.addWare(stern);
		k.addWare(marlboro);
		k.addWare(klarer);
		k.addWare(flens);
		k.addWare(cola);
		k.addWare(nil);
		k.addWare(west);
		
		System.out
				.println("################# Flaschengroesse der Cola #################");
		
		System.out.println(((Getraenk)cola).getFlaschenGroesse());

		k.druckeInventarliste();

		System.out.println("################# Cola -1 #################");
		k.aendereStueckzahl(cola, -1);
		k.druckeInventarliste();

		System.out.println("################# Cola +5 #################");
		k.aendereStueckzahl(cola, 5);
		k.druckeInventarliste();

		System.out
				.println("################# West entfernen #################");
		k.removeWare(west);
		k.druckeInventarliste();
		
		s.schreibProgrammEnde(k);
		l.read();
	
}
}
