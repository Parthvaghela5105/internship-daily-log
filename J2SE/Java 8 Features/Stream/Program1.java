//Calculate average of integers using streams

import java.util.Arrays;
import java.util.List;

class Program1{
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        double average = list.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);
        System.out.println("Average of array : "+average);
    }
}