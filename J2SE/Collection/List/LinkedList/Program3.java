//Program to iterate through all elements in a linked list starting at the specified position.

import java.util.LinkedList;
import java.util.Iterator;


class Program3{
	public static void main(String[] args){
		LinkedList li = new LinkedList();
		li.add("Parth");
		li.add("Aditya");
		li.add("Jenil");
		li.add("Ayush");
		li.add("Yogansh");
		
		System.out.print("iterate the linkedlist from specific index by for loop :");
	
		for(int i = 2 ; i < li.size() ; i++){
			System.out.print(li.get(i) + " ");
		}
		
		System.out.println();
		System.out.print("iterate the linkedlist from specific index by Iterator :");
		Iterator it = li.listIterator(2);
		while(it.hasNext()){
			System.out.print(it.next() + " ");
		}
		
	}
}