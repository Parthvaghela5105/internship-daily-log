//Program to check whether a map contains key-value mappings (empty) or not

import java.util.HashMap;


class Program2{
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put(1, "Java");        
        map.put(2, "C");        
        map.put(3, "C++");        
        map.put(4, "C#");        
        map.put(4, "Python");
        map.put(5, null);

        if(map.isEmpty())
            System.out.println("maps is Empty hashmap");
        else
            System.out.println("map is Not Empty hashmap");

        HashMap map2 = new HashMap();
        
        if(map2.isEmpty())
            System.out.println("map2 is Empty hashmap");
        else
            System.out.println("map2 is Not Empty hashmap");
    }

}