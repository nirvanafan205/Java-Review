public class rawTypes
{
	//a class or interface whose declaration has one or more type parameters is a generic class or interface
	//generic classes and interfaces are known as generic types, it defines a set of parameterized types

	public static void main(String args[])
	{
		System.out.println("Hello World");


		//Use raw type (LIst) fails at runtime
		List<string strings = new ArrayList<String>();
		unsafeAdd(Strings, new Integer(42));
		String s = strings.get(0); // compiler-generated cast
	}

	private static void unsafeAdd(List list, Object o)
	{
		list.add(o);
	}

	//use of raw type for unknonw element type - don't do this
	static int numElementsInCommon(Set s1, Set s2)
	{
		int result = 0;

		for(Object o1 : s1)
		{
			if(s2.contains(o1))
			{
				result++;
			}

			return result;
		}
	}

	//unbounded wildcard type - typesafe and flexible; use ?
	static int numElementsInCommon(Set<?> s1, Set<?> s2) //wildcard type is safe, raw type isnt
	{
		int result = 0;

		for(Object o1 : s1)
		{
			if(s2.contains(o1))
			{
				result++;
			}

			return result;
		}
	}
	//you can't put any element (other than nulL) into a Collection<?>

	//raw collection type, don't do this
	private final Collection stamps = ...;

	//parameterized collection type - typesafe
	private final Collection<Stamp> stamps = ...;

	//Bad insertion of coint into stamp collection
	stamps.add(new Coin(...));

	//error from retrieving the coin from the stamp collection
	//dont use raw iterator type
	for(Iterator i = stamps.iterator(); i.hasNext(); )
	{
		Stamp s = (Stamp) i.next(); //throws ClassCastException
	}

	//use for-each loop over a parametrized collection - typeSafe
	for(Stamp s : stamps)
	{

	}

	//or a traditional for loop
	for(Iterator<Stamp> i = stamps.iterator(); i.hasNext(); )
	{
		Stamp s = i.next(); //no cast necessary
	}

	//if you use raw types, you lose all the safety and expressiveness benefits of generics
	//you lose type safety if you use a raw type like List
	//but not if you use parameterized type like List<Object>
	
	//Legitimate use of raw type - instanceof operator
	if(o instanceof Set) //raw type
	{
		Set<?> m = (Set<?>) o; //wildcard type
	}
}
