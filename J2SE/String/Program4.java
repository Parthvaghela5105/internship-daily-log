//Program to compare a given string to another string, ignoring case considerations.

class Program4{
	public static void main(String[] args){
		String s1 = new String("Parth");
		String s2 = new String("parth");
		String s3 = new String("PARTH");
		
		System.out.println(s1.equalsIgnoreCase(s2));
		System.out.println(s1.equalsIgnoreCase(s3));		
		
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
	}
}