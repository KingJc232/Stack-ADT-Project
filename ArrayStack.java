/*
 * Developer: Jose Ceballos
 * File: ArrayStack.java
 * Goal: To implement a generic Stack Data Structure using an Array Under the Hood 
 * */


//Generic Data Structure
public class ArrayStack<T> implements StackInterface<T>
{

	public static final int DEFAULT_SIZE = 50; //Default Size the Array will be

	private int qtyOfItems; //Keeps Track of the Amount of Elements in the ArrayStack
	
	private T[] data; //Stores all the data in the ArrayStack

	//Default Constructor 
	public ArrayStack()
	{
		this(DEFAULT_SIZE); //Initializing the data Using the Initializor Constructor 
	}

	//Initializor Constructor 
	public ArrayStack(int initialSize)
	{
		this.qtyOfItems = 0; //Initially there are No Elements in the ArrayStack
		this.data = (T[]) new Object[initialSize]; //Gather the Specified Memory for the Generic Array 
	}

	//Methods Defined in Stack Interface
  	/** Adds a new entry to the top of this stack.
            @param newEntry  An object to be added to the stack. */
	public void push(T newEntry)
	{
		//Checking if the this.data Generic Array needs more memory 
		if(this.qtyOfItems == this.data.length)
		{
			this.resize(); //Calling a Helped Method To Double the Size of the this.data array
		}
		
		this.data[this.qtyOfItems] = newEntry; //Adding the Entry to the ArrayStack
		this.qtyOfItems++; //Incrementing the Size of the ArrayStack 
	}
   	
	/** Helper Method Doubles the Memory Size of the this.data Array
	    @return void */
	private void resize()
	{
		int doubleMemorySize = this.data.length * 2; //Amount of Memory Needed to Double the Size 
		//Checking if there is no memory in the this.data 
		if(this.data.length == 0)
		{
			doubleMemorySize = 1; //
		}
		
		//Creating a New Generic Array With Double the Memory
		T[] copyArray = (T[]) new Object[doubleMemorySize]; 

		//Copying all the Elements on to the copyArray
		for(int i = 0; i < this.qtyOfItems; i++)
		{
			copyArray[i] = this.data[i]; //Copying Elements 
			this.data[i] = null;//Nulling the Elements So GC cleans them 
		}

		this.data = copyArray; //Doubling the Memory Size of the this.data 
	}


	/** Removes and returns this stack's top entry.
       	    @return  The object at the top of the stack.
            @throws  EmptyStackException if the stack is empty before the operation. */
	public T pop()
	{
		if(this.isEmpty())
		{
			throw new EmptyStackException(); 
		}

		T returnedElement = this.data[this.qtyOfItems -1]; //Saving the Removed Element 

		this.data[--this.qtyOfItems] = null; //PreDecrementing AND Nulling the Removed Element so GC cleans it  

		return returnedElement; //Removed Element Data 
	}
   	
	/** Retrieves this stack's top entry.
            @return  The object at the top of the stack.
            @throws  EmptyStackException if the stack is empty. */
	public T peek()
	{
		if(this.isEmpty())
		{
			throw new EmptyStackException();
		}
		//Else
		return this.data[this.qtyOfItems -1];
	}
   	
	/** Detects whether this stack is empty.
            @return  True if the stack is empty. */
	public boolean isEmpty()
	{
		return this.qtyOfItems == 0; //True if qtyOfItems is 0 Else False
	}
   	
	/** Removes all entries from this stack. */
	public void clear()
	{
		//While its Not Empty 
		while(!this.isEmpty())
		{
			this.pop(); //Pop All the Elements 
		}
	}
	
	/** @Overriding the toString Method from Object 
	    @return a String containing all the elements*/
	public String toString()
	{
		String holder = "[";
		String comma = " ";
		
		//Iterating through all the elements in the Generic Array 
		for(int i = 0; i < this.qtyOfItems; i++)
		{
			holder += comma + this.data[i];
			comma = " , ";
		}
		holder += " ]";
		return holder;
	}
}
