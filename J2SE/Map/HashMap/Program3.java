//Program to test if a map contains a mapping for the specified value.

import java.util.HashMap;

class Program3{
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put(1, "Java");        
        map.put(2, "C");        
        map.put(3, "C++");        
        map.put(4, "C#");        
        map.put(4, "Python");

        if(map.containsValue("Java"))
            System.out.println("Map is contains the java");
        else        
            System.out.println("Map is not contains the java");
    }
}