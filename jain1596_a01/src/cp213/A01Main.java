package cp213;

/**
 * Sample tests for the Assignment 1 class methods. Not comprehensive - add your
 * own testing.
 *
 * @author Your name and id here
 * @version 2024-09-01
 */
public class A01Main {
    // Constants
    private static final String LINE = "-".repeat(40);
    private static final String TEST_LINE = "=".repeat(80);

    public static final String CIPHERTEXT = "AVIBROWNZCEFGHJKLMPQSTUXYD"; // for testing substitute method

    public static void main(String[] args) {
	System.out.println("Assignment 1 Methods Tests");
	System.out.println();
	System.out.println("Tests are of the form:");
	System.out.println("  Test Operation\n  {expected value}: actual value");
	System.out.println();

	testIsLeapYear();
	testIsPalindrome();
	testIsValid();
	testPigLatin();
	testClosest();
	testSumPartialHarmonic();
	testAllDigits();
	testValidSn();
	testIsPrime();
	testShift();
	testSubstitute();
    }

    /**
     * Test isLeapYear.
     */
    private static void testIsLeapYear() {
	System.out.println(TEST_LINE);
	System.out.println("Testing isLeapYear");
	System.out.println(LINE);

	Object[][] testData = { { 1900, false }, { 1996, true }, { 1999, false }, { 2000, true } };

	for (Object[] data : testData) {
	    int year = (int) data[0];
	    boolean expected = (boolean) data[1];
	    boolean actual = LeapYear.isLeapYear(year);
	    System.out.println(String.format("isLeapYear(%d)\n  {%b}: %b", year, expected, actual));
	}
	System.out.println();
    }

    /**
     * Test isPalindrome.
     */
    private static void testIsPalindrome() {
	System.out.println(TEST_LINE);
	System.out.println("Testing isPalindrome");
	System.out.println(LINE);

	Object[][] testData = { { "racecar", true }, { "A man, a plan, a canal, Panama!", true }, { "David", false } };

	for (Object[] data : testData) {
	    String string = (String) data[0];
	    boolean expected = (boolean) data[1];
	    boolean actual = Strings.isPalindrome(string);
	    System.out.println(String.format("isPalindrome(\"%s\")\n  {%b}: %b", string, expected, actual));
	}
	System.out.println();
    }

    /**
     * Test isValid.
     */
    private static void testIsValid() {
	System.out.println(TEST_LINE);
	System.out.println("Testing isValid");
	System.out.println(LINE);

	Object[][] testData = { { "a", true }, { "_a", true }, { "1a", false } };

	for (Object[] data : testData) {
	    String string = (String) data[0];
	    boolean expected = (boolean) data[1];
	    boolean actual = Strings.isValid(string);
	    System.out.println(String.format("isValid(\"%s\")\n  {%b}: %b", string, expected, actual));
	}
	System.out.println();
    }

    /**
     * Test pigLatin.
     */
    private static void testPigLatin() {
	System.out.println(TEST_LINE);
	System.out.println("Testing pigLatin");
	System.out.println(LINE);

	Object[][] testData = { { "David", "Avidday" }, { "arrow", "arrowway" }, { "yard", "ardyay" } };

	for (Object[] data : testData) {
	    String string = (String) data[0];
	    String expected = (String) data[1];
	    String actual = Strings.pigLatin(string);
	    System.out.println(String.format("pigLatin(\"%s\")\n  {\"%s\"}: \"%s\"", string, expected, actual));
	}
	System.out.println();
    }

    /**
     * Test closest.
     */
    private static void testClosest() {
	System.out.println(TEST_LINE);
	System.out.println("Testing closest");
	System.out.println(LINE);

	Object[][] testData = { { 0.0, -5.0, 5.0, -5.0 }, { 0.0, -10.0, 5.0, 5.0 } };

	for (Object[] data : testData) {
	    double target = (double) data[0];
	    double v1 = (double) data[1];
	    double v2 = (double) data[2];
	    double expected = (double) data[3];
	    double actual = Numbers.closest(target, v1, v2);
	    System.out.println(
		    String.format("closest(%.1f, %.1f, %.1f)\n  {%.1f}: %.1f", target, v1, v2, expected, actual));
	}
	System.out.println();
    }

    /**
     * Test isPrime.
     */
    private static void testIsPrime() {
	System.out.println(TEST_LINE);
	System.out.println("Testing isPrime");
	System.out.println(LINE);

	Object[][] testData = { { 7, true }, { 5, true }, { 9, false } };

	for (Object[] data : testData) {
	    int n = (int) data[0];
	    boolean expected = (boolean) data[1];
	    boolean actual = Numbers.isPrime(n);
	    System.out.println(String.format("isPrime(%d)\n  {%b}: %b", n, expected, actual));
	}
	System.out.println();
    }

    /**
     * Test sumPartialHarmonic.
     */
    private static void testSumPartialHarmonic() {
	System.out.println(TEST_LINE);
	System.out.println("Testing sumPartialHarmonic");
	System.out.println(LINE);

	Object[][] testData = { { 0, 0.0 }, { 1, 1.0 }, { 8, 2.7178571428571425 } };

	for (Object[] data : testData) {
	    int n = (int) data[0];
	    double expected = (double) data[1];
	    double actual = Numbers.sumPartialHarmonic(n);
	    System.out.println(String.format("sumPartialHarmonic(%d)\n  {%f}: %f", n, expected, actual));
	}
	System.out.println();
    }

    /**
     * Test allDigits.
     */
    private static void testAllDigits() {
	System.out.println(TEST_LINE);
	System.out.println("Testing allDigits");
	System.out.println(LINE);

	Object[][] testData = { { "a", false }, { "123", true }, { "12.3", false } };

	for (Object[] data : testData) {
	    String string = (String) data[0];
	    boolean expected = (boolean) data[1];
	    boolean actual = SerialNumber.allDigits(string);
	    System.out.println(String.format("allDigits(\"%s\")\n  {%b}: %b", string, expected, actual));
	}
	System.out.println();
    }

    /**
     * Test validSn.
     */
    private static void testValidSn() {
	System.out.println(TEST_LINE);
	System.out.println("Testing validSn");
	System.out.println(LINE);

	Object[][] testData = { { "SN/1234-567", true }, { "SN/1234567", false }, { "SN/123-4567", false } };

	for (Object[] data : testData) {
	    String string = (String) data[0];
	    boolean expected = (boolean) data[1];
	    boolean actual = SerialNumber.validSn(string);
	    System.out.println(String.format("validSn(\"%s\")\n  {%b}: %b", string, expected, actual));
	}
	System.out.println();
    }

    /**
     * Test shift.
     */
    private static void testShift() {
	System.out.println(TEST_LINE);
	System.out.println("Testing shift");
	System.out.println(LINE);

	Object[][] testData = { { "ABC", 0, "ABC" }, { "ABC", 3, "DEF" }, { "ABC", 30, "EFG" } };

	for (Object[] data : testData) {
	    String string = (String) data[0];
	    int n = (int) data[1];
	    String expected = (String) data[2];
	    String actual = Cipher.shift(string, n);
	    System.out.println(String.format("shift(\"%s\", %d)\n  {\"%s\"}: \"%s\"", string, n, expected, actual));
	}
	System.out.println();
    }

    /**
     * Test substitute.
     */
    private static void testSubstitute() {
	System.out.println(TEST_LINE);
	System.out.println("Testing substitute");
	System.out.println(LINE);

	Object[][] testData = { { "ABC", "AVI" }, { "XYZ", "XYD" } };

	for (Object[] data : testData) {
	    String string = (String) data[0];
	    String expected = (String) data[1];
	    String actual = Cipher.substitute(string, CIPHERTEXT);
	    System.out.println(
		    String.format("substitute(\"%s\", %s)\n  {\"%s\"}: \"%s\"", string, CIPHERTEXT, expected, actual));
	}
	System.out.println();
    }

}