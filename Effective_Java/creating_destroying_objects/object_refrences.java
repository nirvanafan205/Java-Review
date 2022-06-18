public class object_refrences
{
	private Object[] elements;
	private int size = 0;
	private static final int DEAFULT_INITIAL_CAPACITY = 16;
	
	public Stack()
	{
		elements = new Object[DEAFULT_INITIAL_CAPACITY];
	}

	public void push(OBject e)
	{
		ensureCapacity();
		elements[size++] = e;
	}

	public Object pop()
	{
		if(size == 0)
		{
			throw new EmptyStackException();
		}

		return elements[--size]; //memory leak due to obsolete reference. aka reference that'll never be dereferenced again
	}

	//corrected version
	public Object pop()
	{
		if(size == 0)
		{
			throw new EmptyStackException();
		}

		Object result = elements[--size];
		elements[size] = null // eliminates obsolete reference
		return result;

		//nulling out object references hsould be the exception rather than the norm
	}

	private void ensureCapacity()
	{
		if(elements.length == size)
		{
			elements  = Arrays.copOf(elements, 2 * size + 1);
		}
	}
}

/*
 	Whenever a class manages its own memory, the programmer shoudl be alert for memory leaks
		whenever an element is freed, object refrences contained in the element should be nulled out

	another common source of memory leaks is caches
		object reference in caches could be forgotten, so be careful

	a third source of memory leaks is listeners and other callbacks
		callbacks that aren't deregister explicity will accumulate unless action is taken
 */
