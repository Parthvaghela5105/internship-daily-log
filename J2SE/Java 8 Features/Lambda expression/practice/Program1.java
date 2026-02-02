
@FunctionalInterface
interface SumCalculator{
    int sum(int a , int b);
}


class Program1{
    public static void main(String[] args) {
        SumCalculator sumCalc = (a , b) -> a+b;

        int result = sumCalc.sum(10 , 20);
        System.out.println(result);
    }
}


