//Program to compare two hash set.

import java.util.HashSet;
class Program4{
	public static void main(String[] args){
		HashSet hs = new HashSet();
		hs.add("Parth");
		hs.add("Jenil");
		hs.add("Aditya");
		hs.add("Yogansh");
		hs.add("Ayush");

		HashSet hs1 = (HashSet)hs.clone();
		HashSet hs2 = new HashSet(hs);
		
		
		System.out.println(hs.equals(hs1));
		System.out.println(hs.equals(hs2));
	}
}