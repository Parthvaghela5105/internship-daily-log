//Program to iterate through all elements in an array list.
import java.util.ArrayList;

class Program1{
	public static void main(String[] args){
		ArrayList l = new ArrayList();
		
		l.add("Parth");
		l.add("Aditya");
		l.add("Jenil");
		l.add("Ayush");
		l.add("Yogansh");
		l.add("Kevin");
		
		
		System.out.print("Interating ArrayList : ");
		for(Object o: l){
			System.out.print(o + " ");
		}
	}
}