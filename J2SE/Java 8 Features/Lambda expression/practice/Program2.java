
import java.util.function.Predicate;

//Check if a string is empty using lambda

class Program2{
    public static void main(String[] args) {
        Predicate<String> isEmptyString = str -> str.isEmpty();

        String str1 = "";
        String str2 = "My name is Parth";

        System.out.println("String 1 is empty or not : "+ isEmptyString.test(str1));
        System.out.println("String 2 is empty or not : "+ isEmptyString.test(str2));
    }
} 