//Program to create an abstract class Animal with abstract methods eat() and sleep(). 
//Create subclasses Lion, Tiger, and Deer that extend the Animal class and implement the eat() and sleep() methods differently based on their specific behavior.

abstract class Animal{
	abstract void eat();
	abstract void sleep();
}

class Lion extends Animal{
	void eat(){
		System.out.println("Lion eats Animals");
	}
	void sleep(){
		System.out.println("Lion sleeps in Afternoon");
	}
}

class Tigor extends Animal{
	void eat(){
		System.out.println("Tigor eats Animals");
	}
	void sleep(){
		System.out.println("Tigor sleeps in Morning");
	}
}

class Deer extends Animal{
	void eat(){
		System.out.println("Deer eats grass and plants");
	}
	void sleep(){
		System.out.println("deer sleeps in night and their sleep is lightly");
	}
}

class AnimalBehavior{
	public static void main(String[] args){
		Lion l = new Lion();
		l.eat();
		l.sleep();
		
		Tigor t = new Tigor();
		t.eat();
		t.sleep();
		
		Deer d = new Deer();
		d.eat();
		d.sleep();
	}
}