//Program to implement a lambda expression to sort a list of strings in alphabetical order.

import java.util.Arrays;
import java.util.List;

public class Program5 {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Red" , "Black" , "Blue" , "Green");
        System.out.print("Original string array: ");
        for(String s : stringList){
            System.out.print(" "+s);
        }
        
        stringList.sort((s1 , s2) -> s1.compareTo(s2));
        System.out.println();
        System.out.print("string array in sorted order: ");
        for(String s : stringList){
            System.out.print(" "+s);
        }
    }
}
