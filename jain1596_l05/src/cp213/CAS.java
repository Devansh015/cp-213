package cp213;

/**
 * Inherited class in simple example of inheritance / polymorphism.
 *
 * @author Devansh Jain, 169061596, jain1596@mylaurier,ca
 * @version 2022-02-25
 */
public class CAS extends Professor {

    /**
     * Professor object.
     *
     * @param lastName   Professor's last name
     * @param firstName  Professor's first name
     * @param department Professor's department
     * @param term       Professor's term
     */

    protected String term = null;

    public CAS(final String lastName, final String firstName, final String department, final String term) {
	super(lastName, firstName, department);
	this.term = term;
    }

    public String getTerm() {
	return this.term;
    }

    @Override
    public String toString() {
	return (super.toString() + "\nTerm: " + this.term);
    }
}
