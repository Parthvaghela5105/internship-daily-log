//	Program to create an interface Shape with the getArea() method. Create three classes Rectangle, Circle, and Triangle that implement the Shape interface. 
//	Implement the getArea() method for each of the three classes.

interface Area{
	double getArea();
}

class Rectangle implements Area{
	double length;
	double width;
	
	Rectangle(double length , double width)
	{
		this.length = length;
		this.width = width;
	}
	
	public double getArea(){
		return length*width;
	}
}	
class Circle implements Area{
	double radius;
	
	Circle(double radius)
	{
		this.radius = radius;
	}
	
	public double getArea(){
		return 3.14*this.radius*this.radius;
	}
}	
class Triangle implements Area{
	double height;
	double base;
	
	Triangle(double height , double base)
	{
		this.height = height;
		this.base = base;
	}
	
	public double getArea(){
		return 0.5*this.height*this.base;
	}
}	


class CalculateArea{
	public static void main(String[] args){
		Rectangle r = new Rectangle(3 , 4);
		double area = r.getArea();
		System.out.println("Rectangle Area: "+area);
		
		Circle c = new Circle(3);
		area = c.getArea();
		System.out.println("Circle Area: "+area);
		
		Triangle t = new Triangle(3 , 4);
		area = t.getArea();
		System.out.println("Triangle Area: "+area);
	}
}