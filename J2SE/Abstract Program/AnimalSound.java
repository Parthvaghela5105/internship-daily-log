//Program to create an abstract class Animal with an abstract method called sound(). 
//Create subclasses Lion and Tiger that extend the Animal class and implement the sound() method to make a specific sound for each animal.

abstract class Animal{
	abstract void sound();
}

class Tiger{
	void sound(){
		System.out.println("Tiger Sound");
	}
}

class Lion{
	void sound(){
		System.out.println("Lion Sound");
	}
}

class AnimalSound{
	public static void main(String[] args){
		Tiger tiger = new Tiger();
		tiger.sound();
		
		Lion lion = new Lion();
		lion.sound();
	}
}



