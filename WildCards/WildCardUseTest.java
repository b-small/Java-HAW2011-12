package Aufg5;


//import static org.junit.Assert.*;
/**
 * 
 * @author bas
 * 
 */

import org.junit.Before;
import org.junit.Test;

public class WildCardUseTest {
	WildCardUse wcu;
	@Before
	public void setUp() throws Exception {
		wcu = new WildCardUse();
	}


	@Test
	public void testChangeLists() {
		wcu.changeLists();
		wcu.addToStringList("Hallo");
		wcu.addNullToWildcardList();
		System.out.println(wcu.stringList);
	}


	@Test(expected=ClassCastException.class)
	public void testAddToRawList() {
		this.testChangeLists();
		wcu.addToRawList(1);
		System.out.println(wcu.stringList);
		for(String s:wcu.stringList) {
			System.out.println(s);
		}
	}

	@Test
	public void testAddToStringList() {
		wcu.addToStringList("Hallo");
	}

	@Test
	public void testAddNullToWildcardList() {
		wcu.addNullToWildcardList();
	}
@Test
public void testInnerClass() {
		    WildCardUse testin = new WildCardUse();
		    testin.test();
		  }
		}




