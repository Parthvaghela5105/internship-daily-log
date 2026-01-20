//Program to create a class called Dog with instance variables name and color. 
//Implement a parameterized constructor that takes name and color as parameters and initializes the instance variables. 
//Print the values of the variables

class Dog{
	private String name;
	private String color;
	
	Dog(String name , String color){
		this.name = name;
		this.color = color;
	}
	
	public void printDog(){
		System.out.println("Name : " + this.name + " & Color : "+ this.color);
	}
}

class DefaultAndParameterized{
	public static void main(String[] args){
		Dog obj = new Dog("labra" , "Black");
		obj.printDog();
	}
}