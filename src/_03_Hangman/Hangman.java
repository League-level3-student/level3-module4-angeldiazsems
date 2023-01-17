package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {
	Stack<String> words = new Stack<String>();
	Stack<Character> stack = new Stack<Character>();
	StringBuilder bob = new StringBuilder("");
	StringBuilder bobby;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel("H" + bob);
	String letters;
	String hiddenWord;
	void setup() {

		frame.setVisible(true);
		frame.setSize(300, 300);
		frame.add(panel);
		panel.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);

		// getting amount of words
		int totalWords = Utilities.getTotalWordsInFile("dictionary.txt");
		String input = JOptionPane.showInputDialog("Enter a number between 1 and " + totalWords);
		int amountOfWords = Integer.parseInt(input);
		if (amountOfWords > totalWords) {
			JOptionPane.showMessageDialog(null, "Number is not in the range");
		}

		// adding words to stack
		while (words.size() != amountOfWords) {
			String word = Utilities.readRandomLineFromFile("dictionary.txt");
			if (words.contains(word)) {
				System.out.println("D: " + word);
			} else {
				words.push(word);
				System.out.println(word);
			}
		}

	}

	public void code() {

		System.out.println(words.size());
		String currentWord = words.pop();
		System.out.println(words.size());
		char[] t = currentWord.toCharArray();
		letters = Arrays.toString(t);

		String regex = "[a-z]"; // all letters
		String regex2 = "[,]"; // all commas
		bobby = new StringBuilder(letters);
		String noLetters = bobby.toString().replaceAll(regex, "*"); // replacing letters with *
		bobby = new StringBuilder(noLetters);
		hiddenWord = bobby.toString().replaceAll(regex2, " ");
		label.setText(hiddenWord);

		System.out.println("" + letters);

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stun
		for (int i = 0; i < letters.length(); i++) {
			if (arg0.getKeyChar() == letters.charAt(i)) {
				System.out.println("right key");
				String rep = "["+letters.charAt(i)+"]";
				String rep2 = "[*]";
				hiddenWord.replaceAll(rep2, rep);
				
			}
		}

	//	System.out.println(arg0.getKeyChar());
	//	bob.append(arg0.getKeyChar());
	//	label.setText(bob.toString());

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
