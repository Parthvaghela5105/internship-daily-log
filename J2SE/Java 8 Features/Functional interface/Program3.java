// Program to implement a lambda expression to convert a list of strings to uppercase and lowercase.

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Program3 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> colors = Arrays.asList("Red","Green","Blue","Black","Orange");

        Function<String,String> lowerFunction = x -> x.toLowerCase();
        Function<String,String> lowerRef = String::toLowerCase;
        UnaryOperator<String> lowerUnary = String::toLowerCase;

        List<String> byFunction = colors.stream().map(lowerFunction).collect(Collectors.toList());
        List<String> byRef = colors.stream().map(lowerRef).collect(Collectors.toList());
        List<String> byUnary = colors.stream().map(lowerUnary).collect(Collectors.toList());
        
        System.out.println("Lower by using Function interface : "+byFunction);
        System.out.println("Lower by using Reference object : "+byRef);
        System.out.println("Lower by using UnaryOperator interface : "+byUnary);
        
        Function<String,String> upperFunction = x -> x.toUpperCase();
        Function<String,String> upperRef = String::toUpperCase;
        UnaryOperator<String> upperUnary = String::toUpperCase;
        
        List<String> byFunctionUpper = colors.stream().map(upperFunction).collect(Collectors.toList());
        List<String> byRefUpper = colors.stream().map(upperRef).collect(Collectors.toList());
        List<String> byUnaryUpper = colors.stream().map(upperUnary).collect(Collectors.toList());

        System.out.println("Upper by using Function interface : "+byFunctionUpper);
        System.out.println("Upper by using Reference object : "+byRefUpper);
        System.out.println("Upper by using UnaryOperator interface : "+byUnaryUpper);

    }
}
