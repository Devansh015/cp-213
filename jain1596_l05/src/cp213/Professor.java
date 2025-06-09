package cp213;

/**
 * Inherited class in simple example of inheritance / polymorphism.
 *
 * @author David Brown
 * @version 2022-02-25
 */
public class Professor extends Person {

    private String department = null;

    /**
     * @param lastName
     *            Professor last name (surname): defined in Person
     * @param firstName
     *            Professor first name (given name): defined in Person
     * @param department
     *            Professor department
     */
    public Professor(final String lastName, final String firstName,
	    final String department) {
	super(lastName, firstName);
	this.department = department;
    }

    /**
     * Getter for department.
     *
     * @return this.department
     */
    public String getDepartment() {
	return this.department;
    }

    /**
     * Creates formatted string version of Professor.
     */
    @Override
    public String toString() {
	return(super.toString() + "\nDepartment: " + this.department);
    }

}
