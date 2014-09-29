package Aufg5;

/**
 * Nur ein Beispiel.
 * 
 * @author Bernd Kahlbrandt
 * 
 * @param <T>
 */
public class GenericClass<T> {
	private T t;
	public GenericClass(T t) {
		setT(t);
	}
	public T getT() {
		return this.t;
	}
	public void setT(T t) {
		this.t = t;
	}
}
