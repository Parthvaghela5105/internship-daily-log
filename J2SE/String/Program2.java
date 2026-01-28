//Program to check whether a given string starts with another string.

class Program2{
	public static void main(String[] args){
		String s = new String("Python Exercises");
		System.out.println(s.startsWith("Py"));
		
		String s1 = new String("Python Exercise");
		System.out.println(s1.startsWith("se"));
	}
}