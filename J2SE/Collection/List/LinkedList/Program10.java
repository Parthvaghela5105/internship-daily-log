//Program to convert a linked list to an array list.

import java.util.LinkedList;
import java.util.ArrayList;

class Program10{
	public static void main(String[] args){
		LinkedList li = new LinkedList();
		li.add("Parth");
		li.add("Aditya");
		li.add("Jenil");
		li.add("Ayush");
		li.add("Yogansh");
		
		ArrayList l = new ArrayList(li);
		
		System.out.println(l);
		
	}
}