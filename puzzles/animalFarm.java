public class animalFarm
{
	public static void main(String[] args)
	{
		final String pig = "lenght: 10";
		final String dog = "length: " + pig.length();

		System.out.println("Animals are equal: " + pig == dog); //wrong only prints false

		//use the equals method in preference to the == operator unless 
		//you need to compare object identity rather than value
		System.out.println("Animals are equal: " + pig.equals(dog)); //== operator doesnt test whether two objects are equal
									     //tests whether two object references are identical
									     //it tests wheter they refer to precisely the same object, in this case they dont

		/*
		 	When using string concatenation operator
			always parenthesize nontrivial operands

			your code should rerely, if ever, depend on the interning of string constants
		*/
	}
}
