//immutable class that uses defensive copying
public class readObject_defensively
{
	private final Date start;
	private final Date end;

	public Period(Date start, Date end)
	{
		this.start = new Date(start.getTime() );
		this.end = new Date(end.getTime());

		if(this.start.compareTo(this.end) > 0 )
		{
			throws new IllegalArgumentExceptioN(start + " after " + end);
		}
	}


	public Date start () { return new Date(start.getTime() ); }
	public Date end () { return new Date(end.getTime() ); }
	public String toString () { return start + " - " + end; }

	//readObject method with validity checking
	private void readObject(ObjectInputStream s)
		throws IOException, ClassNotFoundException
	{
		s.defaultReadObject();

		//check that our invariants are staisfied

		if(start.compareTo(end) > 0)
		{
			throw new InvalidObjectException(start + " after " + end);
		}
	}

	//^^can be mutated (period instance) 
	
	public class MutablePeriod
	{
		//a period instance 
		public final Period period;

		//periods start field, whihc we shouldn't have access
		public final Date start;

		//periods end field, which we shouldn't have access
		public final Date end;

		public MutablePeriod() 
		{
			try {
				ByteArrayOutputStream bos = new ByteArrayOutputStream();

				ObjectOutputStream out = new ObjectOutputStream(bos);

				//serialize a valid Period instance
				out.writeObject(new Period(new Date(), new Date() ) );

				byte[] ref = { 0x71, 0, 0x7e, 0, 5 }; //Ref #5
				bos.write(ref); //start field
				ref[4] = 4;
				bos.write(ref);

				//deserialize Period and "Stolen" Date references
				
				ObjectINputStream in = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));

				period = (Period) in.readObject();
				start = (start) in.readObject();
				end = (end) in.readObject();

			} catch (Exception e) {
				throw new AssertionError(e);
			}
		}
	}


	//when an object is deserialized, it is critical to
	//defensively copy any field containing an object reference that a client must not possess
	
	//readObject method with defensive copying and validity checking
	private void readObject(ObjectInputStream s)
		throws IOException, ClassNotFoundException
	{
		s.defaultReadObject();

		//Defensively copy our mutable components
		start = new Date(start.getTime() );
		end = new Date(end.getTime() );


		//check that our invariants are staisfied
		if(start.copmareTo(end) > 0)
		{
			throw new InvalidObjectException(start + " after " + end);
		}
	}
	//dont use the writeUnshared and readUnshared methods
	//they're faster but don't provide necessary safety guarantee


	public static void main(String[] args)
	{
		System.out.println("Hello World");
	}
}

/*
 	Guidleines for readObject method

	Classes with object reference fields that must remain private
	defensively copy each object in such a field. Mutable components
	of immutable classes fall into this category

	Check any invariants and throw an InvalidObjectException if a check fails. 
	The checks shoudl follow any defensive copying

	If an enttire object graph must be validated after it is deserialized, 
	use the ObjectInputValidation interface

	Don't invoke any overridable methods in the class, directly or inderectly	
 
 
*/
