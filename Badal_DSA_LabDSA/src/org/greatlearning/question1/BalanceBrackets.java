package org.greatlearning.question1;

import java.util.Scanner;
import java.util.Stack;

public class BalanceBrackets {
	public static boolean isStringBalanced(String bracktExpression) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < bracktExpression.length(); i++) {
			char ch = bracktExpression.charAt(i);
			if (ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
				continue;
			}
			if (stack.isEmpty()) {
				return false;
			}
			char c;
			switch (ch) {
			case '}':
				c = stack.pop();
				if (c == '(' || c == '[')
					return false;
				break;
			case ')':
				c = stack.pop();
				if (c == '{' || c == '[')
					return false;
				break;
			case ']':
				c = stack.pop();
				if (c == '(' || c == '{')
					return false;
				break;
			default:
				break;
			}

		}
		return (stack.isEmpty());
	}

	public static void main(String s[]) {

		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("Enter the Input");

			// input should be ([[{}]]) & ([[{}]]))

			String expr = sc.nextLine();

			boolean res = isStringBalanced(expr);
			if (res) {
				System.out.println("The entered String has Balanced Brackets");
			} else {
				System.out.println("The entered Strings do not contain Balanced Brackets");
			}
		}
	}
}
