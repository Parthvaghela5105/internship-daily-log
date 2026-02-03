
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Program to implement a lambda expression to filter out even and odd numbers from a list of integers

class Program4{
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1 , 2, 3, 4, 5 , 6, 7, 8, 9, 10);
        
        System.out.println("Original list");
        for(Integer i: integerList)
            System.out.print(" "+i);
        
        List<Integer> oddList = integerList.stream().filter(n -> n % 2==1).collect(Collectors.toList());
        
        System.out.println();
        System.out.print("Odd list");
        for(Integer i: oddList)
            System.out.print(" "+i);
        
        List<Integer> evenList = integerList.stream().filter(n -> n % 2==0).collect(Collectors.toList());
        
        System.out.println();
        System.out.print("Even list");
        for(Integer i: evenList)
            System.out.print(" "+i);
        
    }
}