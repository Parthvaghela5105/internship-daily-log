// Program to calculate the average of a list of integers using streams.

import java.util.Arrays;
import java.util.List;

public class Program7 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        double average = list.stream().mapToInt(a -> a).average().orElse(0.0);
        System.out.println("Average : "+average);

    } 
    
}
