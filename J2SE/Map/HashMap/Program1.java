//Program to count the number of key-value (size) mappings in a map.

import java.util.HashMap;


class Program1{
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put(1, "Java");        
        map.put(2, "C");        
        map.put(3, "C++");        
        map.put(4, "C#");        
        map.put(4, "Python");

        System.out.println("Size of map: "+map.size());        
    }
}