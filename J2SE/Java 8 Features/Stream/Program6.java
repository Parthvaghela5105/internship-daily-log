//Sort strings A-Z and Z-A using streams

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Program6 {
    public static void main(String[] args) {
        List<String> colors = Arrays.asList("Red","Black","Blue","Grean","Orange");
        List<String> asc = colors.stream().sorted().collect(Collectors.toList());
        System.out.println(asc);      
        List<String> desc = colors.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(desc);      
    }    
}
