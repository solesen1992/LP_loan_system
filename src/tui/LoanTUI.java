package tui;

import java.util.Date;
import controller.LoanController;
import model.Loan;

/**
 * LoanTUI is the user interface for loans. It provides a simple text-based interface for users to create
 * and manage loans. It relies on the LoanController to handle the actual loan logic and operations. 
 * The interface allows users to create a new loan, input necessary details, and view the 
 * loan information upon successful creation.
 * 
 * The start() method manages the main loop of the user interface. It continuously displays a menu
 * and processes user choices. It calls 'createLoan()' if the user chooses to create a loan.
 * 
 * createLoan() handles the creation of a new loan.
 * 
 * writeLoanMenu() displays the loan menu and prompts the user for a choice. It returns the users choice.
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
			//TODO: - when there's a need for more menu items
			//If the user chooses any other option
			else {
				//exit the loop
				running = false;
			}
		}
	}
	
	/**
	 * This method creates a loan. It takes input about the loans period, the friend's phone number
	 * and the LP copy's serial number. Then this method prints pout the loan information.
	 * */
	private void createLoan() {
		//TODO: Assign a proper loan number.
		//The loan number is right now at 0
		int loanNumber = 0;
		//Gets the loan period from the user input
		int period = TextInput.inputNumber("Antal dage for lånet: ");
		//Creates a new Date object with the current date
		Date date = new Date();
		
		//TODO: Make sure null returns aren't accepted.
		
		// Create a new loan with the given parameters
		loanController.createLoan(loanNumber, date, period, "unfinished");
		
		//Gets friend's phone number from user input
		String phone = TextInput.inputString("Indtast vennens telefonnummer: ");
		//Adds friend to loan using phone number
		loanController.findAndAddFriendByPhone(phone);
		
		//Gets copy's serial number from user input
		String serialNumber = TextInput.inputString("Indtast serienummer: ");
		//Adds copy to loan using serial number
		loanController.findAndAddCopyBySerialNumber(serialNumber);
		
		//Completes the loan and stores it in loanToPrint
		Loan loanToPrint = loanController.completeLoan();
		//If loanToPrint is not null
		if (loanToPrint != null) {
			//if the friend associated with the loan is not null
			if (loanToPrint.getFriend() != null) {
				//Prints the name of the friend
				System.out.println("Ven: " + loanToPrint.getFriend().getName());
			}
			/**
			 * Prints information about the loan such as loan number, borrowing date, loan period,
			 * serial number and loan status
			 * */
			System.out.println("Lånenummer: " + loanToPrint.getLoanNumber());
			System.out.println("Dato: " + loanToPrint.getBorrowDate());
			System.out.println("Låneperiode: " + loanToPrint.getPeriod() + " dage");
			System.out.println("Serienummer: " + serialNumber);
			System.out.println("Status på lån: " + loanToprint.getState());
			//If the copy associated with the loan is not null, print the title of the LP
			if (loanToPrint.getCopy() != null) {
				System.out.println("Kopi: " + loanToPrint.getCopy().getLp().getTitle());
			}
		}
		//If loanToPrint is null
		else {
			//Print error message
			System.out.println("Lånet kunne ikke færdiggøres. Prøv igen");
		}
	}
	
	/**
	 * This method gives the options: Create a new loan or return.
	 * */
	private int writeLoanMenu() {
		// Create a new TextOptions object for the menu
		TextOptions menu = new TextOptions("\n ***** Udlånsmenu *****", "Tilbage");
		// Adds a "Create loan" option to the menu
		menu.addOption("Opret lån");
		
		//TODO: Add more menu options.
		
		// Prompt the user for input and store the result in choice
		int choice = menu.prompt();
		
		//returns the users choice
		return choice;
	}
	
	
	

}
