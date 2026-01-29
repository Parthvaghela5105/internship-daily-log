//5.Write a Java program that reads a file and throws an exception if the file is empty.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class EmptyFileException extends RuntimeException{
	EmptyFileException(String exceptionMSG){
		super(exceptionMSG);
	}
}

class Program5{
	public static void main(String[] args){
		String fileName = "data.txt";
		try{
			checkifFileIsEmpty(fileName);
			System.out.println("File is not empty. reading successfully.");
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(EmptyFileException e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void checkifFileIsEmpty(String fileName)throws FileNotFoundException , EmptyFileException{
		File file = new File(fileName);
		Scanner sc = new Scanner(file);
		
		if(!sc.hasNextLine()){
			sc.close();
			throw new EmptyFileException("The file is Empty.");
		}
		
		while(sc.hasNextLine())
		{
			System.out.println(sc.nextLine());
		}
		
		sc.close();
	}
}