package cp213;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Testing for ScannerTest class.
 *
 * @author Devansh Jain
 * @version 2022-01-09
 */
public class Main {

    /**
     * Main program to test the Scanner class.
     *
     * @param args
     *            unused default parameter
     */
    public static void main(final String args[]) {
	String line = "-".repeat(40);
	// Create a keyboard Scanner.
	final Scanner keyboard = new Scanner(System.in);
	int total = ScannerTest.readNumbers(keyboard);
	keyboard.close();
	System.out.println("Total: " + total);
	System.out.println(line);

	// Define the file to scan.
	final File file = new File("src/cp213/ScannerTest.java");
	// File may not be found - try/catch required.
	Scanner source = null;

	try {
	    // Create a file scanner.
	    source = new Scanner(file);
	    int count = ScannerTest.countLines(source);
	    System.out.println("Lines: " + count);
	    source.close();
	    System.out.println(line);
	    // Recreate the file scanner - at end of file otherwise.
	    source = new Scanner(file);
	    int tokens = ScannerTest.countTokens(source);
	    System.out.println("Tokens: " + tokens);
	    source.close();
	    System.out.println(line);
	    // Create a string scanner.
	    String sentence = "This is a sentence with words.";
	    source = new Scanner(sentence);
	    int words = ScannerTest.countTokens(source);
	    System.out.println("Words: " + words);
	    source.close();
	    System.out.println(line);
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
	System.out.println("Done");
    }

}
