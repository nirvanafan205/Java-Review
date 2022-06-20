public class swap_meat
{
	public static void main(String args[])
	{
		int x = 1984; //(0x7c0) prints 0 which is incorrect
		int y = 2001; //(0x7d1) prints 1984 which is correct 
		// over all program is flawed

		//x ^= y ^= x ^=y;

		//correctly using or

		y = (x ^= (y ^= x)) ^y;

		/*
			this is what's happening in the program
			
			int temp1 = x; first appearance of the x in the expression
			int temp2 = y; first appearance of y
			int temp3 = x ^ y; compute x ^ y
			x = temp3; last assignment: Store x ^ y in x
			y = temp2 ^ temp3; 2nd assignment: store original x value in y
			x = temp1 ^ y; first assignment: Store 0 in x
		*/


		System.out.println("x = " + x + "; y = " + y);

		/*
			Never assign the same variable more than once in a single expression
		        avoid cleaver programming tricks
				they're bug prone, 
				difficult to maintian
				and run slower	
		 */
	}
}
