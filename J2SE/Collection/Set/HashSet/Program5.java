//Program to find numbers less than 7 in a tree set.

import java.util.TreeSet;
class Program5{
	public static void main(String[] args){
		TreeSet tr = new TreeSet();
		tr.add(6);
		tr.add(20);
		tr.add(8);
		tr.add(7);
		tr.add(10);
		tr.add(3);
		tr.add(4);
		tr.add(1);
		
		
		System.out.println(tr.headSet(7));
		System.out.println(tr.tailSet(7));
	}
}