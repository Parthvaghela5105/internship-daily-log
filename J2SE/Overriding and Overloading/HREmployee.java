//Program to create a class called Employee with methods called work() and getSalary(). 
//Create a subclass called HRManager that overrides the work() method and adds a new method called addEmployee()


class Employee{
	String name;
	double salary;
	
	Employee(){
		
	}
	
	Employee(String name , double salary ){
		this.name =name;
		this.salary = salary;
	}
	
	void work(){
		System.out.println("Employee doing the work");
	}
	
	void getSalary(){
		System.out.println(this.salary);
	}
}

class HRManager extends Employee{
	HRManager(){
		System.out.println("HR Object Created");
	}
	
	HRManager(String name , double salary){
		super(name , salary);
	}
	
	void work(){
		System.out.println("HRManager doing the work");
	}
	
	Employee addEmployee(String name , double salary){
		Employee emp = new Employee(name , salary);
		return emp;
	}
}

class HREmployee{
	public static void main(String[] args){
		HRManager hr = new HRManager();
		hr.work();
		Employee parth = hr.addEmployee("Parth" , 30000);
		parth.getSalary();
	}
}