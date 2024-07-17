package model;

import java.util.Date;

/**
 * This class contains information about a copy: SerialNumber, purchaseDate and purchasePrice.
 * Furthermore, it has a reference to the LP-class which it is a copy of.
 * */

public class Copy {
	private String serialNumber;
	private Date purchaseDate;
	private double purchasePrice;
	private LP lp;
	
	/**
	 * Constructor
	 * */
	public Copy(String serialNumber, Date purchaseDate, double purchasePrice, LP lp) {
		super();
		this.serialNumber = serialNumber;
		this.purchaseDate = purchaseDate;
		this.purchasePrice = purchasePrice;
		this.lp = lp;
	}

	/**
	 * Get and set methods
	 * */
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public LP getLp() {
		return lp;
	}

	public void setLp(LP lp) {
		this.lp = lp;
	}
	
}
