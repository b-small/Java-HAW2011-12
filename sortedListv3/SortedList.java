package sortedListv3;

/** SortedListBeta.java
 * @author Blagovesta Stanoeva
 * @author Yashar Sadeghi
*/


import java.lang.reflect.Array;
import java.util.Iterator;

class SortedList<T extends Comparable<? super T>> implements Iterable<T> {

	private int zaehler = 0;
	private Factory<T> fabrik;

	public T[] elements;

	/* Constructor */
	public SortedList(Factory<T> fabrik) {
		this.elements = fabrik.create(1);
		this.fabrik = fabrik;
	}
   
	/* Das größte Element */
	public T getHigh() { return elements[zaehler - 1];
	}

	/* Das kleinste Element */
	public T getLow() { return elements[0]; }

	/* Die Länge des generischen Arrays */
	public int size(){ return elements.length; }
	
	
	/* Fügt ein Element zu dem Array hinzu */
	public void add(T x) {
		sortiere(x);
		this.zaehler++;
		ensureCapacity();
	}
	
	/* Sortiert bei Aufruf */
	private void sortiere(T newElements) { 
	int i;
	for (i = 0; i < elements.length && elements[i] != null; i++)
		{
			if (newElements.compareTo((T) elements[i]) <= 0) break;
		}
	insertAt(i, newElements);
	}

	/* Fügt Element an bestimmter Position ein und korrigiert den Index der restlichen Elemente */
	public void insertAt(int pos, T newElement) {
	T[] newElements = fabrik.create(elements.length);
	System.arraycopy(elements, 0, newElements, 0, elements.length);
	elements[pos] = newElement;
	System.arraycopy(newElements, pos, elements, pos + 1, newElements.length - pos - 1);
	}
	


	/* Korrigiert die größe des generischen Arrays 
	 * (z.B. nach Remove, weil sonst ein null Element vorhanden wäre) */
	public T[] correctCapacity() {
		T[] newElements = fabrik.create(elements.length-1);
        System.arraycopy(elements, 0, newElements, 0, Array.getLength(elements)-1);
        elements = (T[]) newElements;
        return elements;
	}
	
	/* Vergrößert das generische Array um 1 */
	private T[] ensureCapacity() {
		T[] newElements = fabrik.create(elements.length + 1);
        System.arraycopy(elements, 0, newElements, 0, Array.getLength(elements));
        elements = (T[]) newElements;
        return elements;
	}
	
	/* Liefert den Index, an dem das Element x liegt */
	public int findPosition(T x) {
		for (int i = 0; i < elements.length; i++) {
			if (elements[i].equals(x)) {
				return i;
			}
		}
		return -1;
	}

	/* Überprüft ob das Array leer ist */
	  
    public boolean isEmpty(){
 	   boolean t=false;
 	   if (elements.length == 0) {
 		   t=true;
 		   System.out.println("Array is empty.");
 		 }   else {
 			 t=false; 
 			 System.out.println("Array is not empty.");
 		 }
 	   return t;
 	   }
	/* Löscht ein Element von dem Array am Index pos */
	public void removeInt(int pos) {
		
		System.arraycopy(elements, pos + 1, elements, pos, elements.length - 1 - pos);
		
	 
		elements[elements.length-1] = null;
	//	zaehler--;
		zaehler=zaehler - 1;
		correctCapacity();
	
		/* Verkleinert das Array um 1, da sonst ein null Element vorhanden wäre */
		
	}

	/* Löschung mit Übergabe eines Elements und ruft remove(int) auf */
	public void remove(T t) {
	
		removeInt(findPosition(t));
	}

	public void ausgabe(){
		for (int i = 0; i < elements.length; i++)
			System.out.println(elements[i]);

		System.out.println("GetHigh: " + getHigh());
		System.out.println("GetLow:  " + getLow());
		System.out.println("Size:    " + size());
		System.out.println("IsEmpty: " + isEmpty());
	}

	@Override
	  
	
	  public Iterator<T> iterator() {
		 return iterator();
	       }
	        
	

	}
