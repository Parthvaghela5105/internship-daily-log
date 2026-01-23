//Program to create a method that takes a string as input and throws customized exception if the string does not contain vowels.
import java.util.Scanner;

class NotContainsVowelsException extends RuntimeException{
	NotContainsVowelsException(String exceptionMsg)
	{
		super(exceptionMsg);
	}
}

class Program2{
	
	public static boolean containsVowels(String str) {
        String lowerCaseStr = str.toLowerCase();

        for (int i = 0; i < lowerCaseStr.length(); i++) {
            char ch = lowerCaseStr.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return true;             }
        }
        return false; 
    }
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		if(!containsVowels(str)){
			throw new NotContainsVowelsException("Enter valid String: String does not contain any vowels");
		}else{
			System.out.println("String contains the vowels");
		}
	}
}