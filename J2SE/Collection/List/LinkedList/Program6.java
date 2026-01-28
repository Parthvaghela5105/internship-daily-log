//Program to remove the first and last elements from a linked list.

import java.util.LinkedList;

class Program5{
	public static void main(String[] args){
		LinkedList li = new LinkedList();
		li.add("Parth");
		li.add("Aditya");
		li.add("Jenil");
		li.add("Ayush");
		li.add("Yogansh");
		
		for(int i = 0 ; i < li.size() ; i++){
			System.out.println("Element "+li.get(i)+" is present at index "+i);
		}
	}
}