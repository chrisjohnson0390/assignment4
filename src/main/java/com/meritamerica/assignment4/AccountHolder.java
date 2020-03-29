package com.meritamerica.assignment4;

import java.util.Arrays;

public class AccountHolder implements Comparable<AccountHolder>{
	/**
	 * Instance Variables
	 **/
	String firstName;
	String middleName;
	String lastName;
	String ssn;
	CheckingAccount[] checkingArray = new CheckingAccount[0];
	SavingsAccount[] savingsArray = new SavingsAccount[0];
	CDAccount[] cdAccountArray = new CDAccount[0];
	
	/**
	 * General constructor to create an Account Holder
	 * @param firstName is First Name of Account Holder
	 * @param middleName is Middle Name of Account Holder 
	 * @param lastName is Last Name of Account Holder
	 * @param ssn is Social Security Number of Account Holder  
	 */
	public AccountHolder(String firstName, String middleName, String lastName, String ssn) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.ssn = ssn;
	}
	
	/**
	 * A method to read from an external string the data for an Account Holder.
	 * @throws potential exception if the passed string is not properly formatted. 
	 * @param accountHolderData is the Account Data being passed through it.
	 */

	public static AccountHolder readFromString(String accountHolderData) throws Exception{
		try {
			String[] holding = accountHolderData.split(",");
			AccountHolder newAccount =  new AccountHolder(holding[0], holding[1], holding[2], holding[3]);
			return newAccount;
		}
		catch(Exception exception) {
			throw new Exception();
		}
	}
	/**
	 * This is a method to add a new Checking Account for an Account Holder
	 * @param openingBalance is the current balance in the account
	 * @throws potential exception if the Account Holder is attempting to open a new account and the combined balance exceeds the limit,
	 * Or if the the user is trying to withdraw/deposit a negative amount, or making a transaction greater than $1000
	 * Creates a new Checking Account for Account Holder, and validates if transaction is following bank protocols. 
	 * @return a new account
	 */
	public CheckingAccount addCheckingAccount(double openingBalance) throws ExceedsCombinedBalanceLimitException, ExceedsFraudSuspicionLimitException, NegativeAmountException{
		if(getCheckingBalance() + getSavingsBalance() + openingBalance >= 250000) {
			throw new ExceedsCombinedBalanceLimitException("Aggregate balance of your Checking and Savings accounts exceeds $250,000.");
		}
		
		CheckingAccount newAccount = new CheckingAccount(openingBalance);
		DepositTransaction transaction = new DepositTransaction(newAccount, openingBalance);
		try{
			MeritBank.processTransaction(transaction);
		}
		catch(NegativeAmountException exception) {
			throw new NegativeAmountException("Can not deposit/withdraw a negative amount");
		}
		catch(ExceedsFraudSuspicionLimitException exception) {
			throw new ExceedsFraudSuspicionLimitException("Transaction exceeds $1000.00 and must be reviewed prior to processing");
		}
		catch(Exception exception) {
			
		}
		/* A manual way to create the array.copy method.
		* Creating a temp array that will look identical to the old array with an additional null index at the end
		* then sets the newly created account to the null index/ last index.
		*/
		CheckingAccount[] holding = new CheckingAccount[checkingArray.length + 1];
		for(int i = 0; i<checkingArray.length; i++) {
			holding[i] = checkingArray[i];
		}
		holding[holding.length - 1] = newAccount;
		checkingArray = holding;
		return newAccount;
	}
	/**
	 * This method adds a Checking Account for an AccountHolder
	 * @param checkingAccount
	 * Checking Account object created.
	 * @return a Checking Account 
	 * @throws ExceedsCombinedBalanceLimitException
	 * @throws NegativeAmountException
	 * @throws ExceedsFraudSuspicionLimitException
	 */
	public CheckingAccount addCheckingAccount(CheckingAccount checkingAccount) throws ExceedsCombinedBalanceLimitException, NegativeAmountException, ExceedsFraudSuspicionLimitException{
		if(getCheckingBalance() + getSavingsBalance() + checkingAccount.getBalance() >= 250000) {
			throw new ExceedsCombinedBalanceLimitException("Aggregate balance of your Checking and Savings accounts exceeds $250,000.");
		}
		DepositTransaction transaction = new DepositTransaction(checkingAccount, checkingAccount.getBalance());
		try{
			MeritBank.processTransaction(transaction);
		}
		catch(NegativeAmountException exception) {
			throw new NegativeAmountException("Can not deposit/withdraw a negative amount");
		}
		catch(ExceedsFraudSuspicionLimitException exception) {
			throw new ExceedsFraudSuspicionLimitException("Transaction exceeds $1000.00 and must be reviewed prior to processing");
		}
		catch(Exception exception) {
			
		}
		
		/* A manual way to create the array.copy method.
		* Creating a temp array that will look identical to the old array with an additional null index at the end
		* then sets the newly created account to the null index/ last index.
		*/
		
		CheckingAccount[] holding = new CheckingAccount[checkingArray.length + 1];
		for(int i = 0; i<checkingArray.length; i++) {
			holding[i] = checkingArray[i];
		}
		holding[holding.length - 1] = checkingAccount;
		checkingArray = holding;
		return checkingAccount;
	}
	
	/**
	 * A method to add a Saving account that takes an Opening Balance 
	 * @param openingBalance
	 * @return a new Savings Account 
	 * @throws ExceedsCombinedBalanceLimitException
	 * @throws NegativeAmountException
	 * @throws ExceedsFraudSuspicionLimitException
	 */
	public SavingsAccount addSavingsAccount(double openingBalance) throws ExceedsCombinedBalanceLimitException, NegativeAmountException, ExceedsFraudSuspicionLimitException{
		if(getCheckingBalance() + getSavingsBalance() + openingBalance >= 250000) {
			throw new ExceedsCombinedBalanceLimitException("Aggregate balance of your Checking and Savings accounts exceeds $250,000.");
		}
		SavingsAccount newAccount = new SavingsAccount(openingBalance);
		
		DepositTransaction transaction = new DepositTransaction(newAccount, openingBalance);
		
		try{
			MeritBank.processTransaction(transaction);
		}
		catch(NegativeAmountException exception) {
			throw new NegativeAmountException("Can not deposit/withdraw a negative amount");
		}
		catch(ExceedsFraudSuspicionLimitException exception) {
			throw new ExceedsFraudSuspicionLimitException("Transaction exceeds $1000.00 and must be reviewed prior to processing");
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
		
		/* A manual way to create the array.copy method.
		* Creating a temp array that will look identical to the old array with an additional null index at the end
		* then sets the newly created account to the null index/ last index.
		*/
		
		SavingsAccount[] holding = new SavingsAccount[savingsArray.length + 1];
		for(int i = 0; i<savingsArray.length; i++) {
			holding[i] = savingsArray[i];
		}
		holding[holding.length - 1] = newAccount;
		savingsArray = holding;
		return newAccount;
	}
	/**
	 * A method that adds a Savings Account with a previously  instantiated Savings Object 
	 * @param savingsAccount
	 * @return a Savings Account 
	 * @throws ExceedsCombinedBalanceLimitException
	 * @throws ExceedsFraudSuspicionLimitException
	 * @throws NegativeAmountException
	 */
	public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) throws ExceedsCombinedBalanceLimitException, ExceedsFraudSuspicionLimitException, NegativeAmountException{
		if(getCheckingBalance() + getSavingsBalance() + savingsAccount.getBalance()>= 250000) {
			throw new ExceedsCombinedBalanceLimitException("Aggregate balance of your Checking and Savings accounts exceeds $250,000.");
		}
		DepositTransaction transaction = new DepositTransaction(savingsAccount, savingsAccount.getBalance());
		try{
			MeritBank.processTransaction(transaction);
		}
		catch(NegativeAmountException exception) {
			throw new NegativeAmountException("Can not deposit/withdraw a negative amount");
		}
		catch(ExceedsFraudSuspicionLimitException exception) {
			throw new ExceedsFraudSuspicionLimitException("Transaction exceeds $1000.00 and must be reviewed prior to processing");
		}
		catch(Exception exception) {
			
		}
		
		/* A manual way to create the array.copy method.
		* Creating a temp array that will look identical to the old array with an additional null index at the end
		* then sets the newly created account to the null index/ last index.
		*/
		
		SavingsAccount[] holding = new SavingsAccount[savingsArray.length + 1];
		for(int i = 0; i<savingsArray.length; i++) {
			holding[i] = savingsArray[i];
		}
		holding[holding.length - 1] = savingsAccount;
		savingsArray = holding;
		return savingsAccount;

	}
	/**
	 * A method to add a new CD Account 
	 * @param offering
	 * @param openingBalance
	 * @return new CD account 
	 * @throws NegativeAmountException
	 * @throws ExceedsFraudSuspicionLimitException
	 */
	public CDAccount addCDAccount(CDOffering offering, double openingBalance) throws NegativeAmountException, ExceedsFraudSuspicionLimitException{
		if(offering == null) {
			return null;
		}
		CDAccount newAccount = new CDAccount(offering, openingBalance);
		DepositTransaction transaction = new DepositTransaction(newAccount, openingBalance);
		try{
			MeritBank.processTransaction(transaction);
		}
		catch(NegativeAmountException exception) {
			throw new NegativeAmountException("Can not deposit/withdraw a negative amount");
		}
		catch(ExceedsFraudSuspicionLimitException exception) {
			throw new ExceedsFraudSuspicionLimitException("Transaction exceeds $1000.00 and must be reviewed prior to processing");
		}
		catch(Exception exception) {
			
		}
		
		// Similar to manual portion of creating an array 1 index larger.
		CDAccount[] holding = Arrays.copyOf(cdAccountArray, cdAccountArray.length+1);
		
		for(int i = 0; i<cdAccountArray.length; i++) {
			holding[i] = cdAccountArray[i];
		}
		holding[holding.length - 1] = newAccount;
		cdAccountArray = holding;
		return newAccount;
	}
	/**
	 * A method for creating a CD Account with a previously instantiated CD Account Object 
	 * @param cdAccount
	 * @return
	 * @throws NegativeAmountException
	 * @throws ExceedsFraudSuspicionLimitException
	 */
	public CDAccount addCDAccount(CDAccount cdAccount) throws NegativeAmountException, ExceedsFraudSuspicionLimitException {
		DepositTransaction transaction = new DepositTransaction(cdAccount, cdAccount.getBalance());
		try{
			MeritBank.processTransaction(transaction);
		}
		catch(NegativeAmountException exception) {
			throw new NegativeAmountException("Can not deposit/withdraw a negative amount");
		}
		catch(ExceedsFraudSuspicionLimitException exception) {
			throw new ExceedsFraudSuspicionLimitException("Transaction exceeds $1000.00 and must be reviewed prior to processing");
		}
		catch(Exception exception) {
			
		}
		CDAccount[] holding = Arrays.copyOf(this.cdAccountArray,this.cdAccountArray.length+1);
		for(int i = 0; i<this.cdAccountArray.length; i++) {
			holding[i] = this.cdAccountArray[i];
		}
		holding[holding.length - 1] = cdAccount;
		this.cdAccountArray = holding;
		return cdAccount;
	}
	/**
	 * A method that gets the combined balance of CD,Savings, and Checking Accounts.
	 * @return aggregate  combined balance
	 */
	public double getCombinedBalance() {
		return getCDBalance() + getSavingsBalance() + getCheckingBalance();
	}
	/**
	 *A method that sorts the Account Holders by balance; highest to lowest 
	 * @param account
	 * @return The Account with the biggest balance will return 1, while the smallest is -1
	 */
	@Override
	public int compareTo(AccountHolder account) {
		if(this.getCombinedBalance() > account.getCombinedBalance()) {
			return 1;
		}
		return -1;
	}
	
	/**
	 * Getters for instance variables
	 * @return instance variables 
	 */
	public String getFirstName() {
		return firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getSSN() {
		return ssn;
	}
	
	public CheckingAccount[] getCheckingAccounts() {
		return checkingArray;
	}
	
	public int getNumberOfCheckingAccounts() {
		return checkingArray.length;
	}
	
	public double getCheckingBalance() {
		int i;
		double total = 0.0;
		for(i = 0; i < checkingArray.length; i++) {
			total += checkingArray[i].getBalance();
		}
		return total;
	}
	
	public SavingsAccount[] getSavingsAccounts() {
		return savingsArray;
	}

	public int getNumberOfSavingsAccounts() {
		return savingsArray.length;
	}
	
	public double getSavingsBalance() {
		double total = 0.0;
		for(SavingsAccount balance : savingsArray) {
			total += balance.getBalance();
		}
		return total;
	}
	
	public CDAccount[] getCDAccounts() {
		return cdAccountArray;
	}

	public int getNumberOfCDAccounts() {
		return cdAccountArray.length;
	}

	public double getCDBalance() {
		double total = 0.0;
		for(CDAccount balance : cdAccountArray) {
			total += balance.getBalance();
		}
		return total;
	}
	/**
	 * Setters for instance variables
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setSSN(String ssn) {
		this.ssn = ssn;
	}
	/**
	 * Method for  writing information for Account Holder into a String
	 * @return String information
	 */
	public String writetoString() {
		StringBuilder toString = new StringBuilder();
		toString.append(firstName).append(",");
		toString.append(middleName).append(",");
		toString.append(lastName).append(",");
		toString.append(ssn);
		return toString.toString();
	}
}
