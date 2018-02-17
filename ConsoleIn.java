/*
*Application Name: ConsoleIn.java
*Author: Galatcha, Mitch Ainslie
*Date: May 8, 2017
*Schedule: 10:30 - 12:00 MTH
*/
import java.io.*;
import java.util.*;
public class ConsoleIn{
/**
Put appropriate comments here
*/
	public static String readln(){
		char nextChar;
		String result = "";
		boolean done = false;
		while (!done){
			nextChar = readChar();
			if (nextChar == '\n')
				done = true;
			else if (nextChar == '\r'){
			//nothing to do.
			} else
				result = result + nextChar;
		}
		return result;
	}
	/**
	Put appropriate comments here
	*/
	public static String readlnWord() {
		String inputString = null, result = null;
		boolean done = false;
		while(!done){
			inputString = readln();
			StringTokenizer wordSource =
			new StringTokenizer(inputString);
			if (wordSource.hasMoreTokens()) {
				result = wordSource.nextToken();
				done = true;
			} else {
				System.out.println(
				"Your input is not correct.");
				System.out.println("Please enter input:");
			}
		}
		return result;
	}

	/**
	Put appropriate comments here
	*/
	public static int readlnInt() {
		String inputString = null;
		int number = -9999; //a garbage value.
		boolean done = false;

		while (!done) {
			try {
				inputString = readln();
				inputString = inputString.trim();
				number = (Integer.valueOf(inputString).intValue());
			done = true;
			} catch (NumberFormatException e) {
				System.out.println("Your input number is incorrect.");
				System.out.println("Please enter a whole number:");
			}
		}
		return number;
	}

	/**
	Put appropriate comments here
	*/
	public static long readlnLong() {
		String inputString = null;
		long number = -9999; // initial value : garbage
		boolean done = false;
		while (!done) {
			try {
				inputString = readln();
				inputString = inputString.trim();
				number = (Long.valueOf(inputString).longValue());
				done = true;
			} catch (NumberFormatException e) {
				System.out.println("Your input number is incorrect.");
				System.out.println("Please enter a whole number:");
			}
		}
		return number;
	}

	/**
	Put appropriate comments here
	*/

	public static double readlnDouble() {
		String inputString = null;
		double number = -9999; //a garbage value.
		boolean done = false;
		while (!done) {
			try {
				inputString = readln();
				inputString = inputString.trim();
				number = (Double.valueOf(inputString).doubleValue());
			done = true;
			} catch (NumberFormatException e) {
				System.out.println("Your input number is not correct.");
				System.out.println("Please enter a whole number:");
			}
		}
		return number;
	}
	/**
	Put appropriate comments here
	*/

	public static float readlnFloat() {
		String inputString = null;
		float number = -9999; // initial value : garbage
		boolean done = false;

		while (!done) {
			try {
				inputString = readln();
				inputString = inputString.trim();
				number = (Float.valueOf(inputString).floatValue());
				done = true;
			} catch (NumberFormatException e) {
				System.out.println("Your input number is not correct.");
				System.out.println("Please enter a whole number:");
			}
		}
		return number;
	}

	/**
	Put appropriate comments here
	*/
	public static char readlnNonwhiteChar() {
		boolean done = false;
		String inputString = null;
		char nonWhite = ' '; //initial value : garbage
		while (!done) {
			inputString = readln();
			inputString = inputString.trim();
			if (inputString.length() == 0) {
				System.out.println("Your input is not correct.");
				System.out.println("Please enter at least one nonwhitespace character:");
			} else {
				nonWhite = (inputString.charAt(0));
				done = true;
			}
		}
		return nonWhite;
	}
	/**
	Put appropriate comments here
	*/
	public static boolean readlnBoolean() {
		boolean done = false;
		String inputString = null;
		boolean result = false; //initial value : garbage
		while (!done) {
			inputString = readln();
			inputString = inputString.trim();
			if (inputString.equalsIgnoreCase("true") || inputString.equalsIgnoreCase("t")) {
				result = true;
				done = true;
			} else if (inputString.equalsIgnoreCase("false") || inputString.equalsIgnoreCase("f")) {
				result = false;
				done = true;
			} else {
				System.out.println("Your input number is not correct.");
				System.out.println("Please, try again.");
			}
		}
		return result;
	}
	/**
	Put appropriate comments here
	*/
	public static char readChar() {
		int charAsInt = -1; //initial value : garbage
		try {
			charAsInt = System.in.read();
		} catch(IOException e) {
			System.out.println(e.getMessage());
			System.out.println("Fatal error. Ending Program.");
			System.exit(0);
		}
		return (char)charAsInt;
	}
}