public class classes_members
{
	//make each class or member as inaccessible as possible
	public static void main(String args[])
	{
		System.out.println("Hello World");
	}

	//its wrong for a class to have a public static final array field
	//orr an accessor that returns such a field
	//potentional security hole
	public static final Thing[] VALUES = {...};
	
	//make the public array private and add a public immutable list
	private static final Thing[] PRIVATE_VALUES = {...};
	public static final List<Thing> VALUES = Collections.unmodifiableList(Arrays.asList(Private_Values));

	//another option is to make the array private
	//and add a public method that returns a copy of a private array
	
	private static final Thing[] PRIVATE_VALUES = {...};
	
	public static final Thing[] values()
	{
		return PRIVATE_VALUES.clone();
	}
	
	//four possible access levels in increasing order
	
	/*
	 	private: the member is accessible only from the top-level class where it is declared

		package-private: the member is accessible from any class in a package where it's declared.
		Technically known as default access, this is the access level you get if no access modifier is specified

		protected: the member is accessible from subclasses of the class where its declared and from any class
		in the package where it is declared

		public: the member is accessible from anywhere

		reduce accessibility as much as possible

		Ensure that objects referenced by public static final field are immutable
	*/
}
