public class generic_methods
{
	public static void main(String args[])
	{
		System.out.println("Hello World");

		//Simple program to exercise generic method
		Set<String> guys = new HashSet<String>(Arrays.asList("Tom", "Dick", "Harry"));

		Set<String> stooges = new HashSet<String>(Arrays.asList("Larry", "Moe", "Curly"));

		Set<String> aflCio = union(guys, stooges);

		System.out.println(aflCio);

		//both arguements to union are type Set<String>
		//This is known ass type inference
		

		//Sample program to exercise generic singleton

		String[] string = { "jute", "hemp", "nylon" };

		UnaryFunction<String> sameString = identityFunction();

		for(String s : strins)
		{
			System.out.println(sameString.apply(s));
		}

		Number[] numbers = { 1, 2.0, 3L };

		UnaryFunction<Number> sameNumber = identityFunction();

		for(Number n : numbers)
		{
			System.out.println(sameNumber.apply(n));
		}


	}
		//recursive type bounds; retunrs maximum value in a list

		public static <T extends Comparable<T>> T max(List<T> list)
		{
			Iterator<t> i = list.iterator();
			T result = i.next();

			while(i.hasNext())
			{
				T t = i.next();
				
				if(t.compareTo(result) > 0)
				{
					result = t;
				}
			}
			
			return result;
		}

	//Uses raw types - unacceptable!
	public static Set union(Set s1, Set s2)
	{
		Set result = new HashSet(s1);
		result.addAll(s2);
		return result;
	}

	//generic method
	public static <E> Set<E> union(Set<E> s1, Set<E> s2)
	{
		Set<E> result = new HashSet<E>(s1);
		result.addAll(s2);
		return result;
	}

	//gives warnings, not typesafe
	//fix method declaration to declare a type parameter representing the element type for the three sets
	//use the parameter in the method
	
	//The type parameter list, which declase the tyep parameter
	//goes between the method's modifiers and its return type
}
