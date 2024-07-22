package tui;

import java.util.ArrayList;

/**
 * TextOptions is a class that provides a way to display a list of text options to a user 
 * and prompt them to make a selection. It includes the ability to handle cancellable options if provided.
 * 
 * @author knol, mhi
 * @version 2018.10.19
 * */

public class TextOptions {
    // instance variables 
    private ArrayList<String> options;
    private String title;
    private boolean cancellable;
    
    /**
     * Constructor for objects of TextOptions
     * Constructor for the TextOptions class that takes a title and a cancelText as parameters.
     */
    public TextOptions(String title, String cancelText) {
        // Initialize instance variables
        options = new ArrayList<>();
        this.title = title;
        
        // If cancelText is not null, sets 'cancellable' to true.
        if (cancelText != null) {
            cancellable = true;
        }
        
        // Adds the cancelText to the options list by calling the addOption method.
        addOption(cancelText);
    }
    
    /** 
     * Overloaded constructor for the TextOptions class that takes only a title as a parameter.
     * @param title
     */
    public TextOptions(String title) {
    	// Calls the other constructor with the provided title and null for cancelText.
        this(title, null);     
    }

    /**
     * Method to add an option to the options list.
     * */
    public void addOption(String option) {
    	// Adds the provided option to the 'options' ArrayList.
        options.add(option);
    }
    
    /**
     * Method to display the options and prompt the user to make a choice.
     * */
    public int prompt() {
    	// Prints the title.
        System.out.println(title);
        
        // Gets the size of the options list and stores it in 'size'.
        int size = options.size();
        
        // Loops through the options list.
        for (int i = 0; i < size; i++) {
        	// Gets the current option from the options list.
            String currentOption = options.get(i);
            
            // If the current option is not null, prints the option with its index.
            if (currentOption != null) {
                System.out.println(" [" + i + "]\t" + currentOption);
            }
        }
        
        // Initializes 'choice' to -1.
        int choice = -1;
        
        // Initializes 'lowerBound' to 0.
        int lowerBound = 0;
        
        // If options are not cancellable, sets 'lowerBound' to 1.
        if (!cancellable) {
            lowerBound = 1;
        }
        
        // Loops until the user enters a valid choice.
        while (choice < lowerBound || choice >= size) {
        	// Prompts the user to enter a number and stores it in 'choice'.
            choice = TextInput.inputNumber("Vælg et tal");
        }
        // Returns the user's choice.
        return choice;
    }
}
