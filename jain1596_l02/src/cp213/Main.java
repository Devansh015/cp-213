package cp213;

/**
 * Sample tests for the Assignment 1 class methods. Not comprehensive - add your
 * own testing.
 *
 * @author your name, ID, and email here
 * @version 2022-05-06
 */
public class Main {
    // Constants
    private static final String LINE = "-".repeat(40);
    private static final String TEST_LINE = "=".repeat(80);

    /**
     * @param args Unused.
     */
    public static void main(String[] args) {
	System.out.println("Strings Lab Methods Tests");
	System.out.println();
	System.out.println("Tests are of the form:");
	System.out.println("  Test Operation\n  {expected value}: actual value");
	System.out.println();

	testVowelCount();
	testDigitCount();
	testTotalDigits();
	testPairs();
	testStringDistance();
	System.out.println(TEST_LINE);
	System.out.println("Done");
    }

    /**
     * Test vowelCount.
     */
    private static void testVowelCount() {
	System.out.println(TEST_LINE);
	System.out.println("Testing vowelCount");
	System.out.println(LINE);

	String line = StringMethods.VOWELS;
	int expected = line.length();
	int actual = StringMethods.vowelCount(line);
	System.out.println("vowelCount(\"" + line + "\")\n  {" + expected + "}: " + actual);
	line = "";
	expected = 0;
	actual = StringMethods.vowelCount(line);
	System.out.println("vowelCount(\"" + line + "\")\n  {" + expected + "}: " + actual);
	line = "BCDfgh";
	expected = 0;
	actual = StringMethods.vowelCount(line);
	System.out.println("vowelCount(\"" + line + "\")\n  {" + expected + "}: " + actual);
	line = "This line has some vowels.";
	expected = 8;
	actual = StringMethods.vowelCount(line);
	System.out.println("vowelCount(\"" + line + "\")\n  {" + expected + "}: " + actual);
	System.out.println();
    }

    private static void testDigitCount() {
	System.out.println(TEST_LINE);
	System.out.println("Testing digitCount");
	System.out.println(LINE);

	String line = "";
	int expected = line.length();
	int actual = StringMethods.digitCount(line);
	System.out.println("digitCount(\"" + line + "\")\n  {" + expected + "}: " + actual);
	line = "1";
	expected = 1;
	actual = StringMethods.digitCount(line);
	System.out.println("digitCount(\"" + line + "\")\n  {" + expected + "}: " + actual);
	line = "Easy as 1, 2, 3.";
	expected = 3;
	actual = StringMethods.digitCount(line);
	System.out.println("digitCount(\"" + line + "\")\n  {" + expected + "}: " + actual);
	System.out.println();
    }

    private static void testTotalDigits() {
	System.out.println(TEST_LINE);
	System.out.println("Testing totalDigits");
	System.out.println(LINE);

	String line = "";
	int expected = line.length();
	int actual = StringMethods.totalDigits(line);
	System.out.println("totalDigits(\"" + line + "\")\n  {" + expected + "}: " + actual);
	line = "1";
	expected = 1;
	actual = StringMethods.totalDigits(line);
	System.out.println("totalDigits(\"" + line + "\")\n  {" + expected + "}: " + actual);
	line = "Easy as 1, 2, 3.";
	expected = 6;
	actual = StringMethods.totalDigits(line);
	System.out.println("totalDigits(\"" + line + "\")\n  {" + expected + "}: " + actual);
	System.out.println();
    }

    private static void testPairs() {
	System.out.println(TEST_LINE);
	System.out.println("Testing pairs");
	System.out.println(LINE);

	String s1 = "a";
	String s2 = "b";
	String expected = "a,b";
	String actual = StringMethods.pairs(s1, s2);
	System.out.println("pairs(\"" + s1 + "\", \"" + s2 + "\")\n  {" + expected + "}: " + actual);
	s1 = "b";
	s2 = "a";
	expected = "a,b";
	actual = StringMethods.pairs(s1, s2);
	System.out.println("pairs(\"" + s1 + "\", \"" + s2 + "\")\n  {" + expected + "}: " + actual);
	s1 = "line";
	s2 = "line";
	expected = "line";
	actual = StringMethods.pairs(s1, s2);
	System.out.println("pairs(\"" + s1 + "\", \"" + s2 + "\")\n  {" + expected + "}: " + actual);
	System.out.println();
    }

    private static void testStringDistance() {
	System.out.println(TEST_LINE);
	System.out.println("Testing stringDistance");
	System.out.println(LINE);

	String s1 = "a";
	String s2 = "a";
	int expected = 0;
	int actual = StringMethods.stringDistance(s1, s2);
	System.out.println("stringDistance(\"" + s1 + "\", \"" + s2 + "\")\n  {" + expected + "}: " + actual);
	s1 = "a";
	s2 = "b";
	expected = 1;
	actual = StringMethods.stringDistance(s1, s2);
	System.out.println("stringDistance(\"" + s1 + "\", \"" + s2 + "\")\n  {" + expected + "}: " + actual);
	s1 = "North";
	s2 = "South";
	expected = 2;
	actual = StringMethods.stringDistance(s1, s2);
	System.out.println("stringDistance(\"" + s1 + "\", \"" + s2 + "\")\n  {" + expected + "}: " + actual);
	s1 = "short";
	s2 = "longer";
	expected = -1;
	actual = StringMethods.stringDistance(s1, s2);
	System.out.println("stringDistance(\"" + s1 + "\", \"" + s2 + "\")\n  {" + expected + "}: " + actual);
    }

}