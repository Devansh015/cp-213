package cp213;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Testing class in simple example of inheritance / polymorphism.
 *
 * @author David Brown
 * @version 2022-02-25
 */
public class Main {
    public static final String SEPARATOR = "-".repeat(40);
    public static final String TASK_LINE = "=".repeat(40);

    // Create examples of Person, Student, Professor, CAS, IA.
    public static Person person1 = new Person("Snord", "Cranston");
    public static Student student1 = new Student("Sharma", "Priyanka", "7384737");
    public static Professor prof1 = new Professor("Hakim", "Abdul", "History");
    public static Person prof2 = new Professor("Rodrigues", "Estevan", "Philosophy");
    // Uncomment the following after defining CAS and IA
    //    public static IA ia1 = new IA("Chin", "Li-meng", "9857478", "CP213");
    //    private static Person iaPerson1 = new IA("Rodrigues", "Estevan", "6723564", "CP363");
    //    public static CAS cas1 = new CAS("McGarrity", "Ivan", "English", "201401");

    /**
     * Test code.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
	printExample1();
	printExample2();
	tasks();
    }

    /**
     * Adds data to and prints ArrayList.
     */
    public static void printExample1() {
	// Defines an unsorted list of Person objects. (Uses generics).
	final ArrayList<Person> people = new ArrayList<Person>();

	// Shows polymorphism - since all have base class of Person, we are allowed to
	// store all of them in the same list.
	people.add(person1);
	people.add(student1);
	people.add(prof1);
	people.add(prof2);

	System.out.println("Print Example 1 - People:");
	System.out.println();

	for (final Person person : people) {
	    // Again shows polymorphism - calls toString() appropriate to actual
	    // object type, not just Person print().
	    System.out.println(person.toString());
	    System.out.println();
	}
	System.out.println(SEPARATOR);
    }

    /**
     * Adds data to and prints TreeSet.
     */
    public static void printExample2() {
	// Defines a sorted set of Person objects. Sorted according to Person
	// compareTo method - sort applies to all child classes. (Uses generics)
	final TreeSet<Person> set = new TreeSet<Person>();

	// Shows polymorphism - since all objects have base class of Person, we are
	// allowed to store all of them in the same set.
	set.add(person1);
	set.add(student1);
	set.add(prof1);
	set.add(prof2);

	System.out.println("Print Example 2 - Sorted People:");
	System.out.println();

	for (final Person person : set) {
	    // Print all objects in sorted order by name.
	    System.out.println(person.toString());
	    System.out.println();
	}
	System.out.println();
    }

    /**
     *
     */
    public static void tasks() {
	// Defines a sorted set of Person objects. Sorted according to Person
	// compareTo method - sort applies to all child classes. (Uses generics)
	final TreeSet<Person> set = new TreeSet<Person>();

	// Shows polymorphism - since all objects have base class of Person, we are
	// allowed to store all of them in the same set.
	set.add(person1);
	set.add(student1);
	set.add(prof1);
	set.add(prof2);
	// add CAS and IA objects here

	System.out.println(TASK_LINE);
	System.out.println("Task 1 - Add CAS:");
	System.out.println();

	for (final Person person : set) {
	    // Print all objects in sorted order by name.
	    System.out.println(person.toString());
	    System.out.println();
	}
	System.out.println();
    }

}
