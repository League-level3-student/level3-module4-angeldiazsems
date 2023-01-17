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

public class Hangman implements KeyListener {
	Stack<String> words = new Stack<String>();
	Stack<Character> stack = new Stack<Character>();
	StringBuilder bob = new StringBuilder("");
	StringBuilder bobby;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel("Hangman");
	String letters;
	String hiddenWord;
	String currentWord;

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
			if (!words.contains(word)) {
				words.push(word);
				System.out.println(word);
			} else {
				
			}
		}

	}

	void code() {

		System.out.println(words.size());
		currentWord = words.pop();
		System.out.println(words.size());
		char[] t = currentWord.toCharArray();
		letters = Arrays.toString(t);

		String regex = "[a-z]"; // all letters
		String regex2 = "[,\\[\\]]"; // all commas and brackets
		String regex3 = "[ ]";
		bobby = new StringBuilder(letters);
		String noLetters = bobby.toString().replaceAll(regex, "*"); // replacing letters with *
		bobby = new StringBuilder(noLetters);
		String noSpace  = bobby.toString().replaceAll(regex3, "");
		bobby = new StringBuilder(noSpace);
		hiddenWord = bobby.toString().replaceAll(regex2, "");
		label.setText(hiddenWord);

		System.out.println("" + letters);

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stun
		ArrayList<Integer> index = new ArrayList<Integer>();
		String keyPressed = ""+arg0.getKeyChar();
		
		for (int i = 0; i < currentWord.length(); i++) {
			if (arg0.getKeyChar() == currentWord.charAt(i)) {
				index.add(i);
			}
		}
		System.out.println(""+arg0.getKeyChar()+" is at index : "+index);
		
		for(int i =0; i < index.size(); i++) {
			bobby = new StringBuilder(hiddenWord);
			int index2 = index.get(i);			
			hiddenWord = bobby.replace(index2, index2+1, keyPressed).toString();
			System.out.println("Replacing");
			label.setText(hiddenWord);
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
