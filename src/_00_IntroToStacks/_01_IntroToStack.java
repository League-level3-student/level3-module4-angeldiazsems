package _00_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
    public static void main(String[] args) {
        // 1. Create a Stack of Doubles
        //    Don't forget to import the Stack class
    	Stack<Double> stack = new Stack<Double>();
        // 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
    	
    	Random ran = new Random();
    	
    	for(int i = 0; i < 101; i++) {
        	double r = ran.nextDouble();
        	r = r*101;
    		if(r>0.0&&r<100.0) {
    		stack.push(r);
    		}
    	}
        // 3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
    	String input1 = JOptionPane.showInputDialog("Enter a number between 1-100");
    	String input2 = JOptionPane.showInputDialog("enter a second number between 1-100");
    	
    	double num1 = Double.parseDouble(input1);
    	double num2 = Double.parseDouble(input2);
    	if(num2 > num1) {
    		double t = num2;
    		num2 =  num1;
    		num1 = t;
    	}
    	
    	//num1 will be the maxiumim^ 
    	//num2 will be the minimum
    	
        // 4. Pop all the elements off of the Stack. Every time a double is popped that is
        //    between the two numbers entered by the user, print it to the screen.
    	
    	
    	System.out.println("deleting stack...");
    	while(!stack.isEmpty()) {
    		double top = stack.pop();
    		if(top<=num1 && top>=num2) {
    			System.out.println("Popping "+top+", since it is between "+num2+" and "+num1+".");
    		}
    		
    	}
        // EXAMPLE:
        // NUM 1: 65
        // NUM 2: 75

        // Popping elements off stack...
        // Elements between 65 and 75:
        // 66.66876846
        // 74.51651681
        // 70.05110654
        // 69.21350456
        // 71.54506465
        // 66.47984807
        // 74.12121224
    }
}

