package cp213;

import java.time.LocalDate;

/**
 * Student class definition.
 *
 * @author Devansh Jain
 * @version 2024-10-04
 */
public class Student implements Comparable<Student> {

    // Attributes
    private LocalDate birthDate = null;
    private String forename = "";
    private int id = 0;
    private String surname = "";

    /**
     * Instantiates a Student object.
     *
     * @param id        student ID number
     * @param surname   student surname
     * @param forename  name of forename
     * @param birthDate birthDate in 'YYYY-MM-DD' format
     */
    public Student(int id, String surname, String forename, LocalDate birthDate) {
	this.id = id;
	this.surname = surname;
	this.forename = forename;
	this.birthDate = birthDate;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString() Creates a formatted string of student data.
     */
    @Override
    public String toString() {
	return "Name:      " + surname + ", " + forename + "\n" + "ID:        " + id + "\nß" + "Birthdate: "
		+ birthDate;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(final Student target) {
	int result = this.surname.compareTo(target.surname);

	if (result == 0) {
	    // Surnames are equal, compare forenames
	    result = this.forename.compareTo(target.forename);

	    if (result == 0) {
		// Forenames are also equal, compare IDs
		result = Integer.compare(this.id, target.id);
	    }
	}
	return result;
    }

    // Getters and setters
    public LocalDate getBirthDate() {
	return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
	this.birthDate = birthDate;
    }

    public String getForename() {
	return forename;
    }

    public void setForename(String forename) {
	this.forename = forename;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getSurname() {
	return surname;
    }

    public void setSurname(String surname) {
	this.surname = surname;
    }
}
