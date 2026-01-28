//Program to iterate a linked list in reverse order.

import java.util.LinkedList;
import java.util.ListIterator;

class Program8{
	public static void main(String[] args){
		LinkedList li = new LinkedList();
		li.add("Parth");
		li.add("Aditya");
		li.add("Jenil");
		li.add("Ayush");
		li.add("Yogansh");
		
		ListIterator itr = li.listIterator(li.size());
		
		while(itr.hasPrevious()){
			System.out.println(itr.previous());
		}
		
	}
}
