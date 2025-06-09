package cp213;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * View and update the right triangle model with sliders.
 *
 * @author Devansh Jain 169061596 jain1596@mylaurier.ca
 * @author David Brown from Byron Weber-Becker
 * @version 2022-07-11
 */
@SuppressWarnings("serial")
public class RTSliderView extends JPanel {

    /**
     * An inner class that accesses the base slider.
     */
    private class BaseSliderListener implements ChangeListener {

	@Override
	public void stateChanged(final ChangeEvent e) {
	    int baseValue = baseSlider.getValue();
	    model.setBase(baseValue);
	}
    }

    /**
     * An inner class that accesses the height slider.
     */
    private class HeightSliderListener implements ChangeListener {

	@Override
	public void stateChanged(final ChangeEvent e) {
	    int heightValue = heightSlider.getValue();
	    model.setHeight(heightValue);
	}
    }

    /**
     * An inner class the updates the sliders and hypotenuse label whenever the
     * model's attributes are updated.
     */
    private class ValuesListener implements PropertyChangeListener {

	@Override
	public void propertyChange(final PropertyChangeEvent evt) {
	    baseSlider.setValue((int) model.getBase());
	    heightSlider.setValue((int) model.getHeight());
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
     * The slider to adjust the Right Triangle base.
     */
    private final JSlider baseSlider = new JSlider(JSlider.HORIZONTAL, 0, (int) RTModel.MAX_SIDE, 1);
    /**
     * The slider to adjust the Right Triangle height.
     */
    private final JSlider heightSlider = new JSlider(JSlider.VERTICAL, 0, (int) RTModel.MAX_SIDE, 1);
    /**
     * The hypotenuse value field - cannot be edited by the user.
     */
    private final JLabel hypo = new JLabel(" ");
    /**
     * The right triangle model.
     */
    private final RTModel model;

    /**
     * The View constructor.
     *
     * @param model The model to view.
     */
    public RTSliderView(final RTModel model) {
	this.model = model;
	this.layoutView();
	this.registerListeners();
	// Initialize the widget values.
	this.baseSlider.setValue((int) model.getBase());
	this.heightSlider.setValue((int) model.getHeight());
	this.hypo.setText(DECIMAL_FORMAT.format(model.getHypotenuse()));
    }

    /**
     * Uses the BorderLayout to place the widgets.
     */
    private void layoutView() {
	// Define the panel border.
	this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	// Lay out the panel.
	this.setLayout(new BorderLayout());
	this.add(this.hypo, BorderLayout.CENTER);
	this.add(this.heightSlider, BorderLayout.EAST);
	this.add(this.baseSlider, BorderLayout.SOUTH);
    }

    /**
     * Assigns listeners to the field widgets and the model.
     */
    private void registerListeners() {
	// Add widget listeners.
	this.baseSlider.addChangeListener(new BaseSliderListener());
	this.heightSlider.addChangeListener(new HeightSliderListener());
	// Add model listeners.
	this.model.addPropertyChangeListener(new ValuesListener());
    }
}
