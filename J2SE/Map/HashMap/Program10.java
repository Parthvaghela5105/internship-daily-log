//Program to get the portion of a map whose keys are strictly less than a given key.

import java.util.TreeMap;

class Program10{
    public static void main(String[] args) {
        TreeMap map = new TreeMap();
        map.put(1, "Java");        
        map.put(2, "C");        
        map.put(3, "C++");        
        map.put(4, "C#");        
        map.put(4, "Python");

        System.err.println("map with less then key 3 is "+map.headMap(3));
    }
}