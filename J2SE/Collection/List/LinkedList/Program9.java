//Program to copy a linked list to another linked list.

import java.util.LinkedList;

class Program9{
	public static void main(String[] args){
		LinkedList li = new LinkedList();
		li.add("Parth");
		li.add("Aditya");
		li.add("Jenil");
		li.add("Ayush");
		li.add("Yogansh");
		
		LinkedList l = new LinkedList(li);
		
		System.out.println(l);
		
	}
}