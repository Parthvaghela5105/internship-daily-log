//6.Write a Java program that reads a list of integers from the user and throws an exception if any numbers are duplicates.

import java.util.HashSet;
import java.util.Scanner;

class DuplicateNumberException extends Exception {
    DuplicateNumberException(String message) {
        super(message);
    }
}

class Program6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter number of elements: ");
            int n = sc.nextInt();

            int[] numbers = new int[n];

            System.out.println("Enter " + n + " integers:");
            for (int i = 0; i < n; i++) {
                numbers[i] = sc.nextInt();
            }

				checkDuplicates(numbers);
            System.out.println("No duplicate numbers found.");

        } catch (DuplicateNumberException e) {
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
