public class warnings
{
	public static void main(String args[])
	{
		System.out.println("Hello World");
	}

	//suppose you accidently write this declaration; you'd get unchecked conversion warning
	Set<Lark> exaltation = new HashSet();

	//make correction with
	Set<Lark> exaltation = new HashSet<Lark>();

	//always eliminate every unchecked warning that you can, it assures code is typesafe
	//use @SuppressWarnings annotation if can't eliminate a warning if it's typesafe
	//always use the suppresswarning annotation on the smallest scope possible


	//gives uncheckd cast warning, don't suppress warning
	public <T> T[] toArray(T[] a)
	{
		if(a.length < size)
		{
			return (T[]) Arrays.copyOf(elements, size, a.getClass());
		}

		System.arraycopy(elements, 0, a, 0, size);

		if(a.length > size)
		{
			a[size] = null;
		}

		return a;
	}

	public <T> T[] toArray(T[] a)
	{
		if(a.length < size)
		{
			//This cast is corerct because the array we're creating 
			//is of the same type as the one passed in, which is T[]
			@SupressWarnings("unchecked") T[] result = (T[]) Arrays.copyOf(elements, size, a.getClass());
			return result;
			//Every  tiume you use an @SupreessWarnings("unchecked") annotation
			//add a comment saying why its safe to do so
		}

		System.arraycopy(elements, 0, a, 0, size);

		if(a.length > size)
		{
			a[size] = null;
		}

		return a;
	}
}
