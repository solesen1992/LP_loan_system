package model;

import java.util.ArrayList;

/**
 * * This class contains a list of loans and a static instance of LoanContainer.
 * * */

public class LoanContainer {
	// List to store Loan objects
	private ArrayList<Loan> loans;
	// Static instance of LoanContainer for Singleton pattern
	private static LoanContainer instance;
	
	/**
	 * Private constructor ensures the object is created only within the class.
	 * Singleton pattern
	 * */
	private LoanContainer() {
		//Initialize the loan list
		loans = new ArrayList<>();
	}
	
	/**
	  * This method will return the LoanContainer instance if it already exists,
	  * if not, it will create a new LoanContainer.
	  * @return the singleton instance of LoanContainer
	  */
	public static LoanContainer getInstance() {
		// Checks if the instance is null
		if (instance == null) {
			// If null, create a new LoanContainer
			instance = new LoanContainer();
		}
		// Returns the existing or new instance
		return instance;
	}
	
	/**
	  * This method will add a loan to LoanContainer.
	  * @param loan the loan to be added
	  * @return true if there is a loan to add
	  */
	public boolean addLoan(Loan loan) {
		// Adds the loan to the loans list
		loans.add(loan);
		// Returns true indicating the loan was added
		return true;	
	}
}