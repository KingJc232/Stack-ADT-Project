/*
 * Developer: Jose Ceballos
 * File: Main.java
 * Goal: Showcase the Stack Data Structure 
 * */



//NO MAX_SIZE NEEDED
//Need to throw custom exceptions that extend from RuntimeException

public class Main
{
	public static void main(String[] args)
	{
		//LinkedStack<Character> stack = new LinkedStack<>(); //Creating a LinkedStack Data Structure 
		ArrayStack<Character> stack = new ArrayStack<>();

		ExpressionConverterInterface test = new InfixToPostfixConverter(stack);

		System.out.println(test.convert("A+B- C * D^E + (F /G /H)")); //Testing a Simple Example 

		System.out.println("Stack: " + stack);		
		
	}	




}
