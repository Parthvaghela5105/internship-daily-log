//Program to compare two array lists.

import java.util.ArrayList;

class Program8{
	public static void main(String[] args){
		ArrayList l = new ArrayList();
		
		l.add("Parth");
		l.add("Aditya");
		l.add("Jenil");
		
		ArrayList li = new ArrayList();
		
		li.add("Parth");
		li.add("Aditya");
		li.add("Jenil");
		
		ArrayList list = new ArrayList();
		
		list.add("Ayush");
		list.add("Yogansh");
		list.add("Kevin");
		
		System.out.println("Compare l and list arraylist "+ l.equals(list));
		System.out.println("Compare l and li arraylist "+ l.equals(li));
	}
}