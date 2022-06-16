class objects
{
	public static void main(String args[])
	{
		// reuse a single object is faster
		String = new String("stringette"); // don't do this
		// new String instance each time executed, unnecessary
		
		String s = "stringette"; // single String instance, doesn't create new ones
		Long sum = 0L; // that simple L could make the program much slower
	// prefer primitives to boxed primitives, and watch out for unintentional autoboxing
	
		for(long i = 0; <=INTEGER.MAX_VALUE; i++)
		{
			sum += i;
		}

		System.out.println(sum);
	}

	/*
		public class Person 
	{
			private final Date birthdate;

		public boolean isBabyBoomer()
		{
			//Unnecessary allocation of expensive object

			Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
			
			gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
			
			Date boomStart = gmtCal.getTime();
			gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);		

			Date boomEnd = gmtCal.getTime();

			return birthDate.compareTo(boomStart) >= 0 && birtDate.compareTo(boomEnd) < 0;
		}
	}
		
		unnecessarily creates a new Calendar, TimeZone, and two Date instances each time it is invoked
		
		32,000 ms for 10 million invocations
	*/


	/*
		public class Person
		{
				private static final Date BOOM_START;
				private static final Date BOOM_END;	


			static
			{
				Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
				gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
				BOOM_START = gmtCal.getTime();
				
				gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
				BOOM_END = gmtCal.getTime();
	 
			}

			public boolean isBabyBoomer()
			{
				return birthDate.compareto(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0;
			}	
		}

		this version of the Person class creates Calendar, TimeZone, and Date instances only once when it is initialized instead of each time it's invoked
		it also takes 130 ms which makes it 250 times faster
	 */

		//another long program that has a lot of data over something simple as type difference
	
	

}
