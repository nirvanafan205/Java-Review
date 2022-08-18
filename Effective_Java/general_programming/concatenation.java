public class concatenation
{
	public static void main(String[] args)
	{
		//using string concatenation operator repeatedly to concatenate n strings 
		//requires time quadratic in n
		System.out.println("HEllo World");
	}

	public String statement()
	{
		String result = "";

		for(int i = 0; i < numItems(); i++)
		{
			result += lineForItem(i); //String concatenation
		}

		return result;
	}

	//use StringBuilder in place of a String
	public String statement()
	{
		StringBuilder b = new StringBuilder(numItems() * LINE_WIDTH);

		for(int i = 0; i < numItems(); i++)
		{
			b.append(lineForItem(i));
		}

		return b.toString();
	}
	//^^function is in linear
}
