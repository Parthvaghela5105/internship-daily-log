//Program to get a key-value mapping associated with the greatest key and the least key in a map.

import java.util.TreeMap;

class Program9{
    public static void main(String[] args) {
        TreeMap map = new TreeMap();
        map.put(1, "Java");        
        map.put(2, "C");        
        map.put(3, "C++");        
        map.put(4, "C#");        
        map.put(4, "Python");

        Object first = map.firstKey();
        Object last = map.lastKey();

        System.out.println("Value according to least key "+map.get(first));
        System.out.println("Value according to greatest key "+map.get(last));

    }
}