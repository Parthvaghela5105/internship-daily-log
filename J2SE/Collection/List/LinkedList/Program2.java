//Program to iterate through all elements in a linked list.

import java.util.LinkedList;


class Program2{
	public static void main(String[] args){
		LinkedList li = new LinkedList();
		li.add("Parth");
		li.add("Aditya");
		li.add("Jenil");
		li.add("Ayush");
		li.add("Yogansh");
		
		System.out.print("iterate the linkedlist by for loop :");
		
		for(int i = 0 ; i < li.size() ; i++){
			System.out.print(li.get(i) + " ");
		}
		
		System.out.println();
		System.out.print("iterate the linkedlist by foreach loop :");
		for(Object s : li){
			System.out.print(s+ " ");
		}
	}
}