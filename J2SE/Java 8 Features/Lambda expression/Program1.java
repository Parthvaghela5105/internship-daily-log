//Program to implement a lambda expression to find the sum of two integers.

interface CalculateSum{
    int sum(int a , int b);
}

class Program1{
    public static void main(String[] args) {
        

        CalculateSum sumLambda = (a , b) -> a + b;

        System.out.println("sum of a and b : "+sumLambda.sum(10 , 20));
    }
}