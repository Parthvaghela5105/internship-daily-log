//Program to create a vehicle class hierarchy. The base class should be Vehicle, with subclasses Truck, Car and Motorcycle. 
//Each subclass should have properties such as make, model, year, and fuel type. 
//Implement methods for calculating fuel efficiency, distance traveled, and maximum speed.

class Vehicle{
	String make;
	String model;
	int year;
	String fuelType;
	double fuelUsage;
	double distance;
	double maxSpeed;
	
	Vehicle(String make,String model,int year,String fuelType){
		this.make = make;
		this.model = model;
		this.year = year;
		this.fuelType = fuelType;
	}
	
	double fuelEfficiency(){
		if(fuelUsage == 0){
			return 0;
		}
		return distance/fuelUsage;
	}
	
	double distanceTravelled(double currentDist){
		return this.distance + currentDist;
	}
	
	double maximumSpeed(double currentSpeed){
		this.maxSpeed = Math.max(this.maxSpeed , currentSpeed);
		return this.maxSpeed;
	}
}

class Truck extends Vehicle{
	Truck(String make,String model,int year,String fuelType){
		super(make , model , year , fuelType );
	}
}
class Car extends Vehicle{	
	Car(String make,String model,int year,String fuelType){
		super(make , model , year , fuelType );
	}
}
class Motorcycle extends Vehicle{
	Motorcycle(String make,String model,int year,String fuelType){
		super(make , model , year , fuelType );
	}
}


class TestHierarchy{
	public static void main(String[] args){
		Truck t = new Truck("Tata" , "Top" , 2021 , "Diesel");
		System.out.println("Maximum speed of truck : "+t.maximumSpeed(40));
		System.out.println("Distance traveled by truck : "+t.distanceTravelled(1600));
		System.out.println("Fuel Efficiency of truck: "+t.fuelEfficiency());
	}
}