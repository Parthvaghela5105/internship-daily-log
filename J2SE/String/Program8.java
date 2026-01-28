//Program to find the first non-repeating character in a string.

class Program8{
	public static void main(String[] args){
		String str = "my name is parth";
		char[] charCount = new char[27];
		for(int i = 0 ; i < str.length(); i++){
			char ch = str.charAt(i);
			if(ch != ' ')
				charCount[ch - 97]++;
		}
		
		for(int i = 0; i<str.length() ; i++){
			char ch = str.charAt(i);
			if(charCount[ch - 97] == 1){
				System.out.println(ch);
				break;
			}
		}
		
		//second approach
		
		for(int i = 0 ; i < str.length() ; i++){
			char ch = str.charAt(i);
			if(str.indexOf(ch) == str.lastIndexOf(ch)){
				System.out.println(ch);
				return;
			}
		}
	}
}