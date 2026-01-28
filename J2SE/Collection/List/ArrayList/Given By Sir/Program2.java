//Program to insert an element into the array list at the first position.

import java.util.ArrayList;

class Program2{
	public static void main(String[] args){
		ArrayList l = new ArrayList();
		
		l.add("Parth");
		l.add("Aditya");
		l.add("Jenil");
		l.add("Ayush");
		l.add("Yogansh");
		l.add("Kevin");
		
		//insert into first place
		l.add(0 , "Dinesh");
		
		System.out.print("Interating ArrayList : ");
		for(Object o: l){
			System.out.print(o + " ");
		}
	}
}