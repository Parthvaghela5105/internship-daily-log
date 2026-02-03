//Program to implement a lambda expression to count words in a sentence.

public class Program9 {
    public static void main(String[] args) {
        CountWord words = s -> s.split(" ").length;
        String s1 = "My name is Parth";
        System.out.println("Words in the string s1 is : "+words.count(s1));
    }
}

interface CountWord{
    int count(String s);
}
