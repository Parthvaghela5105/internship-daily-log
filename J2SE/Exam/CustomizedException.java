
import java.util.ArrayList;
import java.util.List;

class NoValueFound extends RuntimeException{

    public NoValueFound(String exceptionMessage) {
        super(exceptionMessage);
    }
    
}

public class CustomizedException {
    public static void main(String[] args) {
        
        List<String> list = new ArrayList<>();
        list.add    ("A");
        list.add("B");
        list.add(null);
        list.add("C");
        list.add(null);
        list.add("D");

        list.stream().map(s -> s).forEach(x -> {
            if(x == null)
                th
        });
    }
    
}
