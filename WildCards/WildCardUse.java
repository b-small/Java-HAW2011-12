package Aufg5;

import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse illustriert einige Eigenschaften, auf die bei der Arbeit mit parametrisierten Typen geachtet werden muss.
 * @author Bernd Kahlbrandt
 *
 */
public class WildCardUse {
	@SuppressWarnings("rawtypes")
	List rawList;
	List<Object> objList;
	List<String> stringList;
	List<?> wildcardList;
	List<?> [] wildcardListArray1;
	List<?> [] wildcardListArray2;
	public WildCardUse() {
		this.stringList = new ArrayList<>();
		this.rawList = this.stringList;
		this.wildcardList =this.stringList;
		this.wildcardListArray1 = new ArrayList<?>[10];
		this.wildcardListArray2 = new ArrayList[10];
	}
	public void changeLists() {
		this.rawList = this.stringList;
		this.wildcardList =this.stringList;
//		this.objList = this.stringList;
	}
	public void addToWildcardList(Object o) {
//		this.wildcardList.add(o);
	}
	@SuppressWarnings("unchecked")
	public void addToRawList(Object o) {
		this.rawList.add(o);
	}
	public void addToStringList(String s) {
		this.stringList.add(s);
	}
	public void addNullToWildcardList() {
		this.wildcardList.add(null);
	}
	
		   

		// this is an inner class
		
		  void test() {
			    InnerWC<String> inner = new InnerWC<String>();
			    inner.display();
			  }
		  @SuppressWarnings("hiding")
		class InnerWC<String> {
			    void display() {
			    	
			      System.out.println("display: outer_x = " + stringList);
			    }
			  }
	
}



