//Program to update an array element by the given element.

import java.util.ArrayList;

class Program3{
	public static void main(String[] args){
		ArrayList l = new ArrayList();
		
		l.add("Parth");
		l.add("Aditya");
		l.add("Jenil");
		l.add("Ayush");
		l.add("Yogansh");
		l.add("Kevin");
		
		//Update element by given position
		l.set(0 , "Dinesh");
		
		
		System.out.print("Interating ArrayList : ");
		for(Object o: l){
			System.out.print(o + " ");
		}
	}
}