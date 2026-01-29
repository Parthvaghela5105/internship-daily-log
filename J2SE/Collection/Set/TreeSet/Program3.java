//Program to add all the elements of a specified tree set to another tree set.

import java.util.TreeSet;

class Program3{
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        ts.add("Red");
        ts.add("Black");
        ts.add("Blue");
        ts.add("Yellow");
        ts.add("White");
        ts.add("Orange");

        TreeSet ts1 = new TreeSet(ts);
        TreeSet ts2 = (TreeSet)ts.clone();

        System.out.println(ts);
        System.out.println(ts1);
        System.out.println(ts2);

    }
}