//Program to count and print all duplicates in the input string.

class Program9{
	public static void main(String[] args){	
		String str = "my name is parth";
		char[] charCount = new char[26];
		
		for(int i = 0 ; i < str.length(); i++){
			char ch = str.charAt(i);
			if(ch != ' ')
				charCount[ch - 'a']++;
		}
		
		for(char ch = 'a' ; ch <= 'z' ; ch++){
			if(charCount[ch - 'a'] > 1){
				System.out.println(ch + " : " + (int)charCount[ch - 'a']);
			}
		}
	}
}