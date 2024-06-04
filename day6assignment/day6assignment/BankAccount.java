package com.ey.day6assignment;

// Assignment 4 Continuation 
class AccountNotFoundException extends Exception {
	public AccountNotFoundException(String message) {
		super(message);
	}
}

class InvalidAmountException extends Exception {
	public InvalidAmountException(String message) {
		super(message);
	}
}

class InsufficientFundException extends Exception {
	public InsufficientFundException(String message) {
		super(message);
	}
}

class LowBalanceException extends Exception {
	public LowBalanceException(String message) {
		super(message);
	}
}

public class BankAccount {
	
	private int accno;
	private String custName;
	private String accType;
	private float balance;
	
	public BankAccount(int accno, String custName, String accType, float balance)
			throws InvalidAmountException,LowBalanceException {
		
		if(balance<0)
			throw new InvalidAmountException("Initial Balance cannot be Negative");
		if(accType.equalsIgnoreCase("Savings") && balance<1000)
			throw new LowBalanceException("Initial Balance for Savings Acc must be Atleast Rs.1000");
		if(accType.equalsIgnoreCase("Current") && balance<5000)
			throw new LowBalanceException("Initial Balance for Current Acc must be Atleast Rs.5000");
		
		this.accno = accno;
		this.custName = custName;
		this.accType = accType;
		this.balance = balance;
	}
	
	public int getAccno() {
		return accno;
	}
	
	public void deposit(float amount) throws InvalidAmountException {
		if(amount<0)
			throw new InvalidAmountException("Deposit Amount cannot be Negative");
		balance+=amount;
	}
	
	public void withdraw(float amount) throws InvalidAmountException,InsufficientFundException {
		if(amount<0)
			throw new InvalidAmountException("Withdrawl Amount cannot be Negative");
		if(accType.equalsIgnoreCase("Savings") && (balance-amount)<1000)
			throw new InsufficientFundException("Insufficient funds. Minimum balance for Saving Acc=Rs.1000");
		if(accType.equalsIgnoreCase("Current") && (balance-amount)<5000)
			throw new InsufficientFundException("Insufficient funds. Minimum balance for Current Acc=Rs.5000");
		
		balance-=amount;
	}
	
	public float getBalance() {
		return balance;
	}
	
	public static void main(String[] args) {
		try {
			BankAccount acc1 = new BankAccount(101,"Mehul","Savings",1500);
			System.out.println("Initial Balance : "+acc1.getBalance());
			acc1.deposit(500);
			System.out.println("Balance after Deosit : "+acc1.getBalance());
			acc1.withdraw(700);
			System.out.println("Balance after Withdraw : "+acc1.getBalance());
			acc1.withdraw(1500);
			System.out.println("Balance after Withdraw : "+acc1.getBalance());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		BankAccount acc2 = null;
		
		try {
			acc2 = new BankAccount(102,"MehulJain","Current",500);
			System.out.println(acc2.getBalance());
		} catch (Exception e) {
			System.out.println("\n"+e.getMessage());
		}
	}
}
