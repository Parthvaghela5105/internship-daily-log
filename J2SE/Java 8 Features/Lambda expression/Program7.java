//Program lambda expression to implement a lambda expression to calculate the factorial of a given number.

interface Factorial{
    int factorial(int a);
}

public class Program7 {
    public static void main(String[] args) {
        Factorial fact = a -> {
            int ans = 1;
            for(int i = a ; i > 0 ; i-- )
            {
                ans *= i;
            }
            return ans;
        };

        System.out.println("factorial of 7 is : "+fact.factorial(7));
    }
    
}
