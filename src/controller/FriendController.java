package controller;

import model.Friend;
import model.FriendContainer;

/** 
 * FriendController is a controller class designed to provide access to friend data 
 * stored in the FriendContainer class. It follows a typical design pattern where 
 * a controller interacts with a model (in this case, FriendContainer) to retrieve and manage data.
 * */

public class FriendController {
	/** 
	 * This declares a private static variable friendContainer of type FriendContainer, 
	 * which will be used to interact with the friend data.
	 */
	public static FriendContainer friendContainer;
	
	/**
	 * This is the constructor for the FriendController class. 
	 * It is called when a new instance of FriendController is created.
	 * */
	public FriendController() {
		/**
		 * This initializes the friendContainer variable by calling the getInstance
		 * method of the FriendContainer class.
		 * The FriendContaienr has a singleton pattern.
		 * */
		friendContainer = FriendContainer.getInstance();
	}
	
	/**
     * This method finds the friend by phone.
     * Takes a phone number as a parameter and returns a friend object.
     * @param phone The phone number of the friend to find.
     * @return a friend from FriendContainer.
     */
	public Friend findFriendByPhone(String phone) {
		/**
		 * This calls the findFriendByPhone method of the friendContainer instance with 
		 * the provided phone number, and returns the Friend object found.
		 * */
		return friendContainer.findFriendByPhone(phone);
	}
}
