/*
 * File: EmptyStackException.java
 * Goal: Exception Class used to represent an Empty Stack Exception extends from RuntimeException
 * */


public class EmptyStackException extends RuntimeException
{

	//Default Constructor
	public EmptyStackException()
	{
		this("EmptyStackException"); //Using the Initializor Constructor 
	}

	//Initializor Constructor 
	public EmptyStackException(String msg)
	{
		super(msg);
	}
}
