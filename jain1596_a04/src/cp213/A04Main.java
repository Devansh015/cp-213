package cp213;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Main method and table generation methods for Assignment 4.
 *
 * @author Devansh Jain
 * @author David Brown
 * @version 2024-10-15
 */
public class A04Main {

    // Constants
    private static final String LINE = "-".repeat(40);
    private static final String TEST_LINE = "=".repeat(80);
    private static final Integer[] testData = { 1, 2, 3 };

    /**
     * The letters of the English alphabet in alphabetic order.
     */
    public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /**
     * The default test file name.
     */
    public static final String FILENAME = "decline.txt";
    /**
     * A NumberFormat object.
     */
    public static final NumberFormat NF = NumberFormat.getInstance();
    /**
     * Letters of the English alphabet in popularity order.
     */
    public static final String POPULAR = "ETAOINSHRDLUCMPFYWGBVKJXZQ";
    /**
     * A separator string.
     */
    public static final String SEPARATOR = "------------------------------";
    /**
     * Letters of the English alphabet in split by halves order.
     */
    public static final String SPLIT = "MFTCJPWADHKNRUYBEIGLOQSVXZ";
    /**
     * Array of test alphabets.
     */
    public static final String[] STRING_DATA = new String[] { ALPHABET, SPLIT, POPULAR };

    /**
     * Print a formatted table of character counts and percentages in the format:
     *
     * <pre>
     * Character Table for Comparisons File
     *
     * Char    Count Percent
     *    A  206,946    8.17
     *    B   37,498    1.48
     *    ...
     * </pre>
     *
     * Note: your data may not match this as it is file dependent.
     *
     * @param tree The BST to generate the table from.
     */
    private static void characterTable(final BST<Character> tree) {

	final ArrayList<CountedData<Character>> array = tree.inOrder();
	int totalCount = 0;

	for (final CountedData<Character> data : array) {
	    totalCount += data.getCount();
	}
	System.out.println("Char    Count Percent");

	for (final CountedData<Character> data : array) {
	    final int count = data.getCount();
	    final double percent = (double) data.getCount() / totalCount * 100;
	    System.out.format("%4s %,8d %7.2f%n", data.getData(), count, percent);
	}
	return;
    }

    /**
     * Fill a tree by inserting all letters from a string into the tree. Letters
     * must be converted to upper-case. Non-letters are ignored. The order that
     * letters are inserted into the tree determine its shape.
     *
     * @param tree   The BST/AVL/PopularityTree to fill.
     * @param string The string to read into the tree.
     */
    private static void fillTree(final BST<Character> tree, final String string) {

	for (final char letter : string.toCharArray()) {
	    final CountedData<Character> data = new CountedData<Character>(Character.toUpperCase(letter));
	    tree.insert(data);
	}
	return;
    }

    /**
     * Determine the number of comparisons to retrieve the contents of a file from a
     * tree. Attempt to retrieve every letter in the file from tree. All letters
     * must be converted to upper case.
     *
     * @param tree The BST to process.
     * @param file The file to process.
     * @return The number of comparisons necessary to find every letter in file in
     *         tree.
     */
    private static int retrieve(final BST<Character> tree, final Scanner fileScan) {

	while (fileScan.hasNextLine()) {
	    final String line = fileScan.nextLine();

	    for (final Character c : line.toCharArray()) {

		if (Character.isLetter(c)) {
		    final CountedData<Character> key = new CountedData<Character>(Character.toUpperCase(c));
		    tree.retrieve(key);
		}
	    }
	}
	return tree.getComparisons();
    }

    /**
     * Test AVL.
     */
    private static void testAVL() {
	System.out.println(TEST_LINE);
	System.out.println("Testing AVL");
	final AVL<Integer> source = new AVL<>();
	System.out.println("  isEmpty {true}: " + source.isEmpty());
	System.out.println(LINE);
	System.out.println("Insert data: " + Arrays.toString(testData));

	for (Integer i : testData) {
	    CountedData<Integer> data = new CountedData<>(i);
	    source.insert(data);
	}
	System.out.println("  isEmpty {false}: " + source.isEmpty());
	System.out.println("  Contents {[{2: 1}, {1: 1}, {3: 1}]}: " + source.levelOrder().toString());
	System.out.println("  Height {2}: " + source.getHeight());
	System.out.println(LINE);
	System.out.println();
    }

    /**
     * Test BST.
     */
    private static void testBST() {
	System.out.println(TEST_LINE);
	System.out.println("Testing BST");
	final BST<Integer> source = new BST<>();
	System.out.println("  isEmpty {true}: " + source.isEmpty());
	System.out.println(LINE);
	System.out.println("Insert data: " + Arrays.toString(testData));

	for (Integer i : testData) {
	    CountedData<Integer> data = new CountedData<>(i);
	    source.insert(data);
	}
	System.out.println("  isEmpty {false}: " + source.isEmpty());
	System.out.println("  Contents {[{1: 1}, {2: 1}, {3: 1}]}: " + source.levelOrder().toString());
	System.out.println("  Height {3}: " + source.getHeight());
	System.out.println(LINE);
	System.out.println();
    }

    /**
     * Test PopularityTree.
     */
    private static void testPopularityTree() {
	System.out.println(TEST_LINE);
	System.out.println("Testing PopularityTree");
	final PopularityTree<Integer> source = new PopularityTree<>();
	System.out.println("  isEmpty {true}: " + source.isEmpty());
	System.out.println(LINE);
	System.out.println("Insert data: " + Arrays.toString(testData));

	for (Integer i : testData) {
	    CountedData<Integer> data = new CountedData<>(i);
	    source.insert(data);
	}
	System.out.println("  isEmpty {false}: " + source.isEmpty());
	System.out.println("  Contents {[{1: 0}, {2: 0}, {3: 0}]}: " + source.levelOrder().toString());
	System.out.println("  Height {3}: " + source.getHeight());
	System.out.println(LINE);
	System.out.println();
	System.out.println("Retrieve data: ");
	CountedData<Integer> key = new CountedData<>(3);
	System.out.println("  retrieve {3: 1}: " + source.retrieve(key));
	System.out.println("  Contents {[{3: 1}, {1: 0}, {2: 0}]}: " + source.levelOrder().toString());
	System.out.println("  Height {3}: " + source.getHeight());
	System.out.println(LINE);
	System.out.println();
    }

    /**
     * Program for Assignment 4.
     *
     * @param args unused
     * @throws IOException If error on files.
     */
    public static void main(final String[] args) throws IOException {
	System.out.println("BST Data Structures Tests");
	System.out.println();
	System.out.println("Tests are of the form:");
	System.out.println("  Test Operation {expected data}: actual data");
	System.out.println("  Contents: [contents from front to rear]");
	System.out.println();

	testBST();
	testAVL();
	testPopularityTree();
	System.out.println(TEST_LINE);

	System.out.println("Testing file: " + FILENAME);
	System.out.println();
	final File comparisonsFile = new File(FILENAME);

	for (final String string : STRING_DATA) {
	    int minComparisons = Integer.MAX_VALUE;
	    String treeType = null;
	    String minTree = null;
	    System.out.println("Data String: " + string);
	    System.out.println();
	    final ArrayList<BST<Character>> trees = new ArrayList<>();
	    trees.add(new BST<Character>());
	    trees.add(new PopularityTree<Character>());
	    trees.add(new AVL<Character>());

	    for (final BST<Character> tree : trees) {
		treeType = tree.getClass().getSimpleName();
		System.out.println("  Tree Type: " + treeType);
		A04Main.fillTree(tree, string);
		final Scanner fileScan = new Scanner(comparisonsFile);
		final int comparisons = A04Main.retrieve(tree, fileScan);
		fileScan.close();
		System.out.println("  Height: " + tree.getHeight());
		System.out.println("  Comparisons: " + NF.format(comparisons));

		if (comparisons < minComparisons) {
		    minComparisons = comparisons;
		    minTree = treeType;
		}
		System.out.println();
	    }
	    System.out.println("Tree with minimum comparisons: " + minTree);
	    System.out.println(SEPARATOR);
	}
	final PopularityTree<Character> bst = new PopularityTree<>();
	A04Main.fillTree(bst, ALPHABET);
	final Scanner fileScan = new Scanner(comparisonsFile);
	A04Main.retrieve(bst, fileScan);
	fileScan.close();
	System.out.println("Character Table for Comparisons File");
	System.out.println();
	A04Main.characterTable(bst);
    }
}