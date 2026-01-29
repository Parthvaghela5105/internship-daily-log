//Program to get the element in a tree set which is greater than or equal to the given element.

import java.util.TreeSet;

class Program7{
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        ts.add(10);
        ts.add(12);
        ts.add(35);
        ts.add(23);
        ts.add(4);
        ts.add(12);
        ts.add(5);
        ts.add(14);

        System.out.println(ts.tailSet(10));

    }
}