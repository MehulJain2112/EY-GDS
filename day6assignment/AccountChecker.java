package com.ey.day6assignment;
//Assignment 5 
public class AccountChecker {
	private BankAccount[] accounts;
	
	public AccountChecker() {
		accounts = new BankAccount[5];
		try {
			accounts[0] = new BankAccount(101,"Mehul","Savings",1500);
			accounts[1] = new BankAccount(102,"MehulJain","Current",8000);
			accounts[2] = new BankAccount(103,"Chikoo","Savings",1200);
			accounts[3] = new BankAccount(104,"ChikooJain","Current",10000);
			accounts[4] = new BankAccount(105,"MehulMJain","Savings",2500);
		} catch (Exception e) {
			System.out.println("Exception : "+e.getMessage());
		}
	}
	
	public boolean isValidAccount(int accno) throws AccountNotFoundException {
		for(BankAccount account :accounts) {
			if(account!=null && account.getAccno()==accno)
				return true;
		}
		throw new AccountNotFoundException("Account with Acc no "+accno+" not found");
	}
	
	public static void main(String[] args) {
		AccountChecker checker = new AccountChecker();
		int[] testAccountNumbers = {101,106,103,107,102};
		
		for(int accno:testAccountNumbers) {
			try {
				if(checker.isValidAccount(accno))
					System.out.println("Account number "+accno+" is valid");
			} 
			catch (AccountNotFoundException e) {
				System.out.println("Exception : "+e.getMessage());
			}
		}
	}
}
