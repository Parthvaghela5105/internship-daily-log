//Program to create an abstract class BankAccount with abstract methods deposit() and withdraw().
//Create subclasses: SavingsAccount and CurrentAccount that extend the BankAccount class and implement 
//the respective methods to handle deposits and withdrawals for each account type

abstract class BankAccount{
	int accountNumber;
	double balance;

	BankAccount(int accountNumber,double balance){
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
		
	abstract double deposit(double amount);
	abstract double withdraw(double amount);
}

class CurrentAccount extends BankAccount{
	CurrentAccount(int accountNumber,double balance){
		super(accountNumber , balance);
	}
	
	double deposit(double amount){
		this.balance += amount;
		System.out.println("Deposited amount : "+ amount);
		return amount;
	}
	
	double withdraw(double amount){
		if(balance < amount){
			System.out.println("sufficient balance is not available");
		}else{			
			this.balance -= amount;
			System.out.println("withdraw amount : "+ amount);
			return amount;
		}
		return 0;
	}
	
}

class SavingAccount extends BankAccount{
	SavingAccount(int accountNumber,double balance){
		super(accountNumber , balance);
	}
	
	double deposit(double amount){
		this.balance += amount;
		System.out.println("Deposited amount : "+ amount);
		return amount;
	}
	
	double withdraw(double amount){
		if(balance < amount){
			System.out.println("sufficient balance is not available");
		}else{			
			this.balance -= amount;
			System.out.println("withdraw amount : "+ amount);
			return amount;
		}
		return 0;
	}
	
}



class AccountManage{
	public static void main(String[] args){
		SavingAccount ac = new SavingAccount(101 , 10000);
		ac.deposit(1000);
		ac.withdraw(100);
	}
}