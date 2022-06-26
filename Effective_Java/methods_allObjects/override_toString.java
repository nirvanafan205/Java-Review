public class override_toString
{
	public static void main(String args[])
	{
		System.out.println("Hello World");
	}

	//Whether or not you decide to specify the format, you should clearly document your intentions
	//super specific random stuff about the function
	@Override public String toString()
	{
		return String.format("(%03d) %03d-%04d", areaCode, prefix, lineNumber);
	}

	//if you decide not to specify a formant
	//random stuff about function
	@Override public String toString() {...}
}

/*
 	Providing a good toString implementation makes your class much more pleasant to use

	When practical, the toString method should return all of the interesting information contained in the object

	Provide programmatic access to all of the information contained in the value returned by toString
*/
