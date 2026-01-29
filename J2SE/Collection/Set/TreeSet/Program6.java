//Program to compare two tree sets.

import java.util.TreeSet;

class Program6{
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        ts.add("Red");
        ts.add("Black");
        ts.add("Blue");
        ts.add("Yellow");
        ts.add("White");
        ts.add("Orange");


        TreeSet ts1 = (TreeSet)ts.clone();
        TreeSet ts2 = new TreeSet(ts);

        System.out.println(ts);
        System.out.println(ts1);
        System.out.println(ts2);

        System.out.println(ts.equals(ts1));
        System.out.println(ts.equals(ts2));
        System.out.println(ts1.equals(ts2));
    }
}