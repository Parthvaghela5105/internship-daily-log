//Program to validate age for voting using a custom exception.

import java.util.Scanner;

class AgeLimitException extends RuntimeException{
	AgeLimitException(String exceptionMSG){
		super(exceptionMSG);
	}
}

class Program9{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your age: ");
		int age = sc.nextInt();
		
		if(age < 18){
			throw new AgeLimitException("Enter valid age: Invalid age");
		}else{
			System.out.print("You are valid candidate for voting");			
		}
	}
}