public class ABC
{
	public static void main(String[] args)
	{
		String letters = "ABC";

		char[] numbers = { '1', '2', '3' };

		System.out.println(letters + " easy as " + numbers); //prints ABC easy as [C@16f0472
		//prints a unicode character instead of its numerical code
		//char[] overloading of println prints all of the characters contained in the array
		//to convert a char array to a string, invoke String.valueOf(char[])

		//two ways to fix
		//convert array to a string before invoking string concatenation:
		System.out.println(letters + " easy as " + String.valueOf(numbers));

		//break the System.out.println invocation in two to make use of the char[] overloading
		System.out.print(letters + " easy as " );
		System.out.println(numbers);
	}
}
