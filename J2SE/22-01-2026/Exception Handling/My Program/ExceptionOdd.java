//2.Write a Java program to create a method that takes an integer as a parameter and throws an exception if the number is odd.

import java.util.Scanner;

class ExceptionOdd{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if(num%2==1)
			throw new ArithmeticException("Entered number is odd");
	}
}