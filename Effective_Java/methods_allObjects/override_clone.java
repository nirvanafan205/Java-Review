public class override_clone
{
	public static void main(String args[])
	{
		System.out.println("Hello World");
	}

	public class Stack
	{
		private Object[] elements;
		private int size = 0;
		private static final int DEAFULT_INITIAL_CAPACITY = 16;

		public Stack()
		{
			this.elements = new Object[DEAFULT_INITIAL_CAPACITY];
		}

		public void push(Object e)
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

			Object result = elements[--size];
			elements[size] = null;
			return result;
		}

		private void ensureCapacity()
		{
			if(elements.length == size)
			{
				elements = Arrays.copyOf(elements, 2 * size + 1);
			}
		}
	}

	//how to make the class cloneable

	/*
	   clone method acts as another constructor
	   make sure it doesn't harm original object
	   and that it makes invariants on the clone

	   clones wont work if the elements field were final
	   clones prohibit from assignming a new value to the field

	   the clone architecture is incompatible with normal use of final field reffering to mutable objects
	   */

	@Override public Stack clone()
	{
		try
		{
			Stack result = (Stack) super.clone();
			result.elements = elements.clone();
			return result;
		} catch(CloneNotSupportedException e)
		{
			throw new AssertionError();
		}

	}

	//it's not always sufficient to call clone recursively
	public class HashTable implements Cloneable
	{
		private Entry[] buckets = ...;

		private static class Entry
		{
			final Object key;
			Object value;
			Entry next;

			Entry(Object key, Object value, Entry next)
			{
				this.key = key;
				this.value = value;
				this.next = next;
			}
		}

		//clone the bucket array recursively brackes it
		//results in shared internal state
		@Override public HashTable clone()
		{
			try {
				HashTable result = (HashTable) super.clone();
				result.buckets = buckets.clone();
				return result;
			} catch (CloneNotSupportedException e) {
				throw new AssertionError();
			}

			/*
			   Clone has its own bucket array
			   this array references the same linked lists as the original
			   makes nondeterministic behavore in clone and original
			   to fix, copy linked list with each bucket individually
			   */
		}

		public class HashTable implements Cloneable
		{
			private Entry[] buckets = ...;

			private static class Entry
			{
				final Object key;
				Object value;
				Entry next;

				Entry(Object key, Object value, Entry next)
				{
					this.key = key;
					this.value = value;
					this.next = next
				}

				//recursively copy the linked list headed by this Entry
				//if list is long, this could easily cause a stack overflow
				Entry deepCopy()
				{
					return new Entry(key, value, next == null ? null : next.deepCopy());
				}

				//to prevent stack overflow
				//replace recursion in deepCopy
				//Iteratively copy the linked list headed
				Entry deepCopy()
				{
					Entry result = new Entry(key, value, next);

					for(Entry p = result; p.next != null; p = p.next)
					{
						p.next = new Entry(p.next.key, p.next.value, p.next.next);
					}

					return result;
				}
			}

			@Override public HashTable clone()
			{
				try {
					HashTable result = (HashTable) super.clone();
					result.buckets = new Entry[buckets.length];
					for(int i = 0; i < buckets.length; i++)
					{
						if(buckets[i] != null)
						{
							result.buckets[i] = buckets[i].deepCopy();
						}
					} 

					return result;
				} catch (CloneNotSupportedException e) {
					throw new AsxsertionError();
				}
			}
		}

	}

	//you are better off providing an alternative means of object copying
	//or simply not providing the capability
	//a fine approach to object copying is to provide a copy constructor or copy factory
	
	public Wombocombo(Wombocombo wombo);

	//copy factory is the static factory analog of a copy constructor
	public static Wombocombo newInstance(Wombocombo combo);
}

/*
   If you override the clone method in a nonfinal class,
   you should return an object by invoking super.clone

   A class that implements Clonable is expected to provide
   a properly functioning public clone method

   Never make the client do anything the library can do for the client
*/
