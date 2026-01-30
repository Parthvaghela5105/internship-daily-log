//Program to delete all elements from a Tree Map.

import java.util.TreeMap;

class Program8{
    public static void main(String[] args) {
        TreeMap map = new TreeMap();
        map.put(1, "Java");        
        map.put(2, "C");        
        map.put(3, "C++");        
        map.put(4, "C#");        
        map.put(4, "Python");

        System.out.println("Map before delete all elements "+map);

        map.clear();

        System.out.println("Map after delete all elements "+map);

    }
}