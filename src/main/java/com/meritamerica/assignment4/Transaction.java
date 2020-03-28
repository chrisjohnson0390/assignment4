package com.meritamerica.assignment4;
import java.util.Date;
public abstract class Transaction {
	
	double amount;
	BankAccount sourceAccount;
	BankAccount targetAccount;
	Date transactionDate;
	
	
	
	public BankAccount getSourceAccount() {
		return sourceAccount;
		
	}
	
	public void setSourceAccount(BankAccount account) {
		this.sourceAccount = account;
	}
	
	public BankAccount getTargetAccount() {
		return targetAccount;
	}
	
	public void setTargetAccount(BankAccount account) {
		this.targetAccount = account;
	}
	
	public double getAmount() {
		return  amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public java.util.Date getTransactionDate(){
		return transactionDate;
	}
	
	public void setTransactionData(java.util.Date date) {
		this.transactionDate= date;
	}
	
	public String writeToString() {
		
	}
	
	public static Transaction readFromString (String transactionDataString) {
		
	}

}
