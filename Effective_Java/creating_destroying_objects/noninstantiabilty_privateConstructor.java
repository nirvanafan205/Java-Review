class noninstantiability
{
	// Noninstantiable utility class
	public class UtilityClass
	{
		//Suppress default constructor for noninstantiability

		private UtilityClass()
		{
			throw new AssertionError();
		}

		//enforcing noninstantiability by making a class abstract doesn't work
		//a calss can be made noninstantiable by including a private constructor

	}
		public static void main(String args[])
		{
			System.out.println("Hello World");
		}
}
