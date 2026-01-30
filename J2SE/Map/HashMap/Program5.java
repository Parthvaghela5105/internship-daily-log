//Program to get a shallow copy of a HashMap instance.

import java.util.HashMap;

class Program5{
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put(1, "Java");        
        map.put(2, "C");        
        map.put(3, "C++");        
        map.put(4, "C#");        
        map.put(4, "Python");

        HashMap mapClone = (HashMap)map.clone();

        System.out.println(mapClone);

        
    }
}