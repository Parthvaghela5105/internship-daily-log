//Program to demonstrate nested try-catch blocks.

class Program7{
	public static void main(String[] args){
		try {
            System.out.println("Outer try block starts");

            try {
                System.out.println("Inner try block starts");

                int a = 10;
                int b = 0;
                int result = a / b;  

                System.out.println("Result: " + result);

            } catch (ArithmeticException e) {
				e.printStackTrace();
            }

            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);   

            System.out.println("Outer try block ends");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Program continues normally...");
	}
}