package sortedListv3;

	import java.io.BufferedReader;
	import java.io.FileReader;
import java.io.IOException;


	public class Test{

		public static void main(String[] arg) {
			
			SortedList<String> list;
			boolean dateiVorh = true;
			list = new SortedList<String>(new Factory<String>(){

				@Override
				public String[] create(int size) {
					// TODO Auto-generated method stub
					return new String[size];
				}
				
			});
			
			
			try {
			
				BufferedReader in = new BufferedReader(new FileReader("sgb-words.txt"));
				String zeile = null;
				while ((zeile = in.readLine()) != null) {

					list.add(zeile);
				
				

				}
				in.close();
			}  catch (IOException e) {
				e.printStackTrace();
				System.out.println("Datei nicht vorhanden");
				dateiVorh=false;
				
			}
			while(dateiVorh == true)
			{
				System.out.println(list.getHigh());
				System.out.println(list.getLow());
				list.correctCapacity();
				

			/* Test ob die Methode sortiert hat (und somit add usw) funktioniert */
			//if( !list.getHigh().equals("zowie")) System.out.println("Fehler!");
			if( !list.getLow().equals("aargh"))System.out.println("Fehler!");
			
			/* Das Wort abaci wird gelöscht */
			list.removeInt(1);
			list.remove("aback");
			
			/* Test ob die beiden Elemente gelöscht wurden */
			if( list.findPosition("abaci") != -1 && list.findPosition("aback") != -1)
				System.out.println("Fehler!");
			/* Test ob size erwartete Größe hat */
			if(list.size() != 5755)System.out.println("Fehler!");
			/* Test ob isEmpty erwarteten Wert ausgibt */
			if(list.isEmpty() != false)System.out.println("Fehler!");
			
			/* Ausgabe */
			list.ausgabe();
			
			}
			
						
		}
	}