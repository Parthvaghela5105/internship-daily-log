//Program to create an abstract class Vehicle with abstract methods startEngine() and stopEngine(). 
//Create subclasses Car and Motorcycle that extend the Vehicle class and implement the respective methods to start and stop the engines for each vehicle type.

abstract class Vehicle{
	abstract void startEngine();
	abstract void stopEngine();
}

class Car extends Vehicle{
	void startEngine(){
		System.out.println("Car Engine start");
	}
	void stopEngine(){
		System.out.println("Car Engine stop");		
	}
}

class Motorcycle extends Vehicle{
	void startEngine(){
		System.out.println("Motorcycle Engine start");
	}
	void stopEngine(){
		System.out.println("Motorcycle Engine stop");		
	}
}

class VehicleStartStop{
	
	public static void main(String[] args){
		Motorcycle m = new Motorcycle();
		m.startEngine();
		m.stopEngine();
		
		Car c = new Car();
		c.startEngine();
		c.stopEngine();
	}
	
}