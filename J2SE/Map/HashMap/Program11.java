//Program to get a key-value mapping associated with the greatest key strictly less than the given key. Return null if there is no such key.
 
import java.util.Map;
import java.util.TreeMap;

class Program11{
    public static void main(String[] args) {
        TreeMap map = new TreeMap();
        map.put(1, "Java");        
        map.put(2, "C");        
        map.put(3, "C++");        
        map.put(4, "C#");        
        map.put(4, "Python");

        int givenKey = 3;
        Map.Entry entry = map.lowerEntry(givenKey); 

        if (entry != null) {
            System.out.println("Mapping found: Key = " + entry.getKey() + ", Value = " + entry.getValue());
        } else {
            System.out.println("No such key found (null)");
        }

    }
}