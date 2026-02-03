// Program to implement a lambda expression to calculate the sum of squares of all odd and even numbers in a list.

import java.util.Arrays;
import java.util.List;


public class Program10 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int sum_of_squares_odd = nums.stream().filter(n -> n % 2 == 1).mapToInt(n -> n * n).sum();
        System.out.println("Sum of odd Squares "+sum_of_squares_odd);

        int sum_of_squares_even = nums.stream().filter(n -> n % 2 == 0).mapToInt(n -> n * n).sum();
        System.out.println("Sum of odd Squares "+sum_of_squares_even);
    }
}
