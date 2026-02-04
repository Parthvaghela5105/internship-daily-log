
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

// Program to implement a lambda expression to concatenate two strings.

public class Program8 {
    public static void main(String[] args) {
        String s1 = "Hello , ";
        String s2 = "MY name is Parth";

        BiFunction<String , String , String> bi = (str1 , str2) -> str1 + str2;
        BinaryOperator<String> bi2 = (str1 , str2) -> str1 + str2;

        System.out.println(bi.apply(s1, s2));
        System.out.println(bi2.apply(s1, s2));
    }
}
