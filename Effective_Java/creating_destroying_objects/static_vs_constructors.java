class static_vs_constructors
{
        public static Boolean valueOf(boolean b)
        {
                return b ? Boolean.TRUE : Boolean.FALSE;
        }

        public static void main(String[] args)
        {
		boolean check = false;
		System.out.println(valueOf(check));
        }
}

//reasons to use static factory methods instead of constructors
/*
 * static factory methods have names where contstructors don't
 
 * static factory methods don't require to create a new object each time they're invoked
 
 * They can return an object of any subtype of their return type
 
 * They can reduce verbosity of creating parameterized type instances
 * ex
 * 	
 * 	Map<String, List<String>> m = new HashMap<String, List<String>>(); too wordy
 *
 * 	compilier can figure out the type parameters for you; aka type inference
 *
 * 	public static <K, V> HashMap<K, V> newInstance()
 * 	{
 * 		return new HashMap<K, V>();
 * 	}
 *
 *
 * 	The main disadvantage of providing only static factory methods is that
 * 	classes w/o public or protected constructors cannot be subclassed
 *
 * 	Another disadvantage of static factory methods is that they are not readily
 * 	distinguishable from other static methods
 */
