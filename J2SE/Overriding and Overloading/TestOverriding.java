//Program to create a class called Vehicle with a method called drive(). 
//Create a subclass called Car that overrides the drive() method to print "Repairing a car".

class Vehicle{
	public void drive(){
		System.out.println("Driving Vehicle");
	}
}

class Car extends Vehicle{
	public void drive(){
		System.out.println("Repairing car");
	}
}

class TestOverriding{
	public static void main(String[] args)
	{
		Vehicle car = new Car();
		car.drive();
	}
	
}