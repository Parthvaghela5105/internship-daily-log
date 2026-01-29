
import java.util.TreeSet;

class Program5{
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        ts.add("Red");
        ts.add("Black");
        ts.add("Blue");
        ts.add("Yellow");
        ts.add("White");
        ts.add("Orange");

        TreeSet ts1 = (TreeSet)ts.clone();

        System.out.println(ts);
        System.out.println(ts1);
    }
}
