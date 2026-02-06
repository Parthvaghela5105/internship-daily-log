
import java.util.Scanner;

public class LongestWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] words = str.split(" ");
        String maxLenString = "";

        for(int i = 0 ; i < words.length;i++){
            if(words[i].length() > maxLenString.length())
                maxLenString = words[i];
        }

        System.out.println("Longest Words : "+maxLenString);
    }
    
}
