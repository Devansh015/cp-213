package cp213;

import javax.swing.JFrame;

/**
 * Displays all views of the Right Triangle in the same frame.
 *
 * @author David Brown from Byron Weber-Becker
 * @version 2022-07-09
 */
public class OneFrameMain {

    public static void main(final String args[]) {
	final RTModel model = new RTModel();
	final OneFrameView view = new OneFrameView(model);

	final JFrame f = new JFrame("Right Triangle");
	f.setContentPane(view);
	f.setSize(600, 500);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);
    }
}
