package com.meritamerica.assignment4;

import java.util.ArrayList;
import java.util.List;

class FraudQueue {
	 
	/*
	 private Transaction arr[]; // Array to store the queue elements
	 private int front; //points to the element at the front of the Queue
	 private int rear; //points to last element in Queue
	 private int capacity; // size of the Queue
	 private int count;// current size of the Queue
	 
	 
	//Constructor to initialize Queue 
	 FraudQueue(int size){
		 arr = new Transaction[size]; // creating an array to pass the size of the Queue
		 capacity = size; 
		 front = 0 ; //pointer
		 rear = -1; //pointer
		 count = 0; //current size
	 }
	 
	 //Utility function to remove the front element
	 public void dequeue () {
		 //Check for underflow
		 if(isEmpty()) {
			 System.out.println("Program Terminated due to underflow.");
			 System.exit(1);
		 }
		 System.out.println("Removing " + arr[front]);
		 
		 front = (front + 1)% capacity; // Linear to Circular 
		 count--;
	 }
	 
	 //Utility function to add items to Queue
	 public void addTransaction (Transaction transaction) { // Possibly have to change int to transaction
		 //Check for overflow
		 if(isFull()) {
			 System.out.println("Program Terminated due to overflow.");
			 System.exit(1);
		 }
		 System.out.println("Inserting "+ transaction);
		 
		 rear = (rear + 1)% capacity;
		 arr[rear] = transaction;
		 count ++;
	 }
	 
	 //Utility function, return front element to the Queue
	 public Transaction getTransaction () {
		 if(isEmpty()) {
			 System.out.println("Program Terminated due to underflow.");
			 System.exit(1);
		 }
		 return arr[front];
		 
	 }
	 //Function to check size of the Queue
	 public int size() {
		 return count;
	 }
	 
	 //Utility function to check if Queue is empty
	 public boolean isEmpty() {
		 return (size() == 0); 
	 }
	 //Utility function to check if Queue is full
	 public boolean isFull() {
		 return (size()== capacity);
	 }
	 */
	/**
	 * Instance variable 
	 */
private List<Transaction> transactions = new ArrayList<Transaction>();
	/**
	 * A Constructor for Fraud Queue 
	 */
	FraudQueue(){
		
	}
	/**
	 * Method to add transaction to Fraud Queue
	 * @param transaction
	 */
	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}
	/**
	 * Return the transactions to the Fraud Queue
	 * @return
	 */
	public List<Transaction> getTransaction() {
		return transactions;
	}
	 
	 
	 
}
