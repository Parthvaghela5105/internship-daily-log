//4.Write a Java program that reads a list of numbers from a file and throws an exception if any of the numbers are positive.
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;


class PositiveNumberException extends RuntimeException{
	PositiveNumberException(String exceptionMSG){
		super(exceptionMSG);
	}
}

class Program4{
	public static void main(String[] args){
		String fileName = "abc.txt";
		try{
			checkNumbersFromFile(fileName);
		}catch(FileNotFoundException e){
			System.out.println("Error: The file '" + fileName + "' was not found.");
            System.out.println(e.getMessage());
		}catch (PositiveNumberException e) {
            System.out.println("Validation Error: A positive number was found.");
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: The file contains non-numeric data.");
            System.out.println(e.getMessage());
        }
		
	}
	
	public static void checkNumbersFromFile(String fileName) 
            throws FileNotFoundException, PositiveNumberException, NumberFormatException {
        
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.trim().isEmpty()) continue; 
                
                int number = Integer.parseInt(line); 
                if (number > 0) {
                    throw new PositiveNumberException("Positive number found: " + number);
                }
            }
        }
    }
}