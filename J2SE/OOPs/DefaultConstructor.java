//# Program to create a class called "Cat" with instance variables name and age. 
// Implement a default constructor that initializes the name to "Unknown" and the age to 0. 
// Print the values of the variables.


class Cat{
	private int age;
	private String name;
	
	Cat(){
		this.age = 0;
		this.name = "unknown";
	}
	
	public void printCat(){
		System.out.println("Name : " + this.name + " & Age : "+ this.age);
	}
}

class DefaultConstructor{
	public static void main(String[] args){
		Cat obj = new Cat();
		obj.printCat();
	}
}