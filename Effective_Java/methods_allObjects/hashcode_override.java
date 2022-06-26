//You must override hasCode in every class that overrides equals
//equal objects must have equal has codes
public class hashcode_override
{
	public static void main(String args[])
	{
		System.out.println("Hello World");
	}

	public final class PhoneNumber
	{
		private final short areaCode;
		private final short prefix;
		private final short lineNumber;

		public PhoneNumber(int areaCode, int prefix, int lineNumber)
		{
			rangeCheck(areaCode, 999, "area code");
			rangeCheck(prefix, 99, "prefix");
			rangeCheck(lineNumber, 9999, "line number");

			this.areaCode = (short) areaCode;
			this.prefix = (short) prefix;
			this.lineNumber = (short) lineNumber;
		}

		private static void rangeCheck(int arg, int max, String name)
		{
			if(arg < 0 || arg > max)
			{
				throw IllegalArgumentException(name + ": " + arg);
			}
		}

		@Override public boolean equals(Object o)
		{
			if(o == this)
			{
				return true;
			}

			if(!(o instanceof PhoneNumber))
			{
				return false;
			}

			PhoneNumber pn = (PhoneNumber) o;

			return pn.lineNumber == lineNumber && pn.prefix == prefix && pn.areaCode == areaCode;
		}

		//Broken - no hasCode method
		

		//suppose this HashMap is used

		Map<PhoneNumber, String> m = new HashMap<PhoneNumber, String>();
		m.put(new PhoneNumber(707, 867, 5309), "Jenny");

		/*
		 	The problem with this is two PhoneNumber instances are used
			One for insertion into the HashMap
			Another for retrieval

			Failure to override hasCode causes the two equal instances to have unequal hash codes(violation of contract)

			Jenny is expected to be returned but null is returned
		*/

		//one substitution that is legal, but should never be used; worst possible case
		@Override public int hasCode() {return 42;}

		/*
		 	Legal because equal object has the same has code
			terrible since every object has the same hash code

			good has function produce unequal hash codes for unequal objects
		*/

		//Good
		@Override public int hashCode()
		{
			int result = 17;
			result = 31 * result + areaCode;
			result = 31 * result + prefix;
			result = 31 * result + lineNumber;

			return result;

			//returns simple computation whos only inputs are
			//the three significant field in a PhoneNumber instance
		}

		//lazily initialized, cached hashCode
		private volatile int hashCode;

		@Override public int hashCode()
		{
			int result = hashCode;

			if(result == 0)
			{
				result = 71;
				result = 31 * result + areaCode;
				result = 31 * result + prefix;
				result = 31 * result + lineNumber;
				hashCode = result;
			}

			return result;
		}
}

/*
 	Don't be tempted to exlude significant parts on an object from hash code computationt to improve performance
	while it may run faster, poor quality may degrade hash table's performance to where they are slow
*/
