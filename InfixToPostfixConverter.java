/*
 * Developer: Jose Ceballos
 * File: InfixToPostfixConverter.java
 * Goal: Converts a StackInterface Object from infix to postfix And Implements the interface 
 * 	 ExpressionConverterInterface
 * */



public class InfixToPostfixConverter implements ExpressionConverterInterface
{
	//Valid Operators to Test (Private Data Field	
	private static final char[] OPERATORS = {'+', '-', '*', '/'};

	//Private data field 
	private StackInterface<Character> stack;

	//Default Constructor 
	public InfixToPostfixConverter()
	{
		this(new LinkedStack<Character>()); //Initializing the default data field to a LinkedStack<>()
	}

	//Initializer Constructor
	public InfixToPostfixConverter(StackInterface<Character> stack)
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
			if(this.isOperand(expression.charAt(i)))
				output += expression.charAt(i); //If Its an Operand Append it to the output String
			else if(expression.charAt(i) == '^')
				this.stack.push(expression.charAt(i)); //Else if Its the ^ operator push it onto the stack  
			else if(isOperator(expression.charAt(i)))
				output += processOperator(expression.charAt(i)); //Appending the popped operators from stack to the output String 
			else if(expression.charAt(i) == '(')
				this.stack.push(expression.charAt(i)); //Else if its the ( operator push it onto the stack
			else if(expression.charAt(i) == ')')
				output += processClosingParenthesis(expression.charAt(i)); //Appending the popped operators from stack due to Parenthesis 	
			else if(expression.charAt(i) == ' ')
				continue; //If its a white space continue 
			else
				throw new InvalidExpressionException(); //Unknown Term 
		}
		
		while(this.stack.isEmpty() == false)
		{
			if(this.stack.peek() == '(')
				throw new InvalidExpressionException(); //Invalid Input 
			else
				output += this.stack.pop(); //Getting the left over operators from the stack 
		}
		
		return output;
	}
	
	/** Helper Method Assumes operatorToProcess is the Closing Parenthesis Operator and Pops the operators from the stack 
		@param char operatorToProcess character to test
		@return A String Containing all the processed operators
		@throws InvalidExpressionException */
	private String processClosingParenthesis(char operatorToProcess) throws InvalidExpressionException
	{
		String outputExpression = ""; //Holds the Operators popped from the stack 
			
		boolean isOver = false; //Controls the while loop
		while(!isOver)
		{
			if(this.stack.isEmpty())
				throw new InvalidExpressionException(); //Error Could Not Find the '(' operator in the stack 
			
			else if(this.stack.peek() == '(')
			{
				this.stack.pop();//Removing it From the Stack 
				isOver = true; //Delimiter 
			}
			else
			{
				outputExpression += this.stack.pop(); //Popping the operators from the stack 
			}
		}

		return outputExpression; //Returning the Operators popped from the stack 
	}

	/** Helper Method Used to Check if the char provided is an Operand
		@param char toTest character to test 
		@return A boolean true if it is an Operand. Else it returns false*/
	private boolean isOperand(char toTest)
	{
		if((toTest >= 'a' && toTest <= 'z') || (toTest >= 'A' && toTest <= 'Z'))
		{
			return true; //It is an Operand 
		}
		//Else
			return false; //It is not an Operand
	}

	/** Helper Method Assumes operatorToProcess is a Operator then it processes the operators in the stack 
		@param char operatorToProcess character to test
		@return A String containing all the processed operators */
	private String processOperator(char operatorToProcess)
	{
		//Dealing with Operators
		String outputExpression = ""; //Holds the Popped Operators from the stack 
		boolean isOver = false; //Controls the while loop
		while(isOver == false && this.stack.isEmpty() == false)
		{
			//If The precendence level of the operator on the top of the stack has a lower precendence then OperatorToProcess
			if(precendenceLevel(this.stack.peek()) < precendenceLevel(operatorToProcess))
				isOver = true; //End the WhileLoop
			else
				outputExpression += this.stack.pop(); //Popping the operators from the stack 
		}

		this.stack.push(operatorToProcess); //Pushing the processed operator onto the stack 

		return outputExpression; //Returning the operators that got popped from stack  
	}

	/** Helper Method Returns the Precendence Level of an Operator
		@param A char operator
		@return An int representing the Precendence Level of an operator*/
	private int precendenceLevel(char operatorToTest)
	{
		int level = -1; //Initially the level of the operator is Unknown
		switch(operatorToTest)
		{
			case '+':
			case '-':
				level = 1; //assigning the operators +, - a level of 1
				break;
			case '*':
			case '/':
				level = 2; //Assigning the operators *, / a level of 2
				break;
			case '^':
				level = 3; //Assigning the operator ^ a level of 3
				break;
		}
		return level;
	}

	
	/** Helper Method Checks if the character provided is an operator (+,-,*,/) Using OPERATORS private static array
		@param char toTest character to test
		@return if it is an operator return true. Else return false*/
	private boolean isOperator(char toTest)
	{
		boolean isItAnOperator = false; //Initially we assume its not an operator 
		//Testing the char to see if its an operator 
		for(int i = 0; i < this.OPERATORS.length; i++)
		{
			if(toTest == this.OPERATORS[i])
			{
				isItAnOperator = true; //Found the operator
			}
		}
		return isItAnOperator; //Returning the boolean 
	}


}
