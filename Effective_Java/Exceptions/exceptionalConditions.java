public class exceptionalConditions
{
	public static void main(String[] args)
	{
		//horrible abuse of exceptions
		try
		{
			int i = 0;
			while(true)
			{
				range[i++].climb();
			}
		} catch(ArrayIndexOutOfBoundsException e) {
		}
		//exceptions are to be used only for exceptional conditions
		//never used for ordinary control flow
		//stick to loops for this case 
	}
}
