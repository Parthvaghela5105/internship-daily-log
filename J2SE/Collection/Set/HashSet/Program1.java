//Program to iterate through all elements in a hash set.

import java.util.HashSet;
import java.util.Iterator;

class Program1{
	public static void main(String[] args){
		HashSet hs = new HashSet();
		hs.add("Parth");
		hs.add("Jenil");
		hs.add("Aditya");
		hs.add("Yogansh");
		hs.add("Ayush");
		System.out.println("When we add Duplicate then we get "+hs.add("Parth"));
		
		Iterator itr = hs.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
}