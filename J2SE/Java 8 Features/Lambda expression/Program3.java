
import java.util.Arrays;
import java.util.List;

//Program to implement a lambda expression to convert a list of strings to uppercase and lowercase.

class Program3{
    public static void main(String[] args) {
        List<String> stringlist = Arrays.asList("Red","Green","Blue","Black");
        for(String s : stringlist){
            System.out.print(" "+s);
        }

        System.out.println();
        stringlist.replaceAll(s -> s.toUpperCase());
        System.out.print("Converted into upper case : ");
        for(String s : stringlist){
            System.out.print(" "+s);
        }
        
        System.out.println();
        stringlist.replaceAll(s -> s.toLowerCase());
        System.out.print("Converted into lower case : ");
        for(String s : stringlist){
            System.out.print(" "+s);
        }
        
    }
}