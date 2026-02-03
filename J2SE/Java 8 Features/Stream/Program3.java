
import java.util.Arrays;
import java.util.List;

//Sum even and odd numbers in list using streams

public class Program3 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int sumEven = numbers.stream().filter(n -> n%2==0).mapToInt(Integer::valueOf).sum();
        int sumOdd = numbers.stream().filter(n -> n%2==1).mapToInt(Integer::valueOf).sum();
        
        System.out.println("Sum of odd numbers "+sumOdd);
        System.out.println("Sum of even numbers "+sumEven);
    }
}
