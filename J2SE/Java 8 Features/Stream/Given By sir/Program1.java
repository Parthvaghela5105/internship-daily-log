// Program to convert a list of strings to uppercase or lowercase using streams.
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Program1 {
    public static void main(String[] args) {
        List<String> colors = Arrays.asList("Red","Black","Blue","Grean","Orange");
        List<String> lower = colors.stream().map(s -> s.toLowerCase()).collect(Collectors.toList());
        System.out.println(lower);  
        List<String> uper = colors.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(uper);  
    }
}
