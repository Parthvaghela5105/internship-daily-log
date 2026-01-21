//Program to create an abstract class Employee with abstract methods calculateSalary() and displayInfo(). 
//Create subclasses Manager and Programmer that extend the Employee class and implement the respective methods 
//to calculate salary and display information for each role.


abstract class Employee{
	abstract void calculateSalary();
	abstract void displayInfo();
}

class Manager{
	void calculateSalary(int salary){
		double tex = salary * 0.12;
		System.out.println("Salary of Manager is "+ (salary-tex));
	}
	void displayInfo(){
		System.out.println("Manager Information");
	}
}

class Programmer{
	void calculateSalary(int salary){
		double tex = salary * 0.19;
		System.out.println("Salary of programmer is "+ (salary-tex));
	}
	void displayInfo(){
		System.out.println("programmer Information");
	}
}


class EmployeeManage{
	public static void main(String[] args){
		Programmer p = new Programmer();
		p.calculateSalary(30000);
		p.displayInfo();
		
		Manager m = new Manager();
		m.calculateSalary(30000);
		m.displayInfo();

	}
}