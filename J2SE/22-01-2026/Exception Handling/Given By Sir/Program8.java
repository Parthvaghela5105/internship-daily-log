//Program to handle bank transaction exception (insufficient balance).

import java.util.Scanner;

class InsufficientBalanceException extends RuntimeException{
	InsufficientBalanceException(String exceptionMSG){
		super(exceptionMSG);
	}
}

class Program8{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int balance = 20000;
		System.out.print("Enter withdrowal amount: ");
		int withdrawAmount = sc.nextInt();
		
		if(balance < withdrawAmount){
			throw new InsufficientBalanceException("Enter valid amount: Insufficient balance");
		}else{
			System.out.print("Withdrawal successfully");			
		}
	}
}