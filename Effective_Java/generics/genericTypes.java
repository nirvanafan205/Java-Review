public class genericTypes
{
	public static void main(String args[])
	{
		System.out.println("Hello World");

		Stack<String> stack = new Stack<String>();

		for(String arg : args)
		{
			stack.push(arg);
		}

		while(!stack.isEmpty())
		{
			System.out.println(stack.pop().toUpperCase());
		}
	}

	//Object-based collection - a prime canidate for generics

	public class Stack
	{
		private Object[] elements;
		private int size = 0;
		private static final int DEAFULT_INITIAL_CAPACITY = 16;

		public Stack()
		{
			elements = new Object[DEFAULT_INITIAL_CAPACITY];
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
			elements[size] = null; //eliminate obsolete reference
			return result;
		}

		public boolean isEmpty()
		{
			return size == 0;
		}

		private void ensureCapacity()
		{
			if(elements.length == size)
			{
				elements = Arrays.copOf(elements, 2 * size + 1);
			}
		}
	}
	//above is canidate for genericication
	//needs to cast objects that are popped off the stack and casts might fail at runtime

	//first step to generifying a class is to add one or more parameters to its declaration
	//in this case, it'd be the element type of the stack with parameter E

	//Initial attempt to generify Stack - won't compile

	public class Stack<E>
	{
		private E[] elements;
		private int size = 0;
		private static final int DEFAULT_INITIAL_CAPACITY = 16;

		public Stack() 
		{
			elements = new E[DEFAULT_INITIAL_CAPACITY];
		}

		public void push(E e)
		{
			ensureCapacity();
			elements[size++] = e;
		}

		public E pop()
		{
			if(size == 0)
			{
				throw new EmptyStackException();
			}

			E result = elements[--size];
			elements[size] = null; //Eliminate obsolete reference
			return result;
		}
	}
}
