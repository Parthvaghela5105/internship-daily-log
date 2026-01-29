//Program that handles multiple exceptions using multiple catch blocks.

import java.util.Scanner;

class Program5{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		try{
			int[] a = {1 , 0};
			int div = a[0]/a[2];
		}catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
		}catch(ArithmeticException e){
			e.printStackTrace();
		}
	}
}