public class overloading
{
	public static void main(String[] args)
	{
		System.out.println("Hello World");
	}

	//broken - only prints last function "Unknown Collection"
	public class CollectionClassifier
	{
		public static String classify(Set<?> s)
		{
			return "Set";
		}

		public static String classify(List<?> lst)
		{
			return "List";
		}

		public static String classify(Collection<?> c)
		{
			return "Unknown Collection"
		}

		public static void main(String[] args)
		{
			Collection<?>[] collections =
			{
				new HashSet<String>(),
				new ArrayList<BigInteger>(),
				new HashMap<String, String>().values()
			};

			for(Collection<?> c : collections)
			{
				System.out.println(classify(c)); // prints "Unknown Collection" three times
			}
		}

		/*
		 	the choice of which overloading to invoke is made at compile time

			selection among overloaded methods is static,
			while selection among overridden methods is dynamic
		*/

		/*
		 	method is overridden when a subclass contains a method declaration with the same signature as a method declaration in an ancestor
			overridding method executes, regardless of the compiletime type of the sublcass instance
		*/

		class wine
		{
			String name() { return "wine"; }
		}

		class SparklingWine extends Wine 
		{
			@Override String name() { return "sparkling wine"; }
		}

		class Champagne extends SparklingWine 
		{
			@Override String name() { return "champagne"; }
		}

		public class Overriding
		{
			public stastic void main(String[] args)
			{
				Wine[] wines = 
				{
					new Wine(), new  SparklingWine(), new Champagne()
				};

				for(Wine wine: wines)
				{
					System.out.println(wine.name()); //prints out wine, sparkling wine, and champagne
				}
			}
		}

		//best way to fix first function to replace all overloadins of classify
		//is with a single method that does an explicit instanceof test
		public static String classify(Collection<?> c)
		{
			return c instance of Set ? "Set" :
				c instanceof List ? "List" : "Unknown Collection";
		}
		//avoid confusing uses of overloading
		//a safe, conserative policy is never to export two overloadins with same number of parameters
	}
}
