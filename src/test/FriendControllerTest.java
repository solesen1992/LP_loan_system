package test;

/**This imports the static method "assertEquals" from the "Assertions" class in the JUnit 5 library.
*This method is used for comparing expected and actual results in test cases.
* */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Friend;
import model.FriendContainer;

/**
 * FriendControllerTest is a JUnit test class designed to test the functionality of the 
 * FriendContainer class, particularly the method for finding a friend by phone number. 
 * It follows the typical structure for JUnit 5 tests, using annotations to manage setup 
 * and teardown processes for test methods.
 * 
 * @BeforeAll: Initializes the shared FriendContainer instance before any tests are run.
 * @AfterAll: Placeholder for any cleanup needed after all tests are done.
 * @BeforeEach: Placeholder for any setup needed before each test.
 * @AfterEach: Placeholder for any cleanup needed after each test.
 * @Test: Contains a specific test case (findFriendByPhoneTest) to verify that a friend 
 * can be correctly found by their phone number after being added to the container.
 * */

class FriendControllerTest {
	/** This declares a private static variable "friendContainer" of type FriendContainer, 
	* which will be used across all tests.
	* */
	private static FriendContainer friendContainer;

	/** This is a setup method annotated with @BeforeAll, which means it will run once 
	* before all tests in this class.
	* */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		/** This initializes the "friendContainer" variable by calling the "getInstance" 
		* method of the FriendContainer class.
	    * The FriendContainer follows the singleton pattern.
	    */
		friendContainer = FriendContainer.getInstance();
	}

	/**
	 * This is a teardown method annotated with @AfterAll, which means it will run once 
	 * after all tests in this class.
	 * */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * This is a setup method annotated with @BeforeEach, which means it will run before each test case.
	 * */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * This is a teardown method annotated with @AfterEach, which means it will run after each test case.
	 * */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * This is a test method annotated with @Test, which means it is a test case to be run by 
	 * the JUnit framework.
	 * */
	@Test
	void findFriendByPhoneTest() {
		// This creates a new Friend object with the specified name, address, and phone number.
		Friend friend = new Friend("Penrose", "Gaden", "Aalborg", "12345678");
		
		// This adds the created friend to the friendContainer.
		friendContainer.addFriend(friend);
		
		/**
		 * This asserts that the friend retrieved by the phone number "12345678" from the friendContainer
		 * is equal to the friend object that was added, using the assertEquals method to compare them.
		 * */
		assertEquals(friendContainer.findFriendByPhone("12345678"), friend);	
	}
}