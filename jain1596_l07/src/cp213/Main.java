package cp213;

import javax.swing.JFrame;

/**
 * Testing simple example of GUI widgets and inner classes.
 *
 * @author David Brown
 * @version 2022-07-09
 */
public class Main {

    /**
     * Test code.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
	// Create the display panel.
	final InnerClassPanel view = new InnerClassPanel();
	// Create the program frame and add the panel to it.
	final JFrame f = new JFrame("Inner Class Examples");
	f.setContentPane(view);
	f.setSize(300, 500);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);
    }
}
