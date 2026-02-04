//Flat map

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program7 {
    public static void main(String[] args) {
        List<List<Integer>> li = new ArrayList<>();
        li.add(List.of(1,2,3,4));
        li.add(List.of(5,6,7,8));
        li.add(List.of(9,10,11,12));
        li.add(List.of(13,14,15,16));

        List<List<Integer>> li1 = new ArrayList<>();
        li1.add(List.of(1,2,3,4));
        li1.add(List.of(5,6,7,8));
        li1.add(List.of(9,10,11,12));
        li1.add(List.of(13,14,15,16));

        List<List<List<Integer>>> li2 = new ArrayList<>();
        li2.add(li);
        li2.add(li1);

        List<Integer> flatList = li2.stream().flatMap(List::stream).flatMap(List::stream).collect(Collectors.toList());
        System.out.println(flatList);
    }
}
