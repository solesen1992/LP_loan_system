package model;

import java.util.ArrayList;
import java.util.Date;

/**
 * This class stores LP information: barcode, title, artist and publicationDate. 
 * This class also contains a list of Copies of the LP. 
 */

public class LP {
	private String barcode;
	private String title;
	private String artist;
	private Date publicationDate;
	private ArrayList<Copy> copies;
	
	/**
	 * Constructor
	 * */
	public LP(String barcode, String title, String artist, Date publicationDate) {
		this.barcode = barcode;
		this.title = title;
		this.artist = artist;
		this.publicationDate = publicationDate;
		copies = new ArrayList<>();
	}

	/**
	 * Getters and setters
	 * */
	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public ArrayList<Copy> getCopies() {
		return copies;
	}

	public void setCopies(ArrayList<Copy> copies) {
		this.copies = copies;
	}
	
	/**
	 * This method finds the copy of the LP by serial number. 
	 * Finds a copy in the loan's copies list by serial number.
	 * @param serialNumber
	 * @return the specific copy we are looking for. If no copy is found, the method will return null.
	 */
	public Copy findCopyBySerialNumber(String serialNumber) {
		// Initializes a variable to hold the result, starting with null
		Copy copyOfLpBySerialNumber = null;
		// Iterates through the copies list
		for(int i = 0; i < copies.size() && copyOfLpBySerialNumber == null; i++) {
			// Checks if the serial number matches - ignoring case.
			if(copies.get(i).getSerialNumber().equalsIgnoreCase(serialNumber)) {
				// Assigns the matching copy to the variable.
				copyOfLpBySerialNumber = copies.get(i);
			}
		}
		// Returns the found copy or null if not found.
		return copyOfLpBySerialNumber;
	}
	
	/**
	 * This method adds the specific copy to loan, and does nothing if the copy is null.
	 * @param copy - the copy to add
	 * @return true if the copy is not null and was successfully added to the loan, false otherwise.
	 */
	public boolean addCopy(Copy copy) {
		// Checks if the copy is not null and assign the result to a boolean variable.
		boolean addCopy = copy != null;
		// If the copy is not null.
		if(addCopy) {
			// Adds the copy to the list of copies associated with the loan.
			copies.add(copy);
		}
		// Returns true if the copy was added (not null), false otherwise.
		return addCopy;
	}
}
