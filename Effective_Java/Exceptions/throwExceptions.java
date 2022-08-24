public class throwExceptions
{
	public static void main(String[] args)
	{
		//higher layers should catch lower-level excepitions 
		//and in their place throw exceptions that can be explained in terms of higher level abstraction
		//aka exception translation

		//exception translation
		try
		{
			//use lower lvl abstraction to do our bidding
		} catch(LowerLevelException e) {
			throw new HigherLevelException(...)
		}


		/*
		 	Returns the element at the specified position in this list
			@throws IndexOutOfBoundsException if the index is out of range
			({@code index < 0 || index >= size()})
		 */
		public E get(int index)
		{
			ListIterator<E> i = listIterator(index);
			try {
				return i.next();
			} catch(NoSuchElementException e) { 
				throw new IndexOutOfBoundsExceptino("Index: " + index);
			}
		}


		//exception chaining
		try {
			//use lower lvl abstraction to do our bidding
		} catch (LowerLevelException cause) {
			throw new NigherLevelException(cause);
		}

		//Exception with chaining-aware constructor
		class HigherLevelException extends Exception 
		{
			HihgerLevelException(Throwable cause)
			{
				super(cause);
			}
		}
		//while exception translation is superior to mindless propagation of exceptions from lower layers
		//it should not be overused
	}
}
