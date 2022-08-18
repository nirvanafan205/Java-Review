public class interfaceReflection
{
	public static void main(String[] args)
	{
		System.out.println("Hello World");
	}

	/*
		Reflection allows one class to use another, however it comes t a price

		all the benefits of compile time type checking is lost

		code required to perform reflective access is clumsy and verbose

		Performance suffers
			reflective method invocation is slower than normal method invocation

		as a rule, objects should not be accessed reflectively in normal applications at runtime
	*/

	//reflective instantiation with interface access
	public static void main(String[] args)
	{
		//translate the class name into a class object
		Class<?> cl = null;

		try
		{
			cl = Class.forName(args[0]);

		} catch(ClassNotFoundException e) {
			System.err.println("Class not found.");
		}

		//Instantiate the class
		Set<string> s = null;

		try 
		{
			s = (Set<String>) cl.nexInstance();

		} catch(IllegalAccessException e) {
			System.err.println("Class not accessible.");
			System.exit(1);
		
		} catch(InstantiationException e) {
			System.err.println("Class not instantiable.");
			System.exit(1);
		}

		//Exercise the set
		s.addAll(Arrays.asList(args).subList(1, args.length));
		System.out.println(s);
	}
}
