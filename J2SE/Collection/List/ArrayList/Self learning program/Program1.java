//1. Write a Java program to create an array list, add some colors (strings) and print out the collection.
//2. Write a Java program to iterate through all elements in an array list.
//3. Write a Java program to insert an element into the array list at the first position.
//4. Write a Java program to retrieve an element (at a specified index) from a given array list.
//5. Write a Java program to update an array element by the given element.
//6. Write a Java program to remove the third element from an array list.
//7. Write a Java program to search for an element in an array list.
//8. Write a Java program to sort a given array list.



//import java.util.List;
//import java.util.ArrayList;
import java.util.*;


class Program1{
	public static void main(String[] args){
		ArrayList l = new ArrayList();
		
		l.add("Parth");
		l.add("Aditya");
		l.add("Jenil");
		l.add("Ayush");
		l.add("Yogansh");
		l.add("Kevin");
		
		for(Object o: l){
			System.out.print(o + " ");
		}		
		
		l.add(0, "Dinesh");
		
		System.out.println();
		
		for(Object o: l){
			System.out.print(o + " ");
		}
		
		System.out.println();
		
		System.out.println("Retrieve the element on specified index 3: "+ l.get(3));
		System.out.println("Retrieve the element on specified index 1: "+ l.get(1));
		
		l.set(3 , "Parth");
		System.out.println(l);
		
		l.remove(3);
		System.out.println(l);
		
		System.out.println(l.indexOf("Parth"));
		System.out.println(l.indexOf("Aditya"));
		System.out.println(l.indexOf("Jenil"));
		System.out.println(l.indexOf("Dinesh"));
		
		Collections.sort(l);
		System.out.println(l);
		
		ArrayList list = new ArrayList(l);
		System.out.println(list);
		
		l.set(0 , "Jenil");
		System.out.println(l);
		System.out.println(list);
		
		 // Shuffle the ArrayList
        Collections.shuffle(list);

        System.out.println("After shuffling:");
        System.out.println(list);
		
		//Reverse arraylist in java
		Collections.reverse(l);
		System.out.println(l);
		
		 // Extract a portion (index 1 to 4, 4 excluded)
        List<String> subList = list.subList(1, 4);

        System.out.println("Extracted portion:");
        System.out.println(subList);
		
		//compare two arraylist
		if(list.equals(l))
			System.out.println("List and l is same");
		else
			System.out.println("List and l is not same");
		
		ArrayList list1 = new ArrayList(l);

		//compare two arraylist
		if(list1.equals(l))
			System.out.println("List and l is same");
		else
			System.out.println("List and l is not same");
	}
}