package objectBrowserV2;
/* GameOfLife.java
Version 1.1 - mit Serialisierung
Vorlesung Programmieren 2 HAW Hamburg
@authors: Blagovesta Stanoeva und Yashar Sadeghi
*/
import java.io.IOException;
/* GameOfLife.java
Version 1.1 - mit Serialisierung
Vorlesung Programmieren 2 HAW Hamburg
@author: Blagovesta Stanoeva und Yashar Sadeghi
*/
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
public class GameOfLife implements Serializable {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
boolean neuGitter[][];
   int kantenlaenge;

   public GameOfLife(){
	   this.kantenlaenge = 5;
	   neuGitter=new boolean[kantenlaenge][kantenlaenge];
   }
   public GameOfLife(int kantenlaenge){
      this.kantenlaenge = kantenlaenge;
      neuGitter = new boolean[kantenlaenge][kantenlaenge];
   }
  

   /*-----------Die Größe des Gitters wird festgelegt-----------*/
   public int getKantenLaenge(){
      return neuGitter.length;
   }
   /*-----------Eine Zelle im ersten Gitter lebendig machen-----
   public void setLebendigAlt(int x, int y){
      altGitter [x][y]=true;
   } */
   /*-----------Eine Zelle im zweiten Gitter lebendig machen-----*/
   public void setLebendig(int x, int y){
      neuGitter [x][y]=true;
   }
   /*-----------Der Zustand wrid geprüft, ob tot oder lebendig--*/
   public boolean lebt(int x, int y){
      boolean lebtN;
      if (neuGitter[x][y]==true){
         lebtN=true;
      }
      else{
         lebtN = false;
      }
      return lebtN;
   }

 
    public int getAnzahlLebenderNachbarn(int x, int y){
    int anzahLebenderNachbarn = 0;

        int posX = x - 1;
        int posY = y - 1;
        for(int i = posX;i <= posX + 2; i++){
            for(int j = posY; j <= posY + 2; j++){
                if (lebt(normalisiere(i),normalisiere(j))){
                    anzahLebenderNachbarn++;
                }
            }
        }
        if (lebt(x,y)){
            anzahLebenderNachbarn--;
        }
        return anzahLebenderNachbarn;
    }
   public int normalisiere (int z){

      int a = z;
            if (a < 0){
               a = a + getKantenLaenge();
            }
            if (a >= getKantenLaenge()){
               a = a % getKantenLaenge();
            }
      return a;
   }
   /*-----------Jede Zelle wird einzeln aktualisiert------------*/
   public boolean naechsteGeneration(){
      boolean tempGitter[][] = new boolean[kantenlaenge][kantenlaenge];
      boolean veraendert =false;
      int anzahlLebenderNachbarn = 0;
      for (int x=0; x <= getKantenLaenge()-1; x++){
         for (int y=0; y <= getKantenLaenge()-1; y++){
            anzahlLebenderNachbarn = getAnzahlLebenderNachbarn(x, y);
            tempGitter[x][y] = false;
            if (  anzahlLebenderNachbarn  == 3){
               tempGitter[x][y] = true;
            }
            if ( anzahlLebenderNachbarn == 2){
               if (neuGitter[x][y] == true){
                  tempGitter[x][y] = true;
               }

            }
         }
      }

      for (int x=0; x <= getKantenLaenge()-1; x++){
         for (int y=0; y <= getKantenLaenge()-1; y++){
            if (neuGitter[x][y] != tempGitter[x][y]){
                veraendert=true;
            }
         }
      }
      ausgeben();
      neuGitter = tempGitter;
      return veraendert;

   }
   public void ausgeben(){
      for (int x=0; x <= getKantenLaenge()-1; x++){
         System.out.println();
         for (int y=0; y <= getKantenLaenge()-1; y++){
            if (neuGitter[x][y]==true){
               System.out.print(" 1 " );
            }
            else{
               System.out.print(" 0 " );
            }
         }
      }
      System.out.println();
   }
   
 
   @Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + Arrays.hashCode(neuGitter);
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	GameOfLife other = (GameOfLife) obj;
	if (!Arrays.equals(neuGitter, other.neuGitter))
		return false;
	return true;
}

private void writeObject(ObjectOutputStream aOutputStream) throws IOException {
	  aOutputStream.defaultWriteObject();
	 
	  
 }


private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException {
		     //always perform the default de-serialization first
		     aInputStream.defaultReadObject();
		    

		     //make defensive copy of the mutable Date field
		  
		  }


}

