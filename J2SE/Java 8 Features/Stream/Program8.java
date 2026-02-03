// Find 2nd smallest/largest using streams

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Program8 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer secondmin = list.stream().sorted().skip(1).findFirst().orElse(0);
        Integer secondmax = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0);
        System.out.println(secondmax);
        System.out.println(secondmin);
    }    
}
