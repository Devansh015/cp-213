package cp213;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Arrays Lab task methods.
 *
 * @author Devansh Jain 169061596 jain1596@mylaurier.ca
 * @version 2022-01-25
 */


public class ArraysTest {

    /**
     * Tests arrays.
     *
     * @param args unused default parameter
     */
    public static void main(final String[] args) {
        System.out.println("Task 1");
        System.out.println(ArraysTest.task1());
        System.out.println("Task 2");
        System.out.println(ArraysTest.task2());
        System.out.println("Task 3");
        System.out.println(ArraysTest.task3());
        System.out.println("Task 4");
        System.out.println(ArraysTest.task4());
        System.out.println("Task 5");
        System.out.println(Arrays.toString(ArraysTest.task5()));
    }

    /**
     * Demonstrates if second is a reference or a copy of first.
     * 
     * @return true if second is updated with first, false if it is a copy
     */
    public static boolean task1() {
        final int[] first = { 1, 3, 5, 7, 9 };
        final int[] second = first;

        System.out.println("Values in first:");
        for (int i = 0; i < first.length; i++) {
            System.out.println(first[i]);
        }

        System.out.println("Values in second:");
        for (int i = 0; i < second.length; i++) {
            System.out.println(second[i]);
        }

        // Modify first by multiplying each element by 2 using a standard for loop
        for (int i = 0; i < first.length; i++) {
            first[i] = first[i] * 2;
        }

        // Print modified arrays
        System.out.println("After modification of first:");
        System.out.println("First: " + Arrays.toString(first));
        System.out.println("Second: " + Arrays.toString(second));

        // Since second references first, any change to first is reflected in second
        return Arrays.equals(first, second);
    }

    /**
     * Change the values of first by multiplying each element by 2 using a standard for loop.
     * Demonstrates if second is a reference or copy.
     *
     * @return true if second is updated, false if not
     */
    public static boolean task2() {
        final int[] first = { 1, 3, 5, 7, 9 };
        final int[] second = first;

        // Modify first by multiplying each element by 2
        for (int i = 0; i < first.length; i++) {
            first[i] = first[i] * 2;
        }

        System.out.println("Modified first: " + Arrays.toString(first));
        System.out.println("Second: " + Arrays.toString(second));

        // Since second references first, second will reflect the changes in first
        return Arrays.equals(first, second);
    }

    /**
     * Change the values of first using an enhanced for loop.
     * Demonstrates if first is permanently changed.
     *
     * @return true if the contents of first are permanently changed, false otherwise
     */
    public static boolean task3() {
        final int[] first = { 1, 3, 5, 7, 9 };

        // Enhanced for loop (won't modify the original array)
        for (int value : first) {
            value = value * 2;  // This modifies the copy of the value, not the array itself
        }

        // Printing the array to demonstrate that it has not changed
        System.out.println("First after enhanced for loop: " + Arrays.toString(first));

        // The values are not permanently changed, so return false
        return false;
    }

    /**
     * Assign the first array to a row of a 2D array.
     * Demonstrates if this syntax is valid or not.
     *
     * @return true if the syntax is valid, false otherwise
     */
    public static boolean task4() {
        final int[] first = { 1, 3, 5, 7, 9 };
        final int[][] third = new int[2][5];

        // Attempt to assign the array first to a row of the 2D array
        third[0] = first;  // This is valid syntax in Java

        // Print the first row of the 2D array
        System.out.println("third[0]: " + Arrays.toString(third[0]));

        // This syntax is valid, so return true
        return true;
    }

    /**
     * Assign values 0 through 9 to an ArrayList and convert to a simple Integer array.
     *
     * @return Integer array containing values 0 through 9
     */
    public static Integer[] task5() {
        final ArrayList<Integer> values = new ArrayList<>();

        // Populate the ArrayList with values from 0 to 9
        for (int i = 0; i <= 9; i++) {
            values.add(i);
        }

        // Convert ArrayList to an array of Integer using the toArray method
        Integer[] valuesArray = values.toArray(new Integer[0]);

        return valuesArray;
    }
}
