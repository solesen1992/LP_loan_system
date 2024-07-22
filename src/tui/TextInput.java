package tui;

import java.util.Scanner;

/**
 * TextInput is a utility class that provides static methods for reading user input 
 * from the console. It offers methods to prompt the user for both numeric and string input.
 * 
 * @author Istvan Knoll, Mogens Holm Iversen
 * @version 0.0.1 initial draft version
 * */

public class TextInput {

    /**
     * Constructor for objects of TextInput
     */
    public TextInput() {
        // Constructor for the TextInput class.
        // This constructor does nothing since there are no instance variables to initialize.
    }
    
    /** This method prompts the user to input a number and returns it as an integer.
     * @param question
     * @return
     */
    public static int inputNumber(String question) {
        // Creates a new Scanner object to read input from the keyboard.
        Scanner keyboard = new Scanner(System.in);
        
        // Initializes the variable 'number' to 0.
        int number = 0;
        
        // Calls the printQuesiton method to print the question to the user.
        printQuesiton(question);
        
        // Loops until the user enters a valid integer.
        while (!keyboard.hasNextInt()) {
            // Prints an error message if the input is not an integer.
            System.out.println("Input skal være et tal - prøv igen");
            
            // Clears the invalid input from the Scanner buffer.
            keyboard.nextLine();
        }
        // Reads the integer input from the user and stores it in the 'number' variable.
        number = keyboard.nextInt();
        
        // Returns the user's input as an integer.
        return number;
    }
    
    /**
     * This method prompts the user to input a string and returns it.
     * */
    public static String inputString(String question) {
        // Creates a new Scanner object to read input from the keyboard.
        Scanner keyboard = new Scanner(System.in);
        
        // Calls the printQuesiton method to print the question to the user.
        printQuesiton(question);
        
        // Reads the string input from the user and returns it.
        return keyboard.nextLine();
    }
    
    /**
     * This method prints the provided question to the user.
     * */
    private static void printQuesiton(String question) {
        // Prints the question with a colon and space.
        System.out.print(" " + question + ": ");
    }
}
