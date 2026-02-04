// Program to count the number of strings in a list that start with a specific letter using streams.

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Program4 {
    public static void main(String[] args) {
        List<String> colors = Arrays.asList("Red","Black","Blue","Grean","Orange");
        List<String> matchWords = colors.stream().filter(s -> s.startsWith("B")).collect(Collectors.toList());
        System.out.println(matchWords);
    }
}
