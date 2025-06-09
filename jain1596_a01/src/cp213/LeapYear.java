package cp213;

/**
 * @author Your name and id here
 * @version 2024-09-01
 */
public class LeapYear {

    /**
     * Determines whether or not a year is a leap year.
     *
     * A leap year is defined as:
     *
     * "Every year that is exactly divisible by four is a leap year, except for
     * years that are exactly divisible by 100, but these centurial years are leap
     * years if they are exactly divisible by 400. For example, the years 1700,
     * 1800, and 1900 are not leap years, but the years 1600 and 2000 are." (United
     * States Naval Observatory)
     *
     * Thus 1996, 2000, and 2004 are leap years, but 1899, 1900, and 1901 are not
     * leap years."
     *
     * @param year The year to test (int greater than 0)
     * @return true if year is a leap year, false otherwise.
     */
	public static boolean isLeapYear(final int year) {
	    // Check if the year is divisible by 400 (leap year)
	    if (year % 400 == 0) {
	        return true;
	    }
	    
	    // Check if the year is divisible by 100 (not a leap year unless divisible by 400)
	    if (year % 100 == 0) {
	        return false;
	    }
	    
	    // Check if the year is divisible by 4 (leap year)
	    if (year % 4 == 0) {
	        return true;
	    }
	    
	    // If not divisible by 4, it's not a leap year
	    return false;
	}

}
