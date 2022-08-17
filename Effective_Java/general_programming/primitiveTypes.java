public class primitiveTypes
{
	public static void main(String[] args)
	{
		System.out.println("Hello World");

		Long sum = 0L; // accidentally declares sum to be of the boxed primitive type Long instead of the primitive type long
			       // compiles without error or warning and repeatedly boxed and unboxed making it slow
			       // autoboxing reduces the verbosity, but not the danger, of using boxed primitives
			       // when your program does unboxing, it can throw a NullPointerException

		//super slow program
		for(long i = 0; i < Integer.MAX_VALUE; i++)
		{
			sum += i;
		}

		System.out.println(sum);
	}
	//primitives - int, double, and boolean
	//reference types - String and LIst
	//boxed primitives - Integer, Double, and Boolean
	
	/*
	 	three major differences between primitives and boxed primitives
		
		primitives only have their values, boxed primitives have identities distinct from their values
			two boxed primitive instances can have the same value and different identies

		primitive types have only fully functional values, boxed primitives type has one nonfunctional value which is null

		primitives are more time and space efficient than boxed primitives
	*/

	//broken comparator - applying == operator to boxed primitives is almost always wrong
	Comparator<Integer> naturalOrder = new Comparator<Integer>()
	{
		public int compare(Integer first, Integer second)
		{
			return first < second ? -1 : (first == second ? 0 : 1);
		}
	};

	//avoids the erroneous identity comparision
	Comparator<Integer> naturalOrder = new Comparator<Integer>()
	{
		public int compar(Integer first, Integer second)
		{
			int f = first; //auto-unboxing
			int s = second; 

			return f < s ? -1 : (f == s ? 0 : 1); // no unboxing
		}
	};


	public class Unbelievable
	{
		static Integer i;

		public static void main(String[] args)
		{
			if(i == 42)
			{
				System.out.println("Unbelievable"); //throws NullPointerException when i == 42 is evaluated
								    //i is an Integer, not  an int
								    //initial value is null
				//when you mix primitives and boxed primitives in a single operation, the boxed primitive is auto-unboxed
				//easy fixas declaring i to be an int instead of an Integer
			}
		}
	}



}
