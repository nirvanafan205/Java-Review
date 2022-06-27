public class design_document
{
	public static void main(String args[])
	{
		System.out.println("Hello World");
	}


	//constructors must not invoke overridable methods
	public class Super
	{
		//broken - constructor invokes an overridable method
		public Super()
		{
			overrideMe();
		}

		public void overrideMe()
		{

		}
	}
}

/*
 	the class mus document its self-use of overridable methods
	
	a class may have to provide hooks into its internal workings
	in the form of judiciously chosen protected methods

	the only way to test a class designed for inheritance is to write subclasses

	you must test your class by writing subclasses before you release it

*/
