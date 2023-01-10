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

    
    void setup() {
    	

   	 frame.setVisible(true);
   	 frame.setSize(300, 300);
   	 frame.add(panel);
   	 panel.add(label);
   	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	 frame.addKeyListener(this);
    }

    public void code() {
    	int totalWords = Utilities.getTotalWordsInFile("dictionary.txt");
        String input = JOptionPane.showInputDialog("Enter a number between 1 and "+totalWords);
        int amountOfWords = Integer.parseInt(input);
        for(int i = 0; i < amountOfWords; i++) {
        	String word = Utilities.readRandomLineFromFile("dictionary.txt");
        	if(words.contains(word)) {
        		System.out.println("D");
        	}
        	else {
        		words.push(word);
        	}
        }
        System.out.println(words.size());
        String currentWord = words.pop();
        System.out.println(words.size());
        char[] t = currentWord.toCharArray();
        String letters = Arrays.toString(t);
        
        String regex = "[a-z]"; //all letters
        String regex2 = "[,]"; //all commas
        bobby = new StringBuilder(letters);
        String b = bobby.toString().replaceAll(regex, "*"); //replacing letters with *
        bobby = new StringBuilder(b);
        String f = bobby.toString().replaceAll(regex2, " ");
        label.setText(f);
        
        
        System.out.println("c"+t);

        
        
    }
    
    
    
    @Override
    public void keyPressed(KeyEvent arg0) {
   	 // TODO Auto-generated method stun
    	for(int i = 0; i <  i++) {
    		if(arg0.getKeyChar() == letters.charAt(i)) {
    			letters.replace
    		}
    	}
    	
   		 System.out.println(arg0.getKeyChar());
   		 bob.append(arg0.getKeyChar());
   		 label.setText(bob.toString());

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
