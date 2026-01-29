//Program to handle multiple exceptions using single catch block.

import java.util.Scanner;

class Program6{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		try{
			int[] a = {1 , 0};
			int div = a[0]/a[2];
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}