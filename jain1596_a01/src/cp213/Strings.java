package cp213;

/**
 * @author Your name and id here
 * @version 2024-09-01
 */
public class Strings {
    // Constants
    public static final String VOWELS = "aeiouAEIOU";

    /**
     * Determines if string is a "palindrome": a word, verse, or sentence (such as
     * "Able was I ere I saw Elba") that reads the same backward or forward. Ignores
     * case, spaces, digits, and punctuation in the string parameter s.
     *
     * @param string a string
     * @return true if string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(final String string) {
        // Use StringBuilder to store only the alphabetic characters in lowercase
        StringBuilder cleanedString = new StringBuilder();
        
        // Iterate over each character in the string
        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            
            // Check if the character is a letter and add it to cleanedString
            if (Character.isLetter(currentChar)) {
                cleanedString.append(Character.toLowerCase(currentChar));
            }
        }
        
        // Convert cleanedString to a new String
        String filteredString = cleanedString.toString();
        
        // Create a reversed version of the filteredString
        String reversedString = cleanedString.reverse().toString();
        
        // Check if the original filteredString is equal to the reversedString
        return filteredString.equals(reversedString);
    }

    /**
     * Determines if name is a valid Java variable name. Variables names must start
     * with a letter or an underscore, but cannot be an underscore alone. The rest
     * of the variable name may consist of letters, numbers and underscores.
     *
     * @param name a string to test as a Java variable name
     * @return true if name is a valid Java variable name, false otherwise
     */
    public static boolean isValid(final String name) {
        // Check if the name is empty or null
        if (name == null || name.isEmpty()) {
            return false;
        }
        
        // Check if the name is just a single underscore
        if (name.equals("_")) {
            return false;
        }
        
        // Check the first character (it must be a letter or an underscore)
        char firstChar = name.charAt(0);
        if (!Character.isLetter(firstChar) && firstChar != '_') {
            return false;
        }
        
        // Check the rest of the characters (they must be letters, digits, or underscores)
        for (int i = 1; i < name.length(); i++) {
            char currentChar = name.charAt(i);
            if (!Character.isLetterOrDigit(currentChar) && currentChar != '_') {
                return false;
            }
        }
        
        // If all checks pass, the name is valid
        return true;
    }

    /**
     * Converts a word to Pig Latin. The conversion is:
     * <ul>
     * <li>if a word begins with a vowel, add "way" to the end of the word.</li>
     * <li>if the word begins with consonants, move the leading consonants to the
     * end of the word and add "ay" to the end of that. "y" is treated as a
     * consonant if it is the first character in the word, and as a vowel for
     * anywhere else in the word.</li>
     * </ul>
     * Preserve the case of the word - i.e. if the first character of word is
     * upper-case, then the new first character should also be upper case.
     *
     * @param word The string to convert to Pig Latin
     * @return the Pig Latin version of word
     */
    
    public static String pigLatin(String word) {
        String firstLetter = word.substring(0, 1);
        
        if (VOWELS.contains(firstLetter)) {
            return word + "way";
        }

        int firstVowelIndex = -1;
        for (int i = 1; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (VOWELS.contains(String.valueOf(currentChar)) || currentChar == 'y' || currentChar == 'Y') {
                firstVowelIndex = i;
                break;
            }
        }

        if (firstVowelIndex == -1) {
            return word + "ay";
        }

        String prefix = word.substring(0, firstVowelIndex);
        String restOfWord = word.substring(firstVowelIndex);

        if (Character.isUpperCase(word.charAt(0))) {
            restOfWord = restOfWord.substring(0, 1).toUpperCase() + restOfWord.substring(1);
            prefix = prefix.toLowerCase();
        }

        return restOfWord + prefix + "ay";
    }
}
