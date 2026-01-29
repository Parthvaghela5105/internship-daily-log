//Program to test if a hash set is empty or not.

import java.util.HashSet;
import java.util.Iterator;

class Program2{
	public static void main(String[] args){
		HashSet hs = new HashSet();
		hs.add("Parth");
		hs.add("Jenil");
		hs.add("Aditya");
		hs.add("Yogansh");
		hs.add("Ayush");

		HashSet hs1 = new HashSet();
		
		if(hs.isEmpty())
			System.out.println("Hashmap hs is empty");
		else
			System.out.println("Hashmap hs is not empty");
			
		
		System.out.println(hs1.isEmpty());
		
		hs.clear();
		System.out.println(hs.isEmpty());
		
	}
}