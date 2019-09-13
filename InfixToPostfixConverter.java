/*
 * Developer: Jose Ceballos
 * File: InfixToPostfixConverter.java
 * Goal: Converts a StackInterface Object from infix to postfix And Implements the interface 
 * 	 ExpressionConverterInterface
 * */



public class InfixToPostfixConverter<T> implements ExpressionConverterInterface
{

	private StackInterface<T> stack;

	//Default Constructor 
	public InfixToPostfixConverter()
	{
		this(new LinkedStack<T>()); //Initializing the default data field to a LinkedStack<>()
	}
	//Initializor Constructor
	public InfixToPostfixConverter(StackInterface<T> stack)
	{
		this.stack = stack; //Initializing the this.stack data field object
	}

	/*Methods Defined in ExpressionConverterInterface*/

	/** The convert method converts one type of expression format to another
	* @param expression The expression to be converted
	* @return The expression in the new format
	* @throws InvalidExpressionException If the expression to be converted has syntax errors */
	public String convert(String expression) throws InvalidExpressionException
    	{
		String output = ""; //Stores the outfix notation of the expression
		/*Using Algorithm Provided by Instructor */	
		for(int i = 0; i < expression.length();i++)
		{
			//Checking if a letter in the expression is an Operand
			if((expression.charAt(i) >= 'a' && expression.charAt(i) <= 'z') ||
			   (expression.charAt(i) >= 'A' && expression.charAt(i) <= 'Z'))
			{
				//Its an Operand Therefore add it to the output 
				output += expression.charAt(i);
			}
			//Checking if the term is the ^ operator 
			else if(expression.charAt(i) == '^')
			{
				this.stack.push((T)expression.charAt(i));  //Pushing it onto the stack 
			}

		}
	
		return output;
	}



}
