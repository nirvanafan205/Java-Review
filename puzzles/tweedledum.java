public class tweedledum
{
	public static void main(String args[])
	{
		// short x = 0;
		// int i = 123456;
		// x += i; contains a hiddent cast, wont compile - "possible loss of precision"
		// compound assignment operator


		/*
			Compound assignment expressions automatically cast the result of the computation
		        they perform to the type of the variable on their left-hand side	

			don't use commpound assignment operators on variables of type
			byte, short or char

			when using compound assignment operators on variables of type int, right hand-side cant be
			long, float, or double

			when using compound assignment operators on variables float type, right hand side cant be double

			compound assignment operators silently generate a cast
		*/
	}
}
