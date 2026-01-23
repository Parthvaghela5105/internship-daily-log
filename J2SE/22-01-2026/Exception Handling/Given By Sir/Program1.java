//Program that throws an exception and catch it using a try-catch block.

class Program1{
	public static void main(String[] args){
		try{
			System.out.println(100/0);
		}catch(ArithmeticException e){
			e.printStackTrace();
			System.out.println(e.toString());
		}
	}
}