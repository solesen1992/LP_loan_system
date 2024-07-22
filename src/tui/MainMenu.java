package tui;

/**
 * Main Menu has access to LoanTUI and has a main method which is the starting point of the program.
 * 
 * The MainMenu class provides a text-based interface for navigating different parts of 
 * the application. It interacts with the LoanTUI class to manage loan-related functionalities 
 * and includes options to generate test data and exit the program.
 * 
 * @author knol, mhi
 * @version 2018.10.19
 * @version 2019.03.29 changed menu to danish and changed method names to reflect the other example
 */

public class MainMenu {
    // Declares a private instance variable loanTUI of type LoanTUI.
    private LoanTUI loanTUI;

    /**
     * Starting point of the program
     * @param args
     */
    public static void main(String[] args) {
        // Creates a new instance of MainMenu.
        MainMenu menu = new MainMenu();
        
        // Calls the start method on the menu instance to begin the program.
        menu.start(); 
    }
    
    /**
     * Constructor for objects of MainMenu
     */
    public MainMenu() {
        // initialise instance variables
    	// Initializes the loanTUI instance variable with a new LoanTUI object.
        loanTUI = new LoanTUI();
    }

    /**
     * Method to start the main menu loop.
     * */
    public void start() {
        // Initializes the exit variable to false to control the loop.
        boolean exit = false;
        
        // Loops until exit is true.
        while (!exit) {
            // Calls the writeMainMenu method to display options and get the user's choice.
            int choice = writeMainMenu();
            
            // If the user selects option 1.
            if (choice == 1) {
                // Prints a message indicating this option is not yet implemented.
                System.out.println(" Denne er endnu ikke implementeret");
                
            }
            // If the user selects option 2.
            else if (choice == 2) {
                // Prints a message indicating this option is not yet implemented.
                System.out.println(" Denne er endnu ikke implementeret");
                
            }
            // If the user selects option 3.
            else if (choice == 3) {
                // Calls the start method on loanTUI to begin the loan menu.
                loanTUI.start();
                
            }
            // If the user selects option 4.
            else if (choice == 4) {
                // Calls the generateTestdata method from the TryMe class to generate test data.
                TryMe.generateTestData();
                
                // Prints a message indicating test data has been generated.
                System.out.println("test data genereret");
            }
            // If the user selects any other option.
            else {
                // Calls the writeEnd method to print a goodbye message.
                writeEnd();
                
                // Sets exit to true to exit the loop.
                exit = true;
            }
        }
    }
    
    /**
     * This method gives different options to different sub menus.
     * Method to display the main menu options and get the user's choice.
     * @return a selection of options.
     */
    private int writeMainMenu() {
        // Creates a new TextOptions object with a title and cancel option.
        TextOptions menu = new TextOptions("\n ***Hovedmenu***", "Afslut programmet");
        
        // Adds "Lånermenu" as an option to the menu.
        menu.addOption("Lånermenu");
        
        // Adds "LP menu" as an option to the menu.
        menu.addOption("LP menu");
        
        // Adds "Udlånsmenu" as an option to the menu.
        menu.addOption("Udlånsmenu");
        
        // Adds "Generer test data" as an option to the menu.
        menu.addOption("Generer test data");
        
        // Prompts the user to select an option and returns their choice.
        return menu.prompt();
    }
    
    /**
     * This method prints out the "end" option.
     * Method to print a goodbye message.
     */
    private void writeEnd() {
        // Prints "Tak for denne gang"
        System.out.println(" Tak for denne gang ");
    }
}
