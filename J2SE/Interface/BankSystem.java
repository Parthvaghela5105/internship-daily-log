//Program to create a banking system with two classes - SavingsAccount, and CurrentAccount. 
//The bank should have a list of accounts and methods for adding them. Accounts should be an interface 
//Account with methods to deposit, withdraw, calculate interest, and view balances. 
//SavingsAccount and CurrentAccount should implement the Account interface and have their own unique methods.

interface Account{
	void deposit(int amount);
	void withdraw(int amount);
	void calculateInterst(int amount,int year);
	void viewBalance();
}

class AccountInfo{
	int accountNo;
	double balance;
	
	AccountInfo(int accountNo , double balance){
		this.accountNo = accountNo;
		this.balance = balance;
	}
	
}

class SavingsAccount extends AccountInfo implements Account{
	SavingsAccount(int accountNo , double balance){
		super(accountNo , balance);
	}
	
	public void deposit(int amount){
		balance += amount;
		System.out.println(amount +" debited successfully");
	}
	
	public void withdraw(int amount){
		balance -= amount;
		System.out.println(amount +" withdraw successfully");
	}
	
	public void viewBalance(){
		System.out.println(balance+ " is present in given Account Number "+ accountNo );
	}
	
	public void calculateInterst(int amount , int year){
		int interest = (amount * year * 8)/100;
		System.out.println("Interest of "+ amount + " is "+interest);
	}
}

class CurrentAccount extends AccountInfo implements Account{
	CurrentAccount(int accountNo , double balance){
		super(accountNo , balance);
	}
	
	public void deposit(int amount){
		balance += amount;
		System.out.println(amount +" debited successfully");
	}
	
	public void withdraw(int amount){
		balance -= amount;
		System.out.println(amount +" withdraw successfully");
	}
	
	public void viewBalance(){
		System.out.println(balance+ " is present in given Account Number "+ accountNo );
	}
	
	public void calculateInterst(int amount , int year){
		int interest = (amount * year * 4)/100;
		System.out.println("Interest of "+ amount + " is "+interest);
	}
}



class BankSystem{
	public static void main(String[] args){
		SavingsAccount ac = new SavingsAccount(101 , 35000);
		ac.deposit(5000);
		ac.withdraw(500);
		ac.calculateInterst(12000 , 2);
		ac.viewBalance();
		
		CurrentAccount ac1 = new CurrentAccount(102 , 100000);
		ac1.deposit(25000);
		ac1.withdraw(50000);
		ac1.calculateInterst(12000 , 2);
		ac1.viewBalance();	
		
	}
}