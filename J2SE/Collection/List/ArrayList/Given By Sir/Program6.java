//Program to copy one array list into another.

import java.util.ArrayList;

class Program6{
	public static void main(String[] args){
		ArrayList l = new ArrayList();
		
		l.add("Parth");
		l.add("Aditya");
		l.add("Jenil");
		l.add("Ayush");
		l.add("Yogansh");
		l.add("Kevin");
		
		System.out.println("Arraylist l : "+ l);
		
		ArrayList list = new ArrayList(l);
		
		System.out.println("Arraylist list : "+ list);
	}
}