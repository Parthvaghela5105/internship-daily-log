//Program to check if a particular element exists in a linked list.

import java.util.LinkedList;

class Program7{
	public static void main(String[] args){
		LinkedList li = new LinkedList();
		li.add("Parth");
		li.add("Aditya");
		li.add("Jenil");
		li.add("Ayush");
		li.add("Yogansh");
		
		System.out.println(li.contains("Parth"));
		System.out.println(li.contains("parth"));
	}
}