public class wildcard_API
{
	public static void main(String args[])
	{
		System.out.println("Hello World");
	}

	//public API
	public class Stack<E>
	{
		public Stack();
		public void push(E e);
		public E pop();
		public boolean isEmpty();
	}

	//pushAll method w/o wildcard type - deficient
	public void pushAll(Iterable<E> src)
	{
		for(E e : src)
		{
			push(e);
		}
	}
	//causes problems, compiles if the Iterable src exactly matches that of the stack
	//Stack<Number> won't work
	//use wildcard type
	
	//Wildcard type for parameter that serves as an E producer
	//bounded wildcard type helps with situations like this
	public void pushAll(Iterable<? extends E> src)
	{
		for(E e: src)
		{
			push(e);
		}
	}
	//^type safe
	

	//popAll method w/o wildcard type - deficient
	public void popAll(Collection<E> dst)
	{
		while(!isEmpty())
		{
			dst.add(pop());
		}
	}

	//adding Stack<number> and variable type Object breaks code
	Stack<Number> numberStack = new Stack<Number>();
	Collection<Object> objects = ...;
	numberStack.popAll(objects);

	//wildcard type for parameter that serves as an E consumer
	public void popAll(Collection<? super E> dst)
	{
		while(!isEmpty())
		{
			dst.add(pop());
		}
	}

	/*
	 	For maximum flexibility, use wildcard types
		on input parameters that represents producers or consumers

		PECS stands for
			Producer-extends, consumer-super

		don't use wildcard types as return types

		if the user of a class has to think about wildcard types
		there is something wrong the the class's API

		if a type parameter appears only once in a method declaration
		replace it with a wildcard
	 */
}
