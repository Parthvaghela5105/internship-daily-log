import java.util.function.Predicate;


class Program2{
    public static void main(String[] args) {
        String s1 = "";
        String s2 = "My name is Parth";

        Predicate<String> isEmptyString = (s) -> s.isEmpty();

        System.out.println("String s1 is empry or not : "+isEmptyString.test(s1));
        System.out.println("String s2 is empry or not : "+isEmptyString.test(s2));
        
    }
}