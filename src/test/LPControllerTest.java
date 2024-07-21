package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.LoanController;
import model.Copy;
import model.LP;
import model.LPContainer;

/**
 * LPControllerTest is a JUnit test class designed to test the functionality of the 
 * LPContainer class, particularly the method for finding a copy by its serial number. 
 * It follows the typical structure for JUnit 5 tests, using annotations to manage setup 
 * and teardown processes for test methods.
 * */

class LPControllerTest {
	/** This declares a private static variable lPContainer of type LPContainer, 
	* which will be used across all tests.
	*/
	private static LPContainer lpContainer;
	
	/** This is a setup method annotated with @BeforeAll, which means it will run once 
	* before all tests in this class.
	* */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		/**
		 * This initializes the lPContainer variable by calling the getInstance method 
		 * of the LPContainer class. LPContainer follows a Singleton pattern.
		 * */
		lpContainer = LPContainer.getInstance();
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
	void findCopyBySerialNumberTest() {
		// This creates a new LP object with the specified title, artist, composer, and release date.
		LP lpTest = new LP("qwertyuiop", "The Shire", "Tolkien", new Date());
		
		// This creates a new Copy object with the specified serial number, acquisition date, price, and associated LP.
		Copy copy = new Copy("123D", new Date(), 10, lpTest);
		
		// This adds the created copy to the lpTest LP object.
		lpTest.addCopy(copy);
		
		// This adds the lpTest LP object to the lPContainer.
		lpContainer.addLP(lpTest);
		
		/** This asserts that the copy retrieved by the serial number "123D" from the lPContainer 
		* is equal to the copy object that was added,
        * using the assertEquals method to compare them.
        */
		assertEquals(lpContainer.findCopyBySerialNumber("123D"), copy);
	}
}