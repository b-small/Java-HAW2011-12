package Aufg5;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author bas
 * 
 */
 
public class Test1Test {
	
		Test1 t1;
		@Before
		public void setUp() throws Exception {
			t1 = new Test1();
		}


		@Test
		public void testChangeLists() {
			t1.changeLists();
			System.out.println(t1.charList);
			t1.addToCharList('W');
			System.out.println(t1.charList);
			t1.addToCharList('H');
                        t1.addToCharList('Y');
                        System.out.println(t1.charList);
        	        t1.addNullToWildcardList();
			System.out.println(t1.charList);
		}


		@Test(expected=ClassCastException.class)
		public void testAddToRawList() {
			this.testChangeLists();
			t1.addToRawList(1);
			t1.addToRawList(0);
			for(Character c:t1.charList) {
				System.out.println(c);
			}
			System.out.println(t1.charList);
		}

		@Test
		public void testAddToStringList() {
			t1.addToCharList('W');
		}

		@Test
		public void testAddNullToWildcardList() {
			t1.addNullToWildcardList();
			System.out.println(t1.charList);
		}
		

	}


