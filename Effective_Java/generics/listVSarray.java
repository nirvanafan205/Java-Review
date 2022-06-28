public listVSarray.java
{
	public static void main(String args[])
	{
		System.out.println("Hello World");

		//generic array creation is illegal - won't compile
		List<String>[] stringLists = new List<String>[1];
		List<Integer> intList = Arrays.asList(42);
		Object[] objects = stringLists;
		objects[0] = intList;
		String s = stringLists[0].get(0);
	}

	//Reduction w/o generics, and with concurrency flaw
	static Object reduce(List list, Function f, Object initVal)
	{
		synchronized(list)
		{
			Object result = intVal;

			for(Object o : list)
			{
				result = f.apply(result, o);
			}

			return result;
		}
	}

	interface Function
	{
		Object apply(Object arg1, Object arg2);
	}

	//reduction w/o generics or concurrency flaw
	static Object reduce(List list, Function f, Object initVal)
	{
		Object[] snapshot = list.toArray(); // locks list internally
		Object resul = initVal;

		for(Object o : snapshot)
		{
			result = f.apply(result, o);
		}

		return result;
	}
	
	//with generics, causes problems
	interface Function<T>
	{
		T apply(T arg1, T arg2);
	}


	//naive generic version of reduction - wont compile
	
	static <E> E reduce(List<E> list, Function<E> f, E initVal)
	{
		E[] snapshot = list.toArray(); // locks list
		E result = initVal;

		for(E e : snapshot)
		{
			result = f.apply(result, e);
		}

		return result;
	}

	//gives compile error ^^^^
	//List-based generic reduction
	static <E> E reduce(List<E> list, Function<E> f, E initVal)
	{
		List<E> snapshot;

		synchronized(list)
		{
			snapshot = new ArrayList<E>(list);
		}

		E result = initVal;

		for(E e : snapshot)
		{
			result = f.apply(result, e);
		}
		return result;
	}

	/*
		arrays are covariant and reified
		generics are invariant and erased
		arrays provide runtime type safety and vice versa for generics
	 */
}
