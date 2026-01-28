//Program to print the result of removing duplicates from a given string.

import java.util.*;

class Program7{
	public static void main(String[] args){
//		String s = "Parth Parth Parth Vaghela Ayush Aditya Jenil Parth Aditya";
//		String uniqueString = new String();
//		HashSet<String> set = new HashSet<String>();
//		String[] strArr = s.split(" ");
//		for(int i = 0 ; i < strArr.length ; i++){
//			set.add(strArr[i]);
//		}
		
//		for(String str: set){	
//			uniqueString = uniqueString + str + " ";
//		}
		
//		System.out.println(uniqueString);

		String str = "My name is Parth";
		String res = "";
		for(int i = 0 ; i < str.length();i++){
			char ch = str.charAt(i);
			if(res.indexOf(ch) == -1 && ch != ' '){
				res += ch;
			}
		}
		
		System.out.println(res);
		
	}
}