public class custom_serialize
{
	public static void main(String[] args)
	{
		//don't accept the default serialized form without first considering 
		//wether it's appropriate

		//default serialized form is likely to be appropriate if an
		//object's physical representation is identical to its logical content
	}
}

//good canidate for default serialized form
public class Name implements Serializable
{
	Last name. //must  be non-null
		@serial

		private final String lastName;

	first name. Must be non-null
		@serial

		private final String firstName;

	Middle name, or null if there's none

		private final String middleName;

	//Even if you decide that the default serialized form is appropriate
	//you often must provide a readObject method to ensure invariants and security


	//awful canidate for default serialzed form
	public final class StringList implements Serializable
	{
		private int size = 0;
		private Entry head = null;

		private static class Entry eimplements Serializable
		{
			String data;
			Entry next;
			Entry previous;
		}
	}

	/*
	   Using the default serialized form when an objects physical representation
	   differs substantially from its logical data content has four disadvantages

	   it permantely ties the exported API to the current internal representation

	   It can consume excessive space

	   It can consume excessive time

	   it can cause stack overflows		
	   */
}


//StringLIst with a reasonable custom serialized form
public final class StringList implements Serializable
{
	private transient int size = 0;
	private transient Entry head = null;

	//no longer serializable
	private static class Entry
	{
		String data;
		Entry next;
		Entry previous;
	}

	//appends specified string to the list
	public final void add(String s) { ... }

	private void writeObject(ObjectOutputStream s)
			throws IOException {
			s.defaultWriteObject();
			s.writeInt(size);

			//write out all elemetns in the proper order
			for(Entry e = head; e != null; e = e.next)
			{
				s.writeObject(e.data);
			}

			private void readObject(ObjectInputStream s)
					throws IOException, ClassNotFoundException
				{
					s.defaultReadObject();
					int numElements = s.readInt();

					//read all elements and insert them in list
					for(int i = 0; i < numElements; i++)
					{
						add((String) s.readObject() );
					}
				}
	} 
	//if all instance fields are transient
	//its technically permissible to dispense with invoking 
	//defaultWriteObject and defauoltReadObject
	//not its not recommended
	
	//before deciding to make a field nontransient
	//convice yourself that its value is part of the logical state of the object
	
	//you must impose any synchronization on object serialization that you would impose 
	//on any other method that reads the entire state of the object
	
	//writeObjeft for synchronized class with default serialized form
	private synchronized void writeObject(ObjectOutputStream s)
	throws IOException {
	s.defaultWriteObject();
	}

	//Regardless of what serialized form you choose, declare an explicit serial version UID in every serializable class you write{

}
