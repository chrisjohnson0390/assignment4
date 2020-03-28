package com.meritamerica.assignment4;

public class DepositTransaction extends Transaction{
	
	BankAccount targetAccount;
	double amount;
	
	
	public DepositTransaction(BankAccount targetAccount, double amount) {
		this.targetAccount = targetAccount;
		this.amount = amount;
	}
// Coming back to class to apply a method if needed. ( If it needs to be an object)
}
