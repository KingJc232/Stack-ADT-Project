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
		LinkedStack<Integer> stack = new LinkedStack<>(); //Creating a LinkedStack Data Structure 
		//ArrayStack<Integer> stack = new ArrayStack<>();
		
		for(int i = 0; i < 10; i++)
		{
			stack.push(i);
		}
		
		System.out.println("Stack: " + stack);

		System.out.println("Peeking: " + stack.peek());
		System.out.println("Peeking: " + stack.peek());
		System.out.println("Peeking: " + stack.peek());
		System.out.println("Peeking: " + stack.peek());
		System.out.println("Peeking: " + stack.peek());
		System.out.println("Stack: " + stack);
		
		System.out.println("Clearing ArrayStack");
		stack.clear();
		System.out.println("Stack: " + stack);	
			
		stack.push(1);
		System.out.println("POPPING: " + stack.pop());
	}
}
