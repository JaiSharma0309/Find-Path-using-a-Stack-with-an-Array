/**
 * @author Jai Sharma
 * @param <T> used as generics, to make the class as general as possible.
 */

public class ArrayStack<T> implements StackADT<T> {
	
	/*
	 *Creating an array of type T
	 */
	private T[ ] array;
	
	/*
	 *Creating a top variable, that represents the top of the stack
	 */
	private int top;
	
	
	/**
	 *Initializing the array with 10 slots and setting top to 9.
	 */
	public ArrayStack() {
		top = 9;
		array = (T[])(new Object[10]);
		
	}
	
	
	/**
	 *Second constructor that initializes the array with N slots and sets the top to N-1.
	 * @param N being used as an alternative the top being 9, further generalizing it.
	 */
	public ArrayStack(int N) {
		top = N -1;
		array = (T[])(new Object[N]);
	}
	
	
	
	/**
	 *Public method that pushes an element onto the stack
	 *@param element of type T, takes in an element to be pushed onto the stack.
	 */
	public void push (T element) {
		if (top == -1) {
			/*
			 * Calling expandCapacity() if stack is full.
			 */
			expandCapacity();
		}
		
		/*
		 * Adding element to the top of the stack
		 */
		array[top] = element;
		top = top - 1;
		
	}
	
	
	
	/**
	 *Public method that pops and returns an element off the top of the stack.
	 *@throws StackException if the stack is empty
	 *@return temp, the element that was popped.
	 */
	public T pop() throws StackException {
		if (isEmpty()) {
			throw new StackException ("Empty stack");
		}
		
		/*
		 * Removes and returns the element from the top of the stack.
		 */
		T temp = array[top + 1];
		array[top + 1] = null;
		top++;
		
		return temp;
		
	}
	
	/**
	 *Public method that returns an element off the top of the stack.
	 *@throws StackException if the stack is empty
	 *@return array[top+1], returns the top element.
	 */
	public T peek() throws StackException {
		if (isEmpty()) {
			throw new StackException ("Empty stack");
		}
		
		return array[top + 1];
		
	}
	
	
	
	/**
	 *Public method that checks to see if the stack is empty or not.
	 *@return true if the stack doesn't contain any elements, false if it does.
	 */
	public boolean isEmpty() {
		if (top == array.length -1) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	/**
	 *Public method that returns the number of elements in the stack.
	 *@return size, which is the number of elements in the stack
	 */
	public int size() {
		int size = 0;
		
		size = array.length - top -1;
		
		return size;
		
		
	}
	
	/**
	 *Public method that returns the size of the array.
	 *@return array.length, which is the number of spaces in the array.
	 */
	public int getLength() {
		return array.length;
		
	}
	

	/**
	 *Public method that returns the top index of the stack.
	 *@return top. which is the top index of the stack.
	 */
	public int getTop() {
		return top;
		
	}
	
	/**
	 *Public method that builds a string that contains each of the stack's elements in order from top to bottom.
	 *@return s, the string that contains the formatted output.
	 */
	public String toString() {
		
		String s = "Stack: ";
		
		if (isEmpty() == true) {
			return ("The stack is empty.");
		}
		
		for (int i = top + 1; i < array.length; i++) {
			s = s + array[i].toString();
			if (i >= array.length - 1) {
				s = s + ".";
			} else {
				s = s + ", ";
			}
		}
		return s;

		
	}
	
	/*
	 *Private method that increases the length of the array holding the stack by 5.
	 */
	private void expandCapacity() {
		T[] largerArray = (T[])(new Object[array.length + 5]);

		for (int index=0; index < array.length; index++) {
			largerArray[index + 5] = array[index];
		}
		
		top = top + 5;

		array = largerArray;
	}
	
	

	
	

}
