//Program to extract a portion of an array list.

import java.util.ArrayList;

class Program7{
	public static void main(String[] args){
		ArrayList l = new ArrayList();
		
		l.add("Parth");
		l.add("Aditya");
		l.add("Jenil");
		l.add("Ayush");
		l.add("Yogansh");
		l.add("Kevin");
		
		System.out.println("ArrayList from index 1 to 4 (4 excluded) : "+ l.subList(1,4));
	}
}