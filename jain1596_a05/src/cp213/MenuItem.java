package cp213;

import java.math.BigDecimal;

/**
 * Defines the listing and price of a menu item. Price is stored as a BigDecimal
 * to avoid rounding errors.
 *
 * @author Devansh Jain, 169061596 jain1596@mylaurier.ca
 * @author David Brown
 * @version 2024-11-28
 */
public class MenuItem {

    // Attributes
    private static final String itemFormat = "%-12s $%5.2f";
    private String listing = null;
    private BigDecimal price = null;

    /**
     * Constructor. Must set price to 2 decimal points for calculations.
     *
     * @param listing Listing of the menu item.
     * @param price   Price of the menu item.
     */
    public MenuItem(final String listing, final BigDecimal price) {
        this.listing = listing;
        this.price = price.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * Alternate constructor. Converts a double price to BigDecimal.
     *
     * @param listing Listing of the menu item.
     * @param price   Price of the menu item.
     */
    public MenuItem(final String listing, final double price) {
        this(listing, BigDecimal.valueOf(price));
    }

    /**
     * listing getter
     *
     * @return Listing of the menu item.
     */
    public String getListing() {
        return this.listing;
    }

    /**
     * price getter
     *
     * @return Price of the menu item.
     */
    public BigDecimal getPrice() {
        return this.price;
    }

    /**
     * Returns a MenuItem as a String in the format:
     *
     * <pre>
    hot dog      $ 1.25
    pizza        $10.00
     * </pre>
     */
    @Override
    public String toString() {
        return String.format(itemFormat, this.listing, this.price);
    }
}