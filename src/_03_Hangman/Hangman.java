package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Hangman implements KeyListener {
	Stack<String> words = new Stack<String>();
	Stack<Character> stack = new Stack<Character>();
	StringBuilder bob = new StringBuilder("");
	StringBuilder bobby;
	int lifes = 6;
	int score = 0;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel("Hangman");
	JLabel label2 = new JLabel("| LIVES LEFT : " + lifes + " |");
	JLabel label3 = new JLabel("<SCORE: "+score+">");
	String letters;
	String hiddenWord;
	String currentWord;

	void setup() {
		lifes = 6;
		frame.setVisible(true);
		frame.setSize(300, 300);
		label2.setBounds(200, 200, 200, 200);
		frame.add(panel);
		panel.add(label);
		panel.add(label2);
		panel.add(label3);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);

	}

	void begining() {
		// getting amount of words

		int totalWords = Utilities.getTotalWordsInFile("dictionary.txt");
		String input = JOptionPane.showInputDialog("Enter a number between 1 and " + totalWords);
		int amountOfWords = Integer.parseInt(input);
		if (amountOfWords > totalWords) {
			JOptionPane.showMessageDialog(null, "Number is not in the range");
			System.exit(0);
		}

		// adding words to stack
		while (words.size() != amountOfWords) {
			String word = Utilities.readRandomLineFromFile("dictionary.txt");
			if (!words.contains(word)) {
				words.push(word);
			} else {

			}
		}
	}

	void code() { // pops word into game and formats it

		currentWord = words.pop();
		char[] t = currentWord.toCharArray();
		letters = Arrays.toString(t);

		String regex = "[a-z]"; // all letters
		String regex2 = "[,\\[\\]]"; // all commas and brackets
		String regex3 = "[ ]";
		bobby = new StringBuilder(letters);
		String noLetters = bobby.toString().replaceAll(regex, "*"); // replacing letters with *
		bobby = new StringBuilder(noLetters);
		String noSpace = bobby.toString().replaceAll(regex3, "");
		bobby = new StringBuilder(noSpace);
		hiddenWord = bobby.toString().replaceAll(regex2, "");
		label.setText(hiddenWord);

	}

	void gameOver() { //asks user if wants to play again
		System.out.println("The word was: \""+currentWord+"\"");
		System.out.println("FINAL SCORE: "+score);
		String answer = JOptionPane.showInputDialog("You lost all your lives. Do you want to play again(y or n)");
		if (answer.equals("y") || answer.equals("yes")) {
			lifes = 6;
			label2.setText("| LIVES LEFT : " + lifes + " |");
			words.clear();
			begining();
			code();
		} else {
			System.exit(0);
		}
	}

	void won() { //restarting the round after completion
		System.out.println(""+hiddenWord+" HAS BEEN COMPLETED");
		lifes = 6;
		label2.setText("| LIVES LEFT : " + lifes + " |");
		score++;
		label3.setText("<SCORE: "+score+">");
		code();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stun
		ArrayList<Integer> index = new ArrayList<Integer>();
		String keyPressed = "" + arg0.getKeyChar();

		for (int i = 0; i < currentWord.length(); i++) {
			if (arg0.getKeyChar() == currentWord.charAt(i)) {
				index.add(i);
			}
		}

		if (index.size() != 0) {
			for (int i = 0; i < index.size(); i++) {
				bobby = new StringBuilder(hiddenWord);
				int index2 = index.get(i);
				System.out.println("" + keyPressed + " IS part of the word!");
				hiddenWord = bobby.replace(index2, index2 + 1, keyPressed).toString();
				label.setText(hiddenWord);
			}
			if (!hiddenWord.contains("*")) {
				won();
			}
		} else {
			lifes--;
			System.out.println("" + keyPressed + " is not part of the word");
			label2.setText("| LIVES LEFT : " + lifes + " |");
			if (lifes <= 0) {
				gameOver();
			}
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
