package cp213;

/**
 * Inherited class in simple example of inheritance / polymorphism.
 *
 * @author David Brown
 * @version 2022-02-25
 */
public class IA extends Student {

    /**
     * IA object
     *
     * @param lastName  IA's last name
     * @param firstName IA'S first name
     * @param id        IA's ID number
     * @param course    IA's course
     */

    protected String course = null;

    public IA(final String lastName, final String firstName, final String ID, final String course) {
	super(lastName, firstName, ID);
	this.course = course;
    }

//get
    public String getCourse() {
	return this.course;
    }

//to
    @Override
    public String toString() {
	return (super.toString() + "\nCourse: " + this.course);
    }
}
