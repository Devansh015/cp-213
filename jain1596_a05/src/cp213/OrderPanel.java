package cp213;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The GUI for the Order class.
 *
 * @author Devansh Jain, 169061596 jain1596@mylaurier.ca
 * @author David Brown
 * @version 2024-11-28
 */
@SuppressWarnings("serial")
public class OrderPanel extends JPanel {

    /**
     * Implements an ActionListener for the 'Print' button. Prints the current
     * contents of the Order to a system printer or PDF.
     */
    private class PrintListener implements ActionListener {
        @Override
        public void actionPerformed(final ActionEvent e) {
            System.out.println(order.toString());
        }
    }

    /**
     * Implements a FocusListener on a JTextField. Accepts only positive integers,
     * all other values are reset to 0. Adds a new MenuItem to the Order with the
     * new quantity, updates an existing MenuItem in the Order with the new
     * quantity, or removes the MenuItem from the Order if the resulting quantity is
     * 0.
     */
    private class QuantityListener implements FocusListener {
        private MenuItem item = null;

        QuantityListener(final MenuItem item) {
            this.item = item;
        }

        @Override
        public void focusGained(FocusEvent e) {
        }

        @Override
        public void focusLost(FocusEvent e) {
            JTextField quantityEntry = (JTextField) e.getSource();
            int quantity = 0;

            try {
                quantity = Integer.parseInt(quantityEntry.getText());

                if (quantity < 0) {
                    quantity = 0;
                }
            } catch (NumberFormatException err) {
                quantity = 0;
            }

            order.update(item, quantity);

            subtotalLabel.setText(priceFormat.format(order.getSubTotal()));
            taxLabel.setText(priceFormat.format(order.getTaxes()));
            totalLabel.setText(priceFormat.format(order.getTotal()));
        }
    }

    // Attributes
    private Menu menu = null;
    private final Order order = new Order();
    private final DecimalFormat priceFormat = new DecimalFormat("$##0.00");
    private final JButton printButton = new JButton("Print");
    private final JLabel subtotalLabel = new JLabel("0");
    private final JLabel taxLabel = new JLabel("0");
    private final JLabel totalLabel = new JLabel("0");

    private JLabel nameLabels[] = null;
    private JLabel priceLabels[] = null;
    // TextFields for menu item quantities.
    private JTextField quantityFields[] = null;

    /**
     * Displays the menu in a GUI.
     *
     * @param menu The menu to display.
     */
    public OrderPanel(final Menu menu) {
        this.menu = menu;
        this.nameLabels = new JLabel[this.menu.size()];
        this.priceLabels = new JLabel[this.menu.size()];
        this.quantityFields = new JTextField[this.menu.size()];
        this.layoutView();
        this.registerListeners();
    }

    /**
     * Uses the GridLayout to place the labels and buttons.
     */
    private void layoutView() {
        this.setLayout(new GridLayout(menu.size() + 5, 3));

        this.add(new JLabel("Item"));
        this.add(new JLabel("Price"));
        this.add(new JLabel("Quantity"));

        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            nameLabels[i] = new JLabel(item.getListing());
            priceLabels[i] = new JLabel(priceFormat.format(item.getPrice()));
            quantityFields[i] = new JTextField("0");

            this.add(nameLabels[i]);
            this.add(priceLabels[i]);
            this.add(quantityFields[i]);
        }

        this.add(new JLabel("Subtotal:"));
        this.add(subtotalLabel);
        this.add(new JLabel());

        this.add(new JLabel("Tax:"));
        this.add(taxLabel);
        this.add(new JLabel());

        this.add(new JLabel("Total:"));
        this.add(totalLabel);
        this.add(new JLabel());

        this.add(printButton);
    }

    /**
     * Register the widget listeners with the widgets.
     */
    private void registerListeners() {
        // Register the PrinterListener with the print button.
        this.printButton.addActionListener(new PrintListener());

        for (int i = 0; i < menu.size(); i++) {
            quantityFields[i].addFocusListener(new QuantityListener(menu.getItem(i)));
        }
    }
}