package Aufg5;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
	
		@SuppressWarnings("rawtypes")
		List rawList;
		List<Character> charList;
		List<Integer> intList;
		List<?> wildcardList;
		List<?> [] wildcardListArray1;
		List<?> [] wildcardListArray2;
		public Test1() {
			this.charList = new ArrayList<>();
			this.rawList = this.charList;
			this.wildcardList =this.charList;
			this.wildcardListArray1 = new ArrayList<?>[10];
			this.wildcardListArray2 = new ArrayList[10];
		}
		public void changeLists() {
			this.rawList = this.charList;
			this.wildcardList =this.charList;
//			this.objList = this.stringList;
		}
		public void addToWildcardList(Integer o) {
//			this.wildcardList.add(o);
		}
		@SuppressWarnings("unchecked")
		public void addToRawList(Integer o) {
			this.rawList.add(o);
		}
		public void addToCharList(Character s) {
			this.charList.add(s);
		}
		public void addNullToWildcardList() {
			this.wildcardList.add(null);
		}

}
