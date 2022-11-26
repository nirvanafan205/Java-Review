public class proxies
{
	public static void main(String[] args)
	{
		System.out.println("Hello World");
	}

	//serialization proxy for Period Class
	private static class SerializationProxy implements Serializable
	{
		private final Date start;
		private final Date end;

		SerializationProxy(Period p)
		{
			this.start = p.start;
			this.end = p.end;
		}

		private static long serialVersionUID = 1231242345L;
	}

	//writeReplace method for the serialization proxy pattern
	private Object writeReplace()
	{
		return new SerializationProxy(this);
	}

	//readObject method for the serialization proxy pattern
	private void readObject(ObjectInputStream stream)
	throws InvalidObjectException {
	throws new InvalidObjectException("Proxy required");
	}

	//readResolve method for Period.SerializationProxy
	private Object readResolve()
	{
		return new Period(start, end); //uses public constructor
	}


	//EnumSet's serialization proxy
	private static class SerializationProxy <E extends Enum<E>>
			implements Serializable {
			//the elment type of this enum set
		private final Class<E> elementType;

		//elements contained in this enum set
		private final Enum[] elements;

		SerializationProxy(EnumSet<E> set)
		{
			elementType = set.elementType;
			elements = set.toArray(EMPTY_ENUM_ARRAY);

		}

		private Object readResolve()
		{
			EnumSet<E> result = EnumSet.noneOf(elementType);

			for(Enum e : elements)
			{
				result.add((E)e);
				return result;
			}
		}

		private static final long serialVersionUID = 1234312532L;
	}
}
