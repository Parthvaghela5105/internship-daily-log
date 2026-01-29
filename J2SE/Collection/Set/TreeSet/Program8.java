//Program to retrieve and remove the first element of a tree set.

import java.util.TreeSet;

class Program8{
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        ts.add("Red");
        ts.add("Black");
        ts.add("Blue");
        ts.add("Yellow");
        ts.add("White");
        ts.add("Orange");

        System.out.println("Treeset before removal: "+ts);

        System.out.println("Retrival and print first element : "+ ts.pollFirst());

        System.out.println("Treeset after removal: "+ts);

    }
}