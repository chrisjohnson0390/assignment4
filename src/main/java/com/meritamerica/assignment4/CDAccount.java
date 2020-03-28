package com.meritamerica.assignment4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CDAccount extends BankAccount{
	
	CDOffering offerings;
	int term;

	public CDAccount(CDOffering offering, double openingBalance){
		super(openingBalance, offering.getInterestRate());
		this.offerings = offering;
		this.term = offering.getTerm();
	}
	
	public CDAccount(Long accountNumber, Double balance,
			Double interestRate, Date openedOn, int term) {
			super(accountNumber, balance, interestRate, openedOn);
			this.term = term;
	}
	
	public static CDAccount readFromString(String accountData) throws ParseException{
		try {
			String[] temp = accountData.split(",");
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(temp[3]);
			CDAccount newAccount =  new CDAccount(Long.valueOf(temp[0]),
					Double.valueOf(temp[1]),Double.valueOf(temp[2]),
					date, Integer.valueOf(temp[4]));
			return newAccount;
		}
		catch(Exception exception) {
			throw new NumberFormatException();
		}
	}
		
	public int getTerm() {
		return term;
	}

	public boolean withdraw(double amount) {
		return false;
	}
	
	public boolean deposit(double amount) {
		return false;
	}
	
	public String writeToString() {
		StringBuilder toString = new StringBuilder();
		toString.append(super.writeToString()).append(",");
		toString.append(term);
		return toString.toString();
	}

	public double futureValue() {	
		return futureValue(term);
	}

}