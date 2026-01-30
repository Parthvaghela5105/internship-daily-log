//Program to copy Tree Map's content to another Tree Map.

import java.util.TreeMap;

class Program6{
    public static void main(String[] args) {
        TreeMap map = new TreeMap();
        map.put(1, "Java");        
        map.put(2, "C");        
        map.put(3, "C++");        
        map.put(4, "C#");        
        map.put(4, "Python");

        TreeMap tmap = new TreeMap(map);

        System.out.println(map);
        System.out.println(tmap);
    }
}