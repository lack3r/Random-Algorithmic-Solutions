/**
 * @author Andreas Loizou
 * Date: 26 Aug 2015
 * Purpose: This program solves the problem shown below
 * Please note that this was written in a few minutes just to quickly solve the given problem.
 * It is *not optimised* and it can *not* be used as a showcase for the way I code.
 */

/*
 * PROBLEM DESCRIPTION taken from https://www.interviewcake.com/question/reverse-words
 * ------------------
 * You're working on a secret team solving coded transmissions.
Your team is scrambling to decipher a recent message, worried it's a plot to break into a major European National Cake Vault. The message has been mostly deciphered, but all the words are backwards! Your colleagues have handed off the last step to you.

Write a function reverse_words() that takes a string message and reverses the order of the words in place.
 * 
 * For example:

  message = 'find you will pain only go you recordings security the into if'

reverse_words(message)
# returns: 'if into the security recordings you go only pain will you find'

 * */

class ReverseWords {

	
	/*Reverse Words*/
	public String reverse_words(String str) {
		String[] wordList=str.split(" "); //Create a table containing all the words
		String returnString=""; //The string that will be returned
		for (int i=wordList.length-1;i>1;i--){ //Start from the end of the string array
			returnString+=wordList[i]; //And add word by word to the returnString
			returnString+=" ";
		}
		//Last Word
		if (wordList.length>1){
			returnString+=wordList[0];
		}
		return returnString;
	}

	public static void main(String[] args) {
		ReverseWords solution = new ReverseWords();
		
		String message = new String ("find you will pain only go you recordings security the into if");
		System.out.println(solution.reverse_words(message));
	}
}
