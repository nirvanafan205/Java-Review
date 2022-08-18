public class strings
{
	public static void main(String[] args)
	{
		System.out.println("Hello World");
	}
	//strings are poor substitutes for other value types
	//strings are poor substitutes for enum types
	//strings are poor substitutes for aggregate types
	
	//inappropriate use of string as aggregate type
	String compoundKey = className + "#" + i.next();
	//strings are poor substitutes for capabilities
	

	//Broken - inappropriate use of string as capability
	public class ThreadLocal
	{
		private ThreadLocal() { } //noninstantiable

		//set the current thread's value for the named variable
		public static void set(String key, Object value);

		//Returns the current thread's value for the named variable
		public static Object get(String key);
	}

	//fixed by replacing string with an unforgeable key (capability)
	public class ThreadLocal
	{
		private ThreadLocal() { }

		public static class Key  //capability
		{
			Key() { }
		}

		//generates a unique, unforgeable key

		public static Key getKey()
		{
			return new Key();
		}
		
		public static void set(Key key, Object value);
		public static Object get(Key key);
	}
}
