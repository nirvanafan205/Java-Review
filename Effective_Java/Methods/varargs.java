public class varargs
{
	public static void main(String[] args)
	{
		System.out.println("Hello World");
	}

	/*
	 	varags aka variable arity methods accepts zero or more arguments of a specified type
		creates an array whose size is the number of arguments passed at the call site
		putting the argument values into the aray
		and finally passing the array to the method
	 */

	//example, takes a sequence of int arguemtns and returns its sum(1, 2, 3) = 6
	//value of sum() is 0
	static int sum(int ... args)
	{
		int sum = 0;
		for(int arg : args)
		{
			sum += arg;
		}
		return sum;
	}

	//wrong way to use varargs to pass one or more arguments
	static int min(int ... args)
	{
		if(args.length == 0)
		{
			throw new IllegalArgumentException("Too few arguments");
		}

		int min = args[0];

		for(int i = 1; i < args.length; i++)
		{
			if(args[i] < min)
			{
				min = args[i];
			}

			return min;
		}
	}
	//if client invokes this method w/o arguments, it fails at runtime than compile time
	//also ugly
	
	//right way to use varargs to pass one or more arguments
	static int min(int firstArg, int... remainingArgs)
	{
		int min = firstArg;

		for(int arg : remainingArgs)
		{
			if(arg < min)
			{
				min = arg;
			}

			return min;
		}
	}
}
