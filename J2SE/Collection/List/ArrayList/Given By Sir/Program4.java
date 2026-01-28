//Program to search for an element in an array list.

import java.util.ArrayList;

class Program4{
	public static void main(String[] args){
		ArrayList l = new ArrayList();
		
		l.add("Parth");
		l.add("Aditya");
		l.add("Jenil");
		l.add("Ayush");
		l.add("Yogansh");
		l.add("Kevin");
		
		System.out.println(l.indexOf("Parth"));
		System.out.println(l.indexOf("Aditya"));
		System.out.println(l.indexOf("Jenil"));
		System.out.println(l.indexOf("Dinesh"));
		
	}
}