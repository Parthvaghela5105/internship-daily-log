//Program to create a tree set, add some colors (strings) and print out the tree set.

import java.util.TreeSet;

class Program1{
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        ts.add("Red");
        ts.add("Black");
        ts.add("Blue");
        ts.add("Yellow");
        ts.add("White");
        ts.add("Orange");

        System.out.println(ts);
        

    }
}