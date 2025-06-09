package cp213;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * View and update the right triangle model with buttons.
 *
 * @author Devansh Jain 169061596 jain1596@mylaurier.ca
 * @author David Brown from Byron Weber-Becker
 * @version 2022-07-11
 */
@SuppressWarnings("serial")
public class RTSameView extends JPanel {

    /**
     * An inner class that uses an ActionListener to access buttons. It sets the
     * model values when the button is pressed. The value of its 'direction'
     * attribute determines whether the base and height values are incremented (1),
     * decremented (-1), or set to an average of the base and height (0).
     */
    private class ButtonListener implements ActionListener {
	/**
	 * Determines whether the base and height values are incremented (1),
	 * decremented (-1), or set to an average of the base and height (0).
	 */
	private int direction = 0;

	public ButtonListener(final int direction) {
	    this.direction = direction;
	}

	@Override
	public void actionPerformed(final ActionEvent evt) {
	    double base = model.getBase();
	    double height = model.getHeight();

	    if (direction == 1) {
		model.setBase(base + 1);
		model.setHeight(height + 1);
	    } else if (direction == -1) {
		model.setBase(base - 1);
		model.setHeight(height - 1);
	    } else if (direction == 0) {
		double average = (base + height) / 2;
		model.setBase(average);
		model.setHeight(average);
	    }
	}
    }

    /**
     * An inner class the updates the baseHeight and hypotenuse labels whenever the
     * model's base attribute is updated.
     */
    private class ValuesListener implements PropertyChangeListener {

	@Override
	public void propertyChange(final PropertyChangeEvent evt) {
	    double base = model.getBase();
	    double height = model.getHeight();

	    if (base == height) {
		baseHeight.setText(DECIMAL_FORMAT.format(base));
	    } else {
		baseHeight.setText("");
	    }
	    hypo.setText(DECIMAL_FORMAT.format(model.getHypotenuse()));
	}
    }

    // ---------------------------------------------------------------
    /**
     * The format string for reading / displaying numeric input / output.
     */
    private static final String FORMAT_STRING = "###.##";
    /**
     * The formatters for reading / displaying numeric input / output.
     */
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat(FORMAT_STRING);
    /**
     * Sets base and height to average.
     */
    private final JButton average = new JButton("==");
    /**
     * The base and height label.
     */
    private final JLabel baseHeight = new JLabel(" ");
    /**
     * Decrements base and height by 1.
     */
    private final JButton bothDown = new JButton("-");
    /**
     * Increments base and height by 1.
     */
    private final JButton bothUp = new JButton("+");
    /**
     * The hypotenuse value field - cannot be edited by the user.
     */
    private final JLabel hypo = new JLabel(" ");
    /**
     * The right triangle model.
     */
    private final RTModel model;

    /**
     * The view constructor.
     *
     * @param model The right triangle model to view.
     */
    public RTSameView(final RTModel model) {
	this.model = model;
	this.layoutView();
	this.registerListeners();
	// Initialize the view labels.
	double base = model.getBase();
	double height = model.getHeight();
	// Initialize the widget values.
	if (base == height) {
	    baseHeight.setText(DECIMAL_FORMAT.format(base));
	} else {
	    baseHeight.setText("");
	}
	this.hypo.setText(DECIMAL_FORMAT.format(this.model.getHypotenuse()));
    }

    /**
     * Uses the BoxLayout to place the labels and numeric fields.
     */
    private void layoutView() {
	// Define the panel border.
	this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	// Define the widgets.
	this.baseHeight.setHorizontalAlignment(SwingConstants.RIGHT);
	this.hypo.setHorizontalAlignment(SwingConstants.RIGHT);
	// Lay out the panel.
	this.setLayout(new GridLayout(3, 3));
	this.add(this.bothUp);
	this.add(this.bothDown);
	this.add(this.average);

	this.add(new JLabel("Base/Height: "));
	this.add(this.baseHeight);
	this.add(new JLabel(""));
	this.add(new JLabel("Hypotenuse: "));
	this.add(this.hypo);
    }

    /**
     * Assigns listeners to the field widgets and the model.
     */
    private void registerListeners() {
	// Add widget listeners.
	this.bothUp.addActionListener(new ButtonListener(1));
	this.bothDown.addActionListener(new ButtonListener(-1));
	this.average.addActionListener(new ButtonListener(0));
	// Add model listeners.
	this.model.addPropertyChangeListener(new ValuesListener());
    }
}
