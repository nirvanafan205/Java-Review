public class interfacesVSabstract
{
	public static void main(String args[])
	{
		System.out.println("Hello World");
	}

	public interface Singer
	{
		AudioClip sing(Song s);
	}

	public interface Songwriter
	{
		Song compose(boolean hit);
	}

	public interface SingerSongwriter extends Singer, SOngwriter
	{
		AudioClip strum();
		void actSensitive();
	}

	//Concrete implementation built atop skeletal implementation
	static List<Integer> intArrayAsList(final int[] a)
	{
		if(a == null)
		{
			throw new NullPointerException();
		}

		return new AbstractList<Integer>()
		{
			public Integer get(int i)
			{
				return a[i]; //autoboxing
			}

			@Override public Integer set(int i, Integer val)
			{
				int oldVal = a[i];
				a[i] = val;
				return oldVal;
			}

			public int size()
			{
				return a.length;
			}
		}
	};

	//Skeletal implementation
	public abstract class AbstractMapEntry<K,V> implements Map.Entry<K,V>
	{
		//Primitive operations
		public abstract K getKey();
		public abstract V getValue();

		//Entries in modifiable maps must override this method
		public V setValue(V value)
		{
			throw new UnsupportedOperationException();
		}

		//Implements the general contract of Map.Entry.equals
		@Override public boolean equals(object o)
		{
			if(o == this)
			{
				return true;
			}

			if(!(o instanceof Map.Entry))
			{
				return false;
			}

			Map.Entry<?,?> arg = (Map.Entry) o;
			return equals(getKey(), arg.getKey()) && equals(getValue(), arg.getValue());

		}

		private static boolean equals(Object o1, Object o2)
		{
			return o1 == null ? o2 == null : o1.equals(o2);
		}

		@Override public int hasCode()
		{
			return hashCode(getKey()) ^ hashCode(getValue());
		}

		private static int hasCode(Object obj)
		{
			return obj == null ? 0 : obj.hashCode();
		}
	}
}

/*
	Existing classes can be easily retrofitted to implement a new interface

	interfaces are ideal for defining mixins	

	interfaces enable safe, powerful functionality enhancements

	You can combine the virtues of interface and abstract classes by
	providing an abstract skeletal implementation class to go with each
	nontrivial interface that you export

	It is far easier to evolve an abstract class than an interface

	Once an interface is released and widely implemnented
	it is almsot impossible to change
*/
