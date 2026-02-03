
import java.util.Arrays;
import java.util.List;

// Program to implement a lambda expression to find the second largest and smallest element in an array.

public class Program13 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,32,42,2,53,64,23,54,23,57,43,20,284,42,5);

        int secondMax = numbers.stream().sorted((a,b) -> b-a).skip(1).findFirst().orElse(0);
        System.out.println("Second largest element in list "+secondMax);

        int secondSmall = numbers.stream().sorted().skip(1).findFirst().orElse(0);
        System.out.println("Second smallest element in list "+secondSmall);


    }
}
