//Program to create a class known as Person with methods called getFirstName() and getLastName(). 
//Create a subclass called Employee that adds a new method named getEmployeeId() and overrides the getLastName() method to include the employee's job title.

class Person{
	String firstName;
	String lastName;
	
	String getFirstName(){
		return this.firstName;
	}
	
	String getLastName(){
		return this.lastName;
	}
}

class Employee extends Person{
	private int employeeId;
	private String jobTitle;
	
	Employee(String firstName , String lastName , int employeeId , String jobTitle){
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeId = employeeId;
		this.jobTitle = jobTitle;
	}
	
	int getEmployeeId(){
		return this.employeeId;
	}
	
	String getLastName(){
		return this.lastName+ " " + this.jobTitle;
	}
}

class TestJobTitle{
	public static void main(String[] args){		
		Employee e = new Employee("Parth" , "Vaghela" , 101 , "Java Developer");
		int empId = e.getEmployeeId();
		String lastname = e.getLastName();
		
		System.out.println("EmployeeId : "+empId);
		System.out.println("LastName With Job Title : "+ lastname);
	}
}