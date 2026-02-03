//Program to implement a lambda expression to concatenate two strings.

interface Concatatation{
    String concateTwoString(String s1 , String s2);
}

public class Program8 {
    public static void main(String[] args) {
        Concatatation concatenate = (s1 , s2) -> s1 + s2;
        String str1 = "Hello , ";
        String str2 = "My name is Parth";

        System.out.println("Concatation of two string : "+concatenate.concateTwoString(str1, str2));
    }
}
