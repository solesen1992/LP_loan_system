package test;

//Import static assertions from JUnit 5 for testing
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

//Import JUnit 5 annotations and test classes
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Copy;
import model.Loan;

/**
* LoanTest class is a unit test class for the Loan class.
* It uses JUnit 5 framework to test the functionality of Loan methods.
* The tests include setup and teardown methods that run before and after each test,
* as well as before and after all tests.
* Currently, it contains a test to verify the setCopy method of the Loan class.
*/

class LoanTest {
	// Declares a Loan Object for testing
	private Loan loan;
	
	// Method to be executed once before all tests
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		// No setup needed before all tests
	}

	// Method to be executed once after all tests
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		// No teardown needed after all tests
	}

	// Method to be executed before each test
	@BeforeEach
	void setUp() throws Exception {
		// Initializes the Loan object before each test
		loan = new Loan(0, new Date(), 3, "Unfinished");
	}

	// Method to be executed after each test
	@AfterEach
	void tearDown() throws Exception {
		// No teardown needed after each test
	}

	// Test method for setting a copy in the loan
	@Test
	void test() {
		// Creates a new Copy object
		Copy copy = new Copy("1245", new Date(), 1000.0, null);
		// Sets the copy in the loan
		loan.setCopy(copy);
		// Asserts that the copy set in the loan is equal to the copy created
		assertEquals(loan.getCopy(), copy);
	}
}
