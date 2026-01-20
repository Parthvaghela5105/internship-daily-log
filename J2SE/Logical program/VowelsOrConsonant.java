import java.util.Scanner;

class VowelsOrConsonant{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter any character(a-z or A-Z) ");
		char ch = sc.next().charAt(0);
		
		if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U' )
		{
			System.out.println(ch + " is vowels");
		}else{
			System.out.println(ch + " is consonants");
		}
	}
	
}