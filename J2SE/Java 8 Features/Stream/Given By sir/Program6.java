// Program to find the second smallest and largest elements in a list of integers using streams.

import java.util.Arrays;
import java.util.List;

public class Program6 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,1,2,3,3,4,4,4,5,3,2,3,6,3,5,7,8);
        int max = numbers.stream().distinct().mapToInt(Integer::intValue).max().orElse(-1);
        int min = numbers.stream().distinct().mapToInt(Integer::intValue).min().orElse(-1);
        System.out.println(max);
        System.out.println(min);
    }    
}
