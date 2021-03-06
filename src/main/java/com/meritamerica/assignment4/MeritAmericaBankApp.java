package com.meritamerica.assignment4;

import java.text.ParseException;
/**
 * main point of entry
 * @author Chris and Xavier 
 *
 */
public class MeritAmericaBankApp {
	public static void main(String[] args) throws ParseException, ExceedsCombinedBalanceLimitException, ExceedsFraudSuspicionLimitException, NegativeAmountException, ExceedsAvailableBalanceException {
		MeritBank.readFromFile("src/test/testMeritBank_good.txt");	
		MeritBank.writeToFile("src/main/MeritBank.txt");
	}
}