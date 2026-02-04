//Program to implement a lambda expression to filter out even and odd numbers from a list of integers

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Program4 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        
        Predicate<Integer> pred = x -> x%2==0;
 
        List<Integer> simpleEven = numbers.stream().filter(pred).collect(Collectors.toList());
        Function <List<Integer>,List<Integer>> evenNumbers = list -> list.stream().filter(pred).collect(Collectors.toList());
        UnaryOperator<List<Integer>> unaryEvenNumber = list -> list.stream().filter(pred).collect(Collectors.toList());
        
        System.out.println(simpleEven);
        System.out.println(evenNumbers.apply(numbers));
        System.out.println(unaryEvenNumber.apply(numbers));
    }
}
