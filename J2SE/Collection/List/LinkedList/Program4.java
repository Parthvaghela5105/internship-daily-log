//Program to insert the specified element at the end of a linked list.

import java.util.LinkedList;

class Program4{
	public static void main(String[] args){
		LinkedList li = new LinkedList();
		li.add("Parth");
		li.add("Aditya");
		li.add("Jenil");
		li.add("Ayush");
		li.add("Yogansh");
		
		System.out.println(li);
		
		li.addLast("Kevin");

		System.out.println(li);		
	}
}