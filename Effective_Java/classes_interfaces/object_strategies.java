public class object_strategies
{
	public static void main(String args[])
	{
		System.out.println("Hello World");
	}

	//function objects
	class StringLengthComparator
	{
		public int compare(String s1, String s2)
		{
			return s1.length() - s2.length();
		}
	}

	//singleton to save on unnecessary object creation costs
	class StringLengthComparator
	{
		private StringLengthComparator() {}

		public static final StringLengthComparator Instance = new StringLengthCOmparator();

		public int compare(String s1, String s2)
		{
			return s1.length() - s2.length();
		}
	}

	//define a strategy interface to go with the concrete stragety class
	public interface Comperator<T>
	{
		public int compare(T t1, T t2);
	}

	//concrete strategy class to implement second intervface
	class Host
	{
		private static class StrLenCmp implements Comparator<String>, Serializable
		{
			public int compare(String s1, String s2)
			{
				return s1.length() - s2.length();
			}
		}
		
		//returned comparator is serializable
		public static final Comparator<String> STRING_LENGHT_COMPARATOR = new StrLenCMP();
	}
}
