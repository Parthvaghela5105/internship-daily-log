//Program to create a reverse order view of the elements contained in a given tree set.

import java.util.Comparator;
import java.util.TreeSet;

class Program4{
    public static void main(String[] args) {
        TreeSet ts = new TreeSet(new MyComparator());
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

class MyComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        String s1 = (String) o1;
        String s2 = (String) o2;

        return -s1.compareTo(s2);
    }
}