//Program to check whether two String objects contain the same data.

class Program3{
	public static void main(String[] args){
		String s1 = new String("Parth");
		String s2 = new String("Parth");
		String s3 = new String("Parth doing coding");
		
		System.out.println(s1.equals(s2));		
		System.out.println(s1.equals(s3));		
	}
}