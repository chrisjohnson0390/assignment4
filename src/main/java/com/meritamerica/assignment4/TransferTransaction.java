package com.meritamerica.assignment4;

public class TransferTransaction {
	
	BankAccount sourceAccount;
	BankAccount targetAccount;
	double amount;
	
	public TransferTransaction(BankAccount sourceAccount, BankAccount targetAccount, double amount) {
		this.sourceAccount = sourceAccount;
		this.targetAccount = targetAccount;
		this.amount = amount;
	}

}
