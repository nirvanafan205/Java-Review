class long_division
{
	public static void main(String args[])
	{
		/*
		   final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000; //overflows with huge number, it uses int arithmatic, needs long arithmatic
		   final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
		*/

		final long MICROS_PER_DAY = 24L * 60 * 60 * 1000 * 1000;
		final long MILLIS_PER_DAY = 24L * 60 * 60 * 1000;

		System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY); //prints 5???
	}
}

/*
   It concerns a program that divides two long values. The dividend represents the number of microseconds in a day;
   the divisor, the number of milliseconds in a day
   what does the program print?	
*/
