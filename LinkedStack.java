/*
 * Developer: Jose Ceballos
 * File: LinkedStack.java
 * Goal: To Implement a generic stack data structure using a singularly linked list under the hood
 * */


//Generic Stack Data Structure 
public class LinkedStack<T> implements StackInterface<T>
{

	private int qtyOfItems; //Keeps track of the amount of elements in LinkedStack

	private Node topPointer; //Points to the top Element in the LinkedStack


	//Default Constructor 
	public LinkedStack()
	{
		this.qtyOfItems = 0; //Initially Zero Elements in LinkedStack
		this.topPointer = null; //Initially No Elements in LinkedStack
	}

	//Methods Defined in StackInterface
  	/** Adds a new entry to the top of this stack.
            @param newEntry  An object to be added to the stack. */
	public void push(T newEntry)
	{
		//Creating a newNode to store the Entry data in 
		Node newNode = new Node(newEntry, null); 
		

		//Checking if its the first element in the LinkedStack
		if(this.isEmpty())
		{
			//First Element in LinkedStack
			this.topPointer = newNode; //Linking the newNode to the LinkedStack
		}
		else
		{
			//Linking the newNode to the LinkedStack
			newNode.prev = this.topPointer; //Adding the Node to the top of the LinkedStack 
			this.topPointer = newNode; //Updating the topPointer to the top Node in the LinkedStack
		}
		
		this.qtyOfItems++; //Increasing the Size of Items in the LinkedStack
	}
   	
	/** Removes and returns this stack's top entry.
       	    @return  The object at the top of the stack.
            @throws  EmptyStackException if the stack is empty before the operation. */
	public T pop()
	{
		if(this.isEmpty())
		{
			throw new EmptyStackException(); //Throwing Custom Exception 
		}
		T returnedData = this.topPointer.data; //Saving the data in the top Node

		Node prevNode = this.topPointer.prev; //Saving the Previous Nodes Position

		//Cutting Ties with the Removed Node 
		this.topPointer.prev = null; 
		this.topPointer.data = null; 
		
		this.topPointer = prevNode; //Updating the top Node in the LinkedStack

		this.qtyOfItems--; //Updating the Size of the qtyOfItems
		
		return returnedData; //Returning the removed Nodes Data 
	}
   	
	/** Retrieves this stack's top entry.
            @return  The object at the top of the stack.
            @throws  EmptyStackException if the stack is empty. */
	public T peek()
	{
		if(this.isEmpty())
		{
			throw new EmptyStackException(); //Throwing an Exception if the LinkedStack is Empty 
		}
		
		return this.topPointer.data; //Returning the Data of the Top Element in Stack
	}
   	
	/** Detects whether this stack is empty.
            @return  True if the stack is empty. */
	public boolean isEmpty()
	{
		return this.qtyOfItems == 0; //If there are Zero Items Return true Else return false
	}
   	
	/** Removes all entries from this stack. */
	public void clear()
	{
		//While its Not Empty 
		while(!this.isEmpty())
		{
			this.pop(); //Pop the Elements 
		}
	}

	/** @Overrides toString() method from Object
	    @return A String of all the Elements */
	public String toString()
	{
		String holder = "[";
		String comma = " ";
		Node tempNodePointer = this.topPointer; //Used to iterate through the LinkedStack

		while(tempNodePointer != null)
		{
			holder += comma +  tempNodePointer.data;
			comma = " , ";
			tempNodePointer = tempNodePointer.prev; //Go to the Previous Element in Stack 
		}

		holder += " ]";
		return holder; 
	}


	//Private Class 
	private class Node
	{
		T data; //Data Stored in Node
		Node prev; //Node Pointer that points to the previous Node in the LinkedStack

		//Default Constructor
		public Node()
		{
			this(null,null); //Using Initializor Constructor 
		}

		//Initializor Constructor
		public Node(T data, Node prev)
		{
			this.data = data;
			this.prev = prev;
		}
	}
}
