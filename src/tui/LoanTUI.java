package tui;

import java.util.Date;
import controller.LoanController;
import model.Loan;

/**
 * LoanTUI is the user interface for loans.
 * */

public class LoanTUI {
	// instance variables
	LoanController loanController;
	
	/**
	 * Constructor for objects of the class LoanTUI
	 * */
	public LoanTUI() {
		loanController = new LoanController();
	}
	
	/**
	 * The start method makes a menu with createLoan as an option.
	 * */
	public void start() {
		//Boolean variable to control the loop
		boolean running = true;
		//infinite loop
		while (running) {
			//Calls the writeLoanMenu method and stores the result in the variable choice
			int choice = writeLoanMenu();
			//if the user chooses the first option in the menu
			if (choice == 1) {
				//call the createLoan method
				createLoan();
			}
			//TO DO - when there's a need for more menu items
			//If the user chooses any other option
			else {
				//exit the loop
				running = false;
			}
		}
	}
	
	/**
	 * 
	 * */
	

}
