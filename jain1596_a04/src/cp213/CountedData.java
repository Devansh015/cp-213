package cp213;

/**
 * Stores a data and an occurrence count for that data. The data must be
 * Comparable so that it can be compared and sorted against other datas of the
 * same type.
 *
 * @author David Brown
 * @version 2024-10-15
 */
public class CountedData<T extends Comparable<T>> implements Comparable<CountedData<T>> {

    // Attributes.
    private int count = 0; // data count
    private T data = null; // data

    /**
     * Copy constructor.
     *
     * @param source Another CountedData object.
     */
    public CountedData(final CountedData<T> source) {
	this.data = source.data;
	this.count = source.count;
    }

    /**
     * Constructor for key version of object. (data count defaults to 0)
     *
     * @param data The data to be counted.
     */
    public CountedData(final T data) {
	this.data = data;
    }

    /**
     * Constructor.
     *
     * @param data  The data to be counted.
     * @param count The data count.
     */
    public CountedData(final T data, final int count) {
	this.data = data;
	this.count = count;
    }

    /**
     * Comparison method for data datas. Compares only the stored datas, counts are
     * ignored. Returns:
     * <ul>
     * <li>0 if this equals target</li>
     * <li>&lt; 0 if this precedes target</li>
     * <li>&gt; 0 if this follows target</li>
     * </ul>
     *
     * @param target CountedData object to compare against.
     * @return Comparison result.
     */
    @Override
    public int compareTo(CountedData<T> target) {
	return this.data.compareTo(target.data);
    }

    /**
     * Decrements the data count.
     */
    public void decrementCount() {
	this.count--;
    }

    /**
     * Returns this data count.
     *
     * @return this data count.
     */
    public int getCount() {
	return this.count;
    }

    /**
     * Returns this data.
     *
     * @return this data.
     */
    public T getData() {
	return this.data;
    }

    /**
     * Returns a copy of the current object.
     *
     * @return
     */
    public CountedData<T> copy() {
	return new CountedData<T>(this.data, this.count);
    }

    /**
     * Increments the data count.
     */
    public void incrementCount() {
	this.count++;
    }

    /**
     * Sets the data count.
     *
     * @param count the new data count.
     */
    public void setCount(final int count) {
	this.count = count;
	return;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return String.format("{%s: %d}", this.data.toString(), this.count);
    }

}
