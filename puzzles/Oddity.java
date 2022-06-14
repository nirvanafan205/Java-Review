// The following method puports to determine whetehr its sole argument is an odd number. Does the method work?

class Oddity
{
	/*
	public static boolean isOdd(int i)
	{
		return i % 2 == 1;
	}

	incorrect, returns false on any negative value; odd or even
	when i is a negative odd number, the result is -1 rather than 1
	*/

	public static boolean isOdd(int i) // correct, comapare i with 0 instead of 1
	{
		return i % 2 != 0;
	}
	

	public static void main(String[] args)
	{
		int num = 4;
		
		System.out.println(isOdd(num));
	}
}
