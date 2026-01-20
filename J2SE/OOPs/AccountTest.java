//  Program to create a class called Account with instance variables accountNumber and balance. 
//  Implement a parameterized constructor that initializes these variables with validation:
//    a. accountNumber should be non-null and non-empty.
//    b. balance should be non-negative.
//    c. Print an error message if the validation fails

class Account{
	private int accountNumber;
	private double balance;
	
	Account(int accountNumber , double balance){
		if(balance < 0)
			System.out.println("Balance should be non-negative");
		else{			
			this.accountNumber = accountNumber;
			this.balance = balance;
			System.out.println("Account Created Successfully");
		}
	}	
	
	Account(double balance){
		System.out.println("accountNumber should be non-null and non-empty");
	}
}

class AccountTest{
	public static void main(String[] args){
		Account ac = new Account(12 , 1367.23);
		Account ac1 = new Account(1367.23);
		Account ac2 = new Account(12 , -1);
		
	}
}