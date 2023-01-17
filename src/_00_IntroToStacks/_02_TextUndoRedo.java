package _00_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel.
	 * 
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 */

	Stack<Character> stack = new Stack<Character>();
	StringBuilder test = new StringBuilder("");
	String f = "asdfasdf";
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel("" + test);

	void setup() {
		frame.setVisible(true);
		frame.setSize(600, 300);
		frame.add(panel);
		panel.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stun
		if (arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			stack.push(test.toString().charAt(test.length() - 1));
			test.delete(test.length() - 1, test.length());
			label.setText(test.toString());

		} else if (arg0.getKeyCode() == KeyEvent.VK_ALT) {
			test.append(stack.pop());
			label.setText(test.toString());
		}

		else {
			System.out.println(arg0.getKeyChar());
			test.append(arg0.getKeyChar());
			label.setText(test.toString());

		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}