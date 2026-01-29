//Program to iterate through all elements in a tree set.

import java.util.Iterator;
import java.util.TreeSet;

class Program2{
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        ts.add("Red");
        ts.add("Black");
        ts.add("Blue");
        ts.add("Yellow");
        ts.add("White");
        ts.add("Orange");

        Iterator itr = ts.iterator();

        while(itr.hasNext()){
            System.out.println(itr.next());
        }

    }
}