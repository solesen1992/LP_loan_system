package tui;

import model.Copy;
import model.Friend;
import model.FriendContainer;
import model.LP;
import model.LPContainer;

import java.util.Date;

/**
 * TryMe is a class that contains a static method to generate test data. This class is part 
 * of the tui (Text User Interface) package and is designed to populate the model with some 
 * sample data for testing purposes.
 * */

public class TryMe {
	
	/** 
	 * This declares a static method named generateTestdata that can be called without 
	 * creating an instance of TryMe.
	 */
	public static void generateTestData() {
		// This creates a new LP object named lp1 with a barcode "asdfghjkl", title "Harry Potter", 
		// artist "Rowling", and the current date as the publication date.
		LP lp1 = new LP("asdfghjkl", "Harry Potter", "Rowling", new Date());
		
		// This creates a new Copy object named copy1 with a serial number "1234D", the current 
		// date, price 1000.0, and associates it with the LP lp1.
		Copy copy1 = new Copy("1234D", new Date(), 1000.0, lp1);
		
		// This creates a new Friend object named friend1 with the name "Kasper", address "Østerbro", 
		// city "Aalborg", and phone number "12345678".
		Friend friend1 = new Friend("Kasper", "Østerbro", "Aalborg", "12345678");
		
		// This gets the singleton instance of FriendContainer and adds friend1 to it.
		FriendContainer.getInstance().addFriend(friend1);
		
		// This gets the singleton instance of LPContainer and adds lp1 to it.
		LPContainer.getInstance().addLP(lp1);
		
		// This adds copy1 to the LP lp1.
		lp1.addCopy(copy1);
	}
}