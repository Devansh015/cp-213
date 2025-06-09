package cp213;

/**
 * @author Your name and id here
 * @version 2024-09-01
 */
public class Cipher {
    // Constants
    public static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final int ALPHA_LENGTH = ALPHA.length();

    /**
     * Encipher a string using a shift cipher. Each letter is replaced by a letter
     * 'n' letters to the right of the original. Thus for example, all shift values
     * evenly divisible by 26 (the length of the English alphabet) replace a letter
     * with itself. Non-letters are left unchanged.
     *
     * @param s string to encipher
     * @param n the number of letters to shift
     * @return the enciphered string in all upper-case
     */
    public static String shift(final String s, final int n) {
        // Normalize the shift value to stay within the bounds of the alphabet length
        int shiftValue = n % ALPHA_LENGTH;
        
        // Convert the input string to upper case
        String upperCaseStr = s.toUpperCase();
        
        // Initialize a StringBuilder to build the enciphered string
        StringBuilder result = new StringBuilder();
        
        // Iterate over each character in the input string
        for (int i = 0; i < upperCaseStr.length(); i++) {
            char currentChar = upperCaseStr.charAt(i);
            
            // Check if the character is a letter
            if (Character.isLetter(currentChar)) {
                // Find the position of the letter in the alphabet (0-based index)
                int originalPosition = ALPHA.indexOf(currentChar);
                
                // Compute the new shifted position
                int newPosition = (originalPosition + shiftValue) % ALPHA_LENGTH;
                
                // Append the shifted letter to the result
                result.append(ALPHA.charAt(newPosition));
            } else {
                // If it's not a letter, leave it unchanged
                result.append(currentChar);
            }
        }
        
        // Return the final enciphered string
        return result.toString();
    }

    /**
     * Encipher a string using the letter positions in ciphertext. Each letter is
     * replaced by the letter in the same ordinal position in the ciphertext.
     * Non-letters are left unchanged. Ex:
     *
     * <pre>
    Alphabet:   ABCDEFGHIJKLMNOPQRSTUVWXYZ
    Ciphertext: AVIBROWNZCEFGHJKLMPQSTUXYD
     * </pre>
     *
     * A is replaced by A, B by V, C by I, D by B, E by R, and so on. Non-letters
     * are ignored.
     *
     * @param s          string to encipher
     * @param ciphertext ciphertext alphabet
     * @return the enciphered string in all upper-case
     */
    public static String substitute(final String s, final String ciphertext) {
        // Convert the input string to uppercase
        String upperCaseStr = s.toUpperCase();
        
        // Initialize a StringBuilder to build the enciphered string
        StringBuilder result = new StringBuilder();
        
        // Iterate over each character in the input string
        for (int i = 0; i < upperCaseStr.length(); i++) {
            char currentChar = upperCaseStr.charAt(i);
            
            // Check if the character is a letter
            if (Character.isLetter(currentChar)) {
                // Find the position of the letter in the ALPHA string
                int originalPosition = ALPHA.indexOf(currentChar);
                
                // Substitute it with the letter at the same index in the ciphertext
                result.append(ciphertext.charAt(originalPosition));
            } else {
                // If it's not a letter, leave it unchanged
                result.append(currentChar);
            }
        }
        
        // Return the final enciphered string
        return result.toString();
    }

}
