// Program lambda expression to implement a lambda expression to calculate the factorial of a given number.

import java.util.function.UnaryOperator;

public class Program6 {
    public static void main(String[] args) {
        UnaryOperator<Integer> fact = x -> {
            int ans = 1;
            while(x > 0){
                ans *= x;
                x--;
            }
            return ans;
        };         

        System.out.println(fact.apply(5));

    }
}
