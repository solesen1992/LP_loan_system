package controller;

import model.Copy;
import model.LP;
import model.LPContainer;

import java.util.Date;

/**
 * LPController is a controller class designed to manage LP (long-playing record) operations. 
 * It interacts with the LPContainer singleton to perform operations like finding, creating, 
 * and deleting LPs and their copies.
 * */

public class LPController {
	/**
	 * This is the constructor for the LPController class. 
	 * It is called when a new instance of LPController is created.
	 * */
	public LPController() {
		
	}
	
	/**
	 * This method finds a copy by its serial number.
	 * @param serialNumber
	 * @return a copy from LPContainer.
	 */
	public Copy findCopyBySerialNumber(String serialNumber) {
		/**
		 * This calls the findCopyBySerialNumber method of the LPContainer singleton instance 
		 * with the provided serial number, and returns the Copy object found.
		 * */
		return LPContainer.getInstance().findCopyBySerialNumber(serialNumber);
	}
	
	/**
	 * This method finds an LP by its barcode.
	 * */
	public LP findLpByBarcode(String barcode) {
		/**
		 * This calls the findLPByBarcode method of the LPContainer singleton instance 
		 * with the provided barcode, and returns the LP object found.
		 */
		return LPContainer.getInstance().findLPByBarcode(barcode);
	}
	
	/**
	 * This method creates a new LP with the specified parameters.
	 * */
	public LP createLP(String barcode, String title, String artist, Date publicationDate) {
		// This creates a new LP object with the provided barcode, title, artist, and publication date.
		LP newLP = new LP(barcode, title, artist, publicationDate);
		
		// This adds the new LP to the LPContainer instance and stores the result (success or failure) in the success variable.
		boolean success = LPContainer.getInstance().addLP(newLP);
		
		if (success) {
			// If the LP was successfully added to the LPContainer, it sets newLP to null.
			newLP = null;
		}
		
		// This returns the new LP if it was not added to the LPContainer, otherwise returns null.
		return newLP;
	}
	
	/**
	 * This method deletes an LP from the LPContainer.
	 * */
	public boolean deleteLP(LP lp) {
		/** This calls the removeLP method of the LPContainer singleton instance with 
		 * the provided LP, and returns whether the deletion was successful.
		 */
		return LPContainer.getInstance().removeLP(lp);
	}
}
