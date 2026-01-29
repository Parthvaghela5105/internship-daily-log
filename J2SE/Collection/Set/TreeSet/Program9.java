//Program to remove a given element from a tree set.

import java.util.TreeSet;

class Program9{
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        ts.add("Red");
        ts.add("Black");
        ts.add("Blue");
        ts.add("Yellow");
        ts.add("White");
        ts.add("Orange");

        System.out.println("Treeset before removal: "+ts);

        System.out.println("Remove specific element : "+ ts.remove("Yellow"));

        System.out.println("Treeset after removal: "+ts);

    }
}