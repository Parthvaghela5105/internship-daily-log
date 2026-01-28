//Program to print all the elements of an ArrayList using the elements' position.

import java.util.ArrayList;

class Program9{
	public static void main(String[] args){
		ArrayList l = new ArrayList();
		
		l.add("Parth");
		l.add("Aditya");
		l.add("Jenil");
		l.add("Ayush");
		l.add("Yogansh");
		l.add("Kevin");
		
		System.out.println("Print all the elements of an array");
		for(int i = 0 ; i < l.size() ; i++){
			System.out.println("Element at index "+ i +" is "+ l.get(i) );
		}
	}
}