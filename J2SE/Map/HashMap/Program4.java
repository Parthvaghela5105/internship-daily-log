//Program to get a set view of the keys contained in this map.

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class Program4{
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put(1, "Java");        
        map.put(2, "C");        
        map.put(3, "C++");        
        map.put(4, "C#");        
        map.put(4, "Python");

        Set set = map.keySet();
        Iterator itr = set.iterator();

        while(itr.hasNext()){
            System.out.println("key : "+itr.next());

        }
    }
}