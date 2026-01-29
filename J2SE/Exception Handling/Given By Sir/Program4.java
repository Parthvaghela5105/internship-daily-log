//Program to demonstrate a checked exception using FileNotFoundException.

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

class Program4{
	public static void main(String[] args){
		try{			
			File file = new File("abc.txt");
			Scanner sc = new Scanner(file);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
}