package cp213;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author Your name and id here
 * @version 2024-09-01
 */
public class SerialNumber {

    /**
     * Determines if a string contains all digits.
     *
     * @param str The string to test.
     * @return true if str is all digits, false otherwise.
     */
	public static boolean allDigits(final String str) {
	    // Check if the string is null or empty
	    if (str == null || str.isEmpty()) {
	        return false;
	    }
	    
	    // Iterate over each character in the string
	    for (int i = 0; i < str.length(); i++) {
	        char currentChar = str.charAt(i);
	        
	        // If the character is not a digit, return false
	        if (!Character.isDigit(currentChar)) {
	            return false;
	        }
	    }
	    
	    // If all characters are digits, return true
	    return true;
}

    /**
     * Determines if a string is a good serial number. Good serial numbers are of
     * the form 'SN/nnnn-nnn', where 'n' is a digit.
     *
     * @param sn The serial number to test.
     * @return true if the serial number is valid in form, false otherwise.
     */
    public static boolean validSn(final String sn) {

        // The correct format for a valid serial number should have a length of 11
        if (sn.length() != 11) {
            return false;
        }

        // Check if the first two characters are 'SN'
        if (!sn.startsWith("SN")) {
            return false;
        }

        // Check if the 3rd character is '/'
        if (sn.charAt(2) != '/') {
            return false;
        }

        // Check if characters from index 3 to 6 are digits (nnnn)
        if (!allDigits(sn.substring(3, 7))) {
            return false;
        }

        // Check if the 7th character is '-'
        if (sn.charAt(7) != '-') {
            return false;
        }

        // Check if characters from index 8 to 10 are digits (nnn)
        return allDigits(sn.substring(8, 11));
    }


    /**
     * Evaluates serial numbers from a file. Writes valid serial numbers to
     * good_sns, and invalid serial numbers to bad_sns. Each line of fileIn contains
     * a (possibly valid) serial number.
     *
     * @param fileIn  a file already open for reading
     * @param goodSns a file already open for writing
     * @param badSns  a file already open for writing
     */
    public static void validSnFile(final Scanner fileIn, final PrintStream goodSns, final PrintStream badSns) {

        // Read each line from the input file
        while (fileIn.hasNextLine()) {
            String sn = fileIn.nextLine().trim();  // Get the serial number

            // Write to goodSns or badSns based on validity
            if (validSn(sn)) {
                goodSns.println(sn);
            } else {
                badSns.println(sn);
            }
        }
    }
}
