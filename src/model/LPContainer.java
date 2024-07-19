package model;

import java.util.ArrayList;

/**
* This class contains a list of LPs and a static instance of LPContainer.
*/

public class LPContainer {
	// List to store LP objects
	private ArrayList<LP> lps;
	// Static instance of LPContainer for Singleton pattern
	private static LPContainer instance;
	
	/**
	 * Private constructor ensures the object is created only within the class.
	 * Part of the Singleton pattern.
	 * */
	private LPContainer() {
		// Initializes the lp's list
		lps = new ArrayList<>();
	}
	
	/**
	 * This method will return the LPContainer instance if it already exists,
	 * if not, it will create a new LPContainer.
	 * @return the singleton instance of LPContainer
	 */
	public static LPContainer getInstance() {
		// Checks if the instance is null
		if (instance == null) {
			// If null, create a new LPContainer
			instance = new LPContainer();
		}
		// Returns the existing or new instance
		return instance;
	}
	
	/**
	  * This method adds an LP to the container's list of LPs.
	  * TODO: Check for duplicate LPs in the container before adding.
	  * @param lp The LP that is to be added to the list.
	  * @return Whether the LP was successfully added. Currently always true.
	  */
	public boolean addLP(LP lp) {
		// TODO: Make sure duplicate LPs cannot be added
		// Add the LP to the lps list
		lps.add(lp);
		//Returns true indicating the LP was added
		return true;
	}
	
	/**
	 * This method removes an LP from the container's list of LPs.
	 * TODO: Safely remove all the copies attached to an LP. May or may not be necessary.
	 * @param lp The LP that is to be removed from the list.
	 * @return Whether the LP was successfully removed.
	 * */
	public boolean removeLP(LP lp) {
		// TODO: Safely remove all copies attached to an LP
		// Remove the LP from the lps list
		return lps.remove(lp);
	}
	
	/**
	  * This method is used to find a copy by serial number.
	  * @param serialNumber The serial number of the copy to find.
	  * @return The specific copy we are looking for. If no copy is found, the method will return null.
	  */
	public Copy findCopyBySerialNumber(String serialNumber) {
		// Initializes copy as null
		Copy copy = null;
		// Iterates through the list of LPs to find the copy with the given serial number
		for (int i = 0; i < lps.size() && copy == null; i++) {
			// Checks if the current LP contains the copy with the given serial number
			copy = lps.get(i).findCopyBySerialNumber(serialNumber);
		}
		// Returns the found copy or null if no match was found
		return copy;
	}
	
	/**
	  * This method is used to find an LP by barcode.
	  * @param barcode The barcode of the LP to find.
	  * @return The specific LP we are looking for. If no LP is found, the method will return null.
	  */
	public LP findLPByBarcode(String barcode) {
		// Initializes the LP as null
		LP lp = null;
		// Iterates through the list of LPs to find the LP with the given barcode
		for (int i = 0; i < lps.size() && lp == null; i++) {
			// Checks if the current LP's barcode matches the given barcode
			if (barcode.equals(lps.get(i).getBarcode())) {
				// If match is found, assign the LP to the lp variable
				lp = lps.get(i);
			}
		}
		// Returns the found LP or null of no match was found
		return lp;
	}
	
	/**
	  * This method is used to find an LP by title.
	  * @param name The title of the LP to find.
	  * @return The specific LP we are looking for. If no LP is found, the method will return null.
	  */
	public LP findLPByTitle(String name) {
		// Initializes the lp as null
		LP lp = null;
		// Iterates through the list of LPs to find the LP with the given title
		for (int i = 0; i < lps.size() && lp == null; i++) {
			// Checks if the current LP's title matches the given title
			if (name.equals(lps.get(i).getTitle())) {
				// If a match is found, assign the LP to the lp variable
				lp = lps.get(i);
			}
		}
		// Return the found LP or null if no match was found
		return lp;
	}
}