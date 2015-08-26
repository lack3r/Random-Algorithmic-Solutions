/**
 * @author Andreas Loizou
 * Date: 26 Aug 2015
 * Purpose: This program solves the problem shown below
 * Please note that this was written in a few minutes just to quickly solve the given problem.
 * It is *not optimised* and it can *not* be used as a showcase for the way I code.
 */

/*
 * PROBLEM DESCRIPTION taken from https://www.interviewcake.com/question/bracket-validator
 * ------------------
 * You're working with an intern that keeps coming to you with JavaScript code that won't run because the braces, brackets, and parentheses are off. To save you both some time, you decide to write a braces/brackets/parentheses validator.
Let's say:

'(', '{', '[' are called "openers."
')', '}', ']' are called "closers."
Write an efficient function that tells us whether or not an input string's openers and closers are properly nested.

Examples:

"{ [ ] ( ) }" should return True
"{ [ ( ] ) }" should return False
"{ [ }" should return False
 * 
 * 
 * */

/*
 * My solution uses a stack in which all left brackets are pushed
 * When we find a right bracket, 
 * 		if the stack is empty, that means we have found a right bracket without its corresponding left - FALSE
 * 		if the bracket just found, does not match the top bracket in the stack - FALSE
 * When we finished parsing
 * 		if the stack is empty then all brackets were matched correctly - TRUE
 * 		if the stack is not empty then we found more left brackets - FALSE
 * 
 * As I wanted to come up with a solution really fast, I used java's stack
 * However, I could also use an array instead of a stack, or even create my stack based on an ArrayList
 * That would be even faster solution and less memory consuming.
 * 
 * */

import java.util.Stack;

class BracketsSolution {

	/*Give the pair of a left bracket*/
	private char getPair(char x) {
		if (x == ')')
			return '(';
		if (x == ']')
			return '[';
		if (x == '}')
			return '{';
		throw new IllegalArgumentException();
	}

	/*Verify whether all brackets match*/
	public boolean verify(String str) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			
			if (str.charAt(i) == '{' | str.charAt(i) == '[' | str.charAt(i) == '(') {
				stack.push(str.charAt(i));
			} else if (str.charAt(i) == '}' | str.charAt(i) == ']' | str.charAt(i) == ')') {
				if (stack.size() == 0) {
					return false;
				}
				char previousBracket = stack.pop();
				if (previousBracket != getPair(str.charAt(i))) {
					return false;
				}
			}

		}
		if (stack.size() == 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		BracketsSolution solution = new BracketsSolution();
		System.out.println(solution.verify("{ [ ] ( ) }"));
		System.out.println(solution.verify("{ [ ( ] ) }"));
		System.out.println(solution.verify("{ [ }"));

	}
}
