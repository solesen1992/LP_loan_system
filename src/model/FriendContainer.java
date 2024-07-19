package model;

import java.util.ArrayList;

/**
 * The FriendContainer class contains a static instance of FriendContainer and a list of friends.
 * */

public class FriendContainer {
	//Singleton pattern. Static instance of FriendContainer.
	private static FriendContainer instance;
	//List to store Friend objects
	private ArrayList<Friend> friends;
	
	//Private constructor. Ensures the object is created only within the class. Singleton pattern.
	private FriendContainer() {
		// Initialize the friends list
		friends = new ArrayList<>();
	}
	
	/**
	 * This method will return the the FriendContainer instance if it already exists.
	 * If not, it will create a new FriendContainer.
	 * Part of the Singleton pattern.
	 * @return the singleton instance of FriendContainer
	 * */
	public static FriendContainer getInstance() {
		// Check if the instance is null
		if (instance == null) {
			// If null, create a new FriendContainer
			instance = new FriendContainer();
		}
		// Return the existing or new instance
		return instance;
	}
	
	/**
	 * This method is used to find a friend by phone.
	 * @param phone - the phone number of the friend to find
	 * @return the specific friend we are looking for. If no friend is found, the method will return null.
	 */
	public Friend findFriendByPhone(String phone) {
		// Initialize friend as null
		Friend friend = null;
		// Iterate through the list of friends to find the friend with the given phone number
		for(int i = 0; i < friends.size() && friend == null; i++) {
			// Check if the current friend's phone matches the given phone number
			if(friends.get(i).getPhone().equalsIgnoreCase(phone)) {
				// If a match is found, assign the friend to the friend variable
				friend = friends.get(i);
			}
		}
		// Returns the found friend or null if no match was found
		return friend;
	}
	
	/**
	 * This method adds the specific friend to FriendContainer, and does nothing if friend is null.
	 * @param friend the friend to be added
	 * @return true if the friend is not null and was added, false otherwise
	 */
	public boolean addFriend(Friend friend) {
		// Checks if the friend is not null
		boolean result = friend != null;
		// If the friend is not null, add to the friend list
		if(result) {
			friends.add(friend);
		}
		// Returns true if the friend was added, false otherwise
		return result;
	}
}