//# Program to create a class called Point with instance variables x and y. Implement overloaded constructors:
//    a. One constructor takes int parameters.
//    b. Another constructor takes double parameters.
//    c. Print the values of the variables for each constructor.

class Point{
	private double x;
	private double y;

	Point(double x , double y){
		this.x = x;
		this.y = y;
	}
	
	Point(int x , int y){
		this.x = x;
		this.y = y;
	}
	
	void printPoint(){
		System.out.println("X : "+this.x+" & y : "+ this.y);
	}
}

class PointTest{ 
	public static void main(String[] args){
		Point p1 = new Point(10 , 11);
		p1.printPoint();
		
		Point p2 = new Point(10.03 , 11.21);
		p2.printPoint();
	}
}