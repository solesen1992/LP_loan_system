package controller;

import model.Copy;
import model.Friend;
import model.Loan;
import model.LoanContainer;

import java.util.Date;

/**
 * LoanController is a controller class designed to manage loan operations. 
 * It interacts with the FriendController and LPController classes to find and add friends 
 * and copies to a loan. It also provides methods to create, retrieve, and complete loans.
 * */

public class LoanController {
	private FriendController friendController;
	private LPController lpController;
	private Loan loan;
	
	/**
	 * Constructor for the LoanController class
	 * */
	public LoanController() {
		// This initializes the friendController variable by creating a new instance of FriendController.
		friendController = new FriendController();
		// This initializes the lPController variable by creating a new instance of LPController.
		lpController = new LPController();
	}
	
	/**
	 * A getter method for the loan variable
	 * */
	public Loan getLoan() {
		// Returns the current loan
		return loan;
	}
	
	/**
	 * A setter method for the loan variable
	 * */
	public void setLoan(Loan loan) {
		// This sets the current loan to the provided loan.
		this.loan = loan;
	}
	
	/**
	 * This method creates a new loan with the specified parameters
	 * */
	public void createLoan(int loanNumber, Date borrowDate, int period, String state) {
		// This initializes the loan variable with a new Loan object.
		loan = new Loan(loanNumber, borrowDate, period, state);
	}
	
	/**
     * Method finds a friend by phone, adds the friend to the loan and returns it
     * @Param phone is a phonenumber with the type String.
     * @return Friend that has been found with the phone
     */
	public Friend findAndAddFriendByPhone(String phone) {
		/**
		 * This calls the findFriendByPhone method of the friendController instance 
		 * with the provided phone number, and assigns the result to the friend variable.
		 * */
		Friend friend = friendController.findFriendByPhone(phone);
		
		// This checks if a friend was found.
		if (friend != null) {
			// This calls the setFriendToLoan method with the found friend.
			setFriendToLoan(friend);
		}
		// This returns the found friend.
		return friend;
	}
	
	/**
     * Method finds a copy by serial number, adds the copy to the friend and returns
     * it
     * @Param SerialNumber is a unique number with the type String.
     * @return Copy that has been found with the serial number
     */
	public Copy findAndAddCopyBySerialNumber(String SerialNumber) {
		/**
		 * This calls the findCopyBySerialNumber method of the lPController instance with 
		 * the provided serial number, and assigns the result to the copy variable.
		 * */
		Copy copy = lpController.findCopyBySerialNumber(SerialNumber);
		
		// This checks if a copy was found.
		if (copy != null) {
			// This calls the setCopyToLoan method with the found copy.
			setCopyToLoan(copy);
		}
		// This returns the found copy.
		return copy;
	}
	
	/**
	 * This private method sets the friend of the current loan.
	 * */
	private void setFriendToLoan(Friend friend) {
		// This sets the friend of the loan to the provided friend.
		loan.setFriend(friend);
	}
	
	/**
	 * This private method sets the copy of the current loan.
	 * */
	private void setCopyToLoan(Copy copy) {
		// This sets the copy of the loan to the provided copy.
		loan.setCopy(copy);
	}
	
	/**
     * Method that completes the loan and adds it to the LoanContainer. The loan is
     * persisted in the LoanContainer. Loan is set to null.
     * @return the loan that has been completed.
     */
	public Loan completeLoan() {
		Loan result;
		
		// This checks if the loan has a friend, a copy, a borrow date, and a period greater than 0.
		if (loan.getFriend() != null && loan.getCopy() != null && loan.getBorrowDate() != null && loan.getPeriod() > 0) {
			// This adds the current loan to the LoanContainer instance.
			LoanContainer.getInstance().addLoan(loan);
			// This assigns the current loan to the result variable.
			result = loan;
			// This sets the current loan to null, indicating that the loan has been completed.
			loan = null;
		} else {
			// This assigns null to the result variable if any of the required conditions are not met.
			result = null;
		}
		// This returns the completed loan or null.
		return result;
	}	
}