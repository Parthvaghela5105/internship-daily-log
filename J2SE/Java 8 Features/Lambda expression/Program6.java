// Program to implement a lambda expression to remove duplicates from a list of integers.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program6 {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1 , 2, 3, 4, 5 , 6, 7, 8, 9, 10 , 1 , 2 , 3, 1 ,2 ,1);

        List<Integer> uniqueList = new ArrayList<>();

        integerList.stream()
                        .distinct()
                        .forEach(uniqueList::add);

        System.out.println("unique Elements are : "+uniqueList);
    }
}
