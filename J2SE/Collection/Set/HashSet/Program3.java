//Program to convert a hash set to an array.

import java.util.HashSet;
class Program3{
	public static void main(String[] args){
		HashSet hs = new HashSet();
		hs.add("Parth");
		hs.add("Jenil");
		hs.add("Aditya");
		hs.add("Yogansh");
		hs.add("Ayush");

		Object[] arr = hs.toArray();
		
		for(Object o : arr){
			System.out.println(o);
		}
	}
}