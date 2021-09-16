package ch14;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CollectionTest {

	public static void main(String[] args) {
		// generic
//		List<String> fruits = new ArrayList<String>(5);
		List<String> fruits = new LinkedList<String>();
//		List<String> fruits = new Vector<String>();
		
//		Set<String> fruits = new HashSet<>();
//		Set<String> fruits = new LinkedHashSet<>();
//		Set<String> fruits = new TreeSet<>();
		
		fruits.add("바나나");
		fruits.add("딸기");
		fruits.add("사과");
		fruits.add("오렌지");
		fruits.add("파인애플");
		fruits.add("사과");
		fruits.add("망고");
		
		printFruits(fruits);
	}
	
	static void printFruits(Set<String> fruits) {
		Iterator<String> it = fruits.iterator();
		while(it.hasNext()) {
			String fruit = it.next();
			System.out.println(fruit);
		}
	}
	
	static void printFruits(List<String> fruits) {
		for(int i=0; i<fruits.size(); i++) {
			String fruit = fruits.get(i);
			System.out.println(fruit);
		}
	}
	
//	static void printFruits(LinkedList<String> fruits) {
//		for(int i=0; i<fruits.size(); i++) {
//			String fruit = fruits.get(i);
//			System.out.println(fruit);
//		}
//	}
	
//	static void printFruits(ArrayList<String> fruits) {
//		for(int i=0; i<fruits.size(); i++) {
//			String fruit = fruits.get(i);
//			System.out.println(fruit);
//		}
//	}

}











