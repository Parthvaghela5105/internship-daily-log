// Program to implement a lambda expression to check if a given string is empty.

import java.util.function.Predicate;

public class Program2 {
    public static void main(String[] args) {
        String s = "my name is parth";
        String s1 = "";
        Predicate<String> checkEmptyString = x -> x.isEmpty();
        System.out.println("String s is empty or not : "+ checkEmptyString.test(s)); 
        System.out.println("String s1 is empty or not : "+ checkEmptyString.test(s1));
        
        Predicate<String> checkEmptyString1 = String::isEmpty;
        System.out.println("String s is empty or not : "+ checkEmptyString1.test(s)); 
        System.out.println("String s1 is empty or not : "+ checkEmptyString1.test(s1));
        
        
    }
}
