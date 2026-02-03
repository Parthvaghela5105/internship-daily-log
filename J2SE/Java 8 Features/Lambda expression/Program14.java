//Program to implement a lambda expression to find the average length of strings in a list.

import java.util.Arrays;
import java.util.List;

public class Program14 {
    public static void main(String[] args) {
        List<String> colors = Arrays.asList("Red", "Green", "Blue", "Orange", "Black");

        int averageLength = (int)colors.stream().mapToInt(String::length).average().orElse(0);
        
        System.out.println("colors average string length "+averageLength);
    }
}
