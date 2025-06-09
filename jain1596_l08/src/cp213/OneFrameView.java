package cp213;

import java.awt.BorderLayout;

import javax.swing.JPanel;

/**
 * Puts five right triangle views into the same JPanel using various layouts.
 *
 * @author Devansh Jain 169061596 jain1596@mylaurier.ca
 * @author David Brown from Byron Weber-Becker
 * @version 2022-07-09
 */
@SuppressWarnings("serial")
public class OneFrameView extends JPanel {
    // The model views.
    private RTButtonView bView = null;
    private RTGraphicView gView = null;
    private RTNumericView nView = null;
    private RTSameView sView = null;
    private RTSliderView slView = null;

    /**
     * View constructor.
     *
     * @param model The model to attach the individual views to.
     */
    public OneFrameView(final RTModel model) {
	this.nView = new RTNumericView(model);
	this.bView = new RTButtonView(model);
	this.gView = new RTGraphicView(model);
	this.sView = new RTSameView(model);
	this.slView = new RTSliderView(model);
	this.layoutView();
    }

    /**
     * Lays out the individual model views within the main frame.
     */
    private void layoutView() {
	this.setLayout(new BorderLayout());
	this.add(this.gView, BorderLayout.CENTER);
	this.add(this.nView, BorderLayout.WEST);
	this.add(this.bView, BorderLayout.NORTH);
	this.add(this.sView, BorderLayout.SOUTH); // Add SameView
	this.add(this.slView, BorderLayout.EAST); // Add SliderView
    }
}
