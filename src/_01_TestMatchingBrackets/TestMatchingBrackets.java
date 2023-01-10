package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
	/*
	 * Use a Stack to complete the method for checking if every opening bracket has
	 * a matching closing bracket
	 */
	public static boolean doBracketsMatch(String b) {
		Stack<Character> brack = new Stack<Character>();
		System.out.println(" ");

		for (int i = 0; i < b.length(); i++) {

			if (b.charAt(i) == '{') {
				System.out.println("Pushing :" + b.charAt(i));
				brack.push(b.charAt(i));
			}

			else if (b.charAt(i) == '}') {
				System.out.println("Popping");
				if (!brack.isEmpty()) {
					brack.pop();
				} else {
					return false;
				}
			}

		}
		
		
		if (brack.isEmpty()) {
			return true;
		}

		return false;

	}
}