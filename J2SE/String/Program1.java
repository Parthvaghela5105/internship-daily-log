//Program to check whether a given string ends with another string.
//Example:
//"Python Exercises" ends with "se"? false                                                                      
//"Python Exercise" ends with "se"? true

class Program1{
	public static void main(String[] args){
		String s = new String("Python Exercises");
		System.out.println(s.endsWith("se"));
		
		String s1 = new String("Python Exercise");
		System.out.println(s1.endsWith("se"));
	}
}