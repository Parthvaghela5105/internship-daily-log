//Program that reads a list of integers from the user and throws an exception if any numbers are duplicates.
import java.util.Scanner;
import java.util.HashSet;


class DuplicateNumberException extends RuntimeException{
	DuplicateNumberException(String exceptionMSG){
		super(exceptionMSG);
	}
}

class Program3{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the length of the array: ");
		int len = sc.nextInt();
		
		int[] arr = new int[len];
		for(int i = 0 ; i < len;i++){
			System.out.print("Enter the element at index "+ i +" : ");
			arr[i] = sc.nextInt();
		}	
		try{
			checkDuplicates(arr);
		}
		catch (DuplicateNumberException e) {
            System.out.println("Validation Error:");
            System.out.println(e.getMessage());
        }
	}
	
	 public static void checkDuplicates(int[] numbers)
            throws DuplicateNumberException {

        HashSet<Integer> set = new HashSet<>();

        for (int num : numbers) {
            if (!set.add(num)) {
                throw new DuplicateNumberException(
                        "Duplicate number found: " + num
                );
            }
        }
    }
}