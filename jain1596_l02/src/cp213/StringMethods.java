package cp213;

/**
 * Sample string methods.
 *
 * @author Devansh Jain, 169061596, jain1596@mylaurier.ca
 * @version 2022-05-06
 */
public class StringMethods {
    // Constants
    /**
     * String of vowels.
     */
    public static final String VOWELS = "aeiouAEIOU";

    /**
     * Counts the number of vowels in a string. Does not include 'y'.
     *
     * @param string A string.
     * @return Number of vowels in string.
     */
    public static int vowelCount(final String string) {

        int i;
        int vowels = 0;
        for (i=0;i<string.length();i++)
        {
            if (string.charAt(i) == 'a' || string.charAt(i) == 'e' || string.charAt(i) == 'i' || string.charAt(i) == 'o' || string.charAt(i) == 'u')
            
                vowels++; 
            else if (string.charAt(i) == 'A' || string.charAt(i) == 'E' || string.charAt(i) == 'I' || string.charAt(i) == 'O' || string.charAt(i) == 'U')
            
                vowels++; 
            
            
        }
        return vowels;
    }

    /**
     * Counts the number of digits in a string.
     *
     * @param string A string.
     * @return Number of digits in string.
     */
    public static int digitCount(final String string) {
	int count = 0;
	for (int i = 0; i < string.length(); i++) {
	    if (Character.isDigit(string.charAt(i))) {
		count++;
	    }

	}
	return count;
    }

    /**
     * Totals the individual digits in a string.
     *
     * @param string A string.
     * @return The integer total of all individuals digits in string.
     */
    public static int totalDigits(final String string) {
	int total = 0;

	for (int i = 0; i < string.length(); i++) {
	    char currentChar = string.charAt(i);

	    if (Character.isDigit(currentChar)) {
		total += Character.getNumericValue(currentChar);
	    }
	}
	return total;
    }

    /**
     * Compares string1 and string2 and returns a comma-delimited concatenated
     * string consisting of the string that is first lexically followed by the
     * string that is second lexically. If the strings are equal, then only string1
     * is returned.
     *
     * @param string1 String to compare against string2.
     * @param string2 String to compare against string1.
     * @return A concatenation of string1 and string2 in order.
     */
    public static String pairs(String string1, String string2) {
    	String line = null;

    	// your code here
    	int comparison = string1.compareTo(string2);

    	if (comparison < 0) {

    	    line = string1 + "," + string2;
    	} else if (comparison > 0) {
    	    line = string2 + "," + string1;
    	} else {
    	    line = string1;
    	}

    	return line;
        }
    public static int stringDistance(String string1, String string2) {
    	int distance = 0;

    	// your code here
    	if (string1.length() != string2.length()) {
    	    return -1;
    	}

    	for (int i = 0; i < string1.length(); i++) {
    	    if (string1.charAt(i) != string2.charAt(i)) {
    		distance++;
    	    }
    	}
    	return distance;
        }
}
