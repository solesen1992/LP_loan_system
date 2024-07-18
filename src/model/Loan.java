package model;

import java.util.Date;

/**
 * This class stores the loan's information: loanNumber, borrowDate, period, state, copy, friend.
 * There are get and set methods for every parameter.  
 */

public class Loan {
	private int loanNumber;
	private Date borrowDate;
	private int period;
	private String state;
	private Copy copy;
	private Friend friend;
	
	/**
	 * Constructor
	 * 
	 * this.setBorrowDate(borrowDate);: Uses a setter method setBorrowDate() to assign the 
	 * borrowDate parameter to the borrowDate instance variable. This approach ensures any 
	 * necessary validation or processing in the setter method is applied.
	 * 
	 * this.setPeriod(period); and this.setState(state); are used to set the period and state 
	 * instance variables using setter methods.
	 * */
	public Loan(int loanNumber, Date borrowDate, int period, String state) {
		this.loanNumber = loanNumber;
		this.setBorrowDate(borrowDate);
		this.setPeriod(period);
		this.setState(state);
	}

	/**
	 * Getters and setters
	 * */
	public int getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(int loanNumber) {
		this.loanNumber = loanNumber;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Copy getCopy() {
		return copy;
	}

	public void setCopy(Copy copy) {
		this.copy = copy;
	}

	public Friend getFriend() {
		return friend;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
	}
}
