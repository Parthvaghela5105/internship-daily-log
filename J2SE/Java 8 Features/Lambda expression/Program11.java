//Program to implement a lambda expression to check if a list of strings contains a specific word.

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Program11 {
    public static void main(String[] args) {
        List<String> stringlist = Arrays.asList("Red","Green","Blue","Black");
        String s1 = "Red";
        Predicate<String> ContainsWord = word -> word.equals(s1);
        boolean b = stringlist.stream().anyMatch(ContainsWord);
        System.out.println("Is the word " + s1 + " present in the list? " + b);  
    }    
}
