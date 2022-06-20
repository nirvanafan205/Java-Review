public class tweedledee
{
	public static void main(String args[])
	{
		/*
		   make this a legal statement: x = x + i;
		   make this an illegal statement: x += i;
		*/


		Object x = "Buy "; 

		String i = "Effective Java!"; 

		/*
		 	x = x + i is legal 
			because x + i is of type string and string is assignment compatible with object
		*/

		/*
		 	x += i is illegal
			because the left-hand side has an object reference type other than String
		*/
	}
}
