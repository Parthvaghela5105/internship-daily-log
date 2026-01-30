//Program to search for a value in a Tree Map.

import java.util.Scanner;
import java.util.TreeMap;

class Program7{
    public static void main(String[] args) {
        TreeMap map = new TreeMap();
        map.put(1, "Java");        
        map.put(2, "C");        
        map.put(3, "C++");        
        map.put(4, "C#");        
        map.put(4, "Python");

        Scanner sc = new Scanner(System.in);
        String searchValue = sc.next();

        if(map.containsValue(searchValue)){
            System.out.println("map is cotains the value "+searchValue);
        }else
            System.out.println("map is not cotains the value "+searchValue);
    }
}