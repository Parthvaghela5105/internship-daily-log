//3.Write a Java program to create a method that reads a file and throws an exception if the file is not found.

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

class ExceptionFile{
	public static void main(String[] args){
		String fileName = "NonExistedFile.txt";
		try{
			FileInputStream file = new FileInputStream(fileName);
		}catch(FileNotFoundException ep){
			System.out.println("File is not found");
		}
	}
}