// Program to implement a lambda expression to sort a list of strings in alphabetical order.

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Program5 {
    public static void main(String[] args) {
        List<String> colors = Arrays.asList("Red","Green","Black","blue");
        UnaryOperator<List<String>> sortedList = x -> x.stream().sorted().collect(Collectors.toList());
        
        System.out.println(colors);
        System.out.println(sortedList.apply(colors));
        UnaryOperator<List<String>> reversSortedList = x -> x.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(reversSortedList.apply(colors));
    }    
}
