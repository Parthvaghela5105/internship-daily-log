//Program to insert the specified element at the specified position in the linked list.

import java.util.LinkedList;

class Program1{
	public static void main(String[] args){
		LinkedList li = new LinkedList();
		li.add("Parth");
		li.add("Aditya");
		li.add("Jenil");
		li.add("Ayush");
		li.add("Yogansh");
		
		System.out.println(li);
		
		li.add(1,"Dinesh");
		
		System.out.println(li);
		
	}
}