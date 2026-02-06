
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;



class CountChar{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Map<Character , Integer> mp = new HashMap<>();
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            int occur = mp.getOrDefault(ch , 0) + 1;
            mp.put(ch, occur);
        }

        System.out.println("Occurance of the character is given below: ");
        Set s = mp.entrySet();
        Iterator itr = s.iterator();

        while(itr.hasNext()){
            Map.Entry next = (Map.Entry)itr.next();
            System.out.println(next.getKey() + " " + next.getValue());
        }
    }
    
}