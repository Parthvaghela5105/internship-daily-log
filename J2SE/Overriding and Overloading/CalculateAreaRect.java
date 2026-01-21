//Program to create a class called Shape with a method called getArea(). 
//Create a subclass called Rectangle that overrides the getArea() method to calculate the area of a rectangle.

class Shape{
	double getArea(){
		return 0;
	}
}

class Rectangle extends Shape{
	
	private int width;
	private int length;
	
	Rectangle(int length , int width){
		this.length = length;
		this.width = width;
	}
	
	double getArea(){
		return length*width;
	}
}

class CalculateAreaRect{
	public static void main(String[] args){
		Shape rect = new Rectangle(10 , 20);
		double area = rect.getArea();
		System.out.println("Area : "+ area);
	}
}

