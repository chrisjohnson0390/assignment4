package com.meritamerica.assignment4;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BankAccount {
	
	double balance;
	double interestRate;
	Date accoutOpenedOn;
	long accountNumber;
	List<Transaction> transactions = new ArrayList<Transaction>();
	
	public BankAccount(double balance, double interestRate){
		this.balance = balance;
		this.interestRate = interestRate;
		accoutOpenedOn = new Date();
		accountNumber = MeritBank.getNextAccountNumber();
	}
	
	public BankAccount(double balance, double interestRate, Date accountOpenedOn){
		this.balance = balance;
		this.interestRate = interestRate;
		accoutOpenedOn = accountOpenedOn;
		accountNumber = MeritBank.getNextAccountNumber();
	}
	
	public BankAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn){
		this.balance = balance;
		this.interestRate = interestRate;
		accoutOpenedOn = accountOpenedOn;
		this.accountNumber = accountNumber;
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return balance;
		
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public Date getOpenedOn(){
		return accoutOpenedOn;
	}
	
	public boolean withdraw(double amount) {
		if(amount > 0 && amount < balance) {
			balance -= amount;
			return true;
		}
		return false;
	}
	
	public boolean deposit (double amount) {
		if(amount > 0) {
			balance += amount;
			return true;
		}
		return false;
	}
	
	public double futureValue(int years) {
		return balance * Math.pow(1 + interestRate, years);
	}
	
	public String writeToString() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder toString = new StringBuilder();
		toString.append(accountNumber).append(",");
		toString.append(balance).append(",");
		toString.append(interestRate).append(",");
		toString.append(format.format(accoutOpenedOn));
		return toString.toString();
	}
	
	public void addTransaction(Transaction transaction) {
		this.transactions.add(transaction);
	}
	
	public List<Transaction> getTransactions(){
		return transactions;
	}

}
