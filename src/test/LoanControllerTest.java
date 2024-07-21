package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.LoanController;
import model.Friend;
import model.FriendContainer;

/**
 * LoanControllerTest is a JUnit test class designed to test the functionality of the 
 * LoanController class, particularly the method for finding and adding a friend to 
 * a loan by phone number. It follows the typical structure for JUnit 5 tests, using 
 * annotations to manage setup and teardown processes for test methods.
 * */
class LoanControllerTest {
	/**This declares a private static variable loanController of type LoanController, 
	 * which will be used across all tests.
	 */
	private static LoanController loanController;

	/** This is a setup method annotated with @BeforeAll, which means it will run once 
	* before all tests in this class.
	* */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		// This initializes the loanController variable by creating a new instance of LoanController.
		loanController = new LoanController();
		// This calls the createLoan method of the loanController instance, creating a loan with specific parameters.
		loanController.createLoan(10, new Date(), 7, "notFinished");
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
	void findAndAddFriendByPhoneTest() {
		// This creates a new Friend object with the specified name, address, and phone number.
		Friend friend = new Friend("Kasper", "Østerbrogade 75", "nutten", "51813828");
		
		// This adds the created friend to the FriendContainer instance.
		FriendContainer.getInstance().addFriend(friend);
		
		// This calls the findAndAddFriendByPhone method of the loanController instance with the specified phone number.
		loanController.findAndAddFriendByPhone("51813828");
		
		// This asserts that the friend associated with the loan is equal to the friend object that was added.
		assertEquals(loanController.getLoan().getFriend(), friend);
	}
	
	/**
	 * This is another test method annotated with @Test, which means it is a test case to 
	 * be run by the JUnit framework. The test is expected to fail.
	 * */
	@Test
	public void findAndAddFriendByPhoneTestFail() {
		// This creates a new Friend object with the specified name, address, and phone number.
		Friend friend = new Friend("Sara", "Eternitten", "Ålleren", "24686420");
		
		// This adds the created friend to the FriendContainer instance.
		FriendContainer.getInstance().addFriend(friend);
		
		// This calls the findAndAddFriendByPhone method of the loanController instance 
		// with a phone number that does not exist.
		loanController.findAndAddFriendByPhone("987654321");
		
		// This asserts that the friend associated with the loan is null, since no friend 
		// was found with the given phone number.
		assertNull(loanController.getLoan().getFriend());
	}
}