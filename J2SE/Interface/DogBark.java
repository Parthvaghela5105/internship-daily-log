//Program to create a Animal interface with a method called bark() that takes no arguments and returns void. 
//Create a Dog class that implements Animal and overrides speak() to print "Dog is barking"

interface Animal{
	void speak();
}

class Dog implements Animal{
	public void speak(){
		System.out.println("Dog is barking");
	}
}

class DogBark{
	public static void main(String[] args){
		Dog d = new Dog();
		d.speak();
		
	}
}