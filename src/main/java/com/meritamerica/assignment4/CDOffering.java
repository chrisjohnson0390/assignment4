package com.meritamerica.assignment4;

public class CDOffering {
	
	int term;
	double interestRate;

	public CDOffering(int term, double interestRate){
		this.term = term;
		this.interestRate = interestRate;
	}

	public static CDOffering readFromString(String cdOfferingDataString){
		try {
			String[] temp = cdOfferingDataString.split(",");
			int tempTerm = Integer.valueOf(temp[0]);
			double tempInterestRate = Double.valueOf(temp[1]);
			CDOffering newAccount = new CDOffering(tempTerm, tempInterestRate);
			return newAccount;
		}
		catch(Exception exception) {
			throw new NumberFormatException();
		}
	}
	
	public int getTerm() {
		return term;
	}
	
	public String writeToString() {
		StringBuilder toString = new StringBuilder();
		toString.append(term).append(",").append(interestRate);
		return toString.toString();
	}
	
	public double getInterestRate() {
		return interestRate;
	}

}