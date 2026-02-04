//Program to implement a lambda expression to find the sum of two integers

import java.util.function.BiFunction;

class Program1{
    public static void main(String[] args) {
        BiFunction<Integer,Integer,Integer> biFunction = (x , y) -> x + y;
        System.out.println("Sum by biFunction functional interface :"+ biFunction.apply(10, 20));

    }
}