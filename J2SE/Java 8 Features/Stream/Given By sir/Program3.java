// Program to remove all duplicate elements from a list using streams.

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Program3 {
        public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,1,2,3,3,4,4,4,5,3,2,3,6,3,5,7,8);
        List<Integer> unique = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println(unique);
    }
    
}
