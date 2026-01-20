import java.util.Scanner;

class PrimeOrNot{
	static boolean primeOrNot(int num){
		for(int i = 2 ; i <= num/2 ; i++)
		{
			if(num % i == 0)
			{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number: ");
		int num = sc.nextInt();
		
		if(primeOrNot(num)){
			System.out.println(num+" is prime number");
		}else{
			System.out.println(num+" is not prime number");
		}
	}
	
}