//Program to sort a given array list.

import java.util.ArrayList;
import java.util.Collections;

class Program5{
	public static void main(String[] args){
		ArrayList l = new ArrayList();
		
		l.add("Parth");
		l.add("Aditya");
		l.add("Jenil");
		l.add("Ayush");
		l.add("Yogansh");
		l.add("Kevin");
		
		System.out.println("Arraylist before sorting "+ l);
		
		Collections.sort(l);
		
		System.out.println("Arraylist after sorting "+ l);
	}
}