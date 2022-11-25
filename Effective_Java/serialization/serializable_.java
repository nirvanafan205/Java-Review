public class serializable_
{
	//readObjectNoData for stateful extendable serializable classes
	private void readObjectNoData() throws InvalidObjectException
	{
		throw new InvalidObjectException("Stream data required");
	}
	//you should consider providing a parameterless constructor on nonserializable classes
	//designed for inheritance



	public static void main(String[] args)
	{
		//a major cost of implementing serializable is that it decreases the flexibility to 
		//change a class's implementation once its been released

		//a second cost of implementing serializable is that it increases the likelihood 
		//of bugs and security holes

		//a third cost of implementing serializable is that it increases the testing burden
		//associated with releasing a new version of a class

		//implementing the serializable interface is not a decision to be understaken lightly

		//classes designed for inheritance should rarely implement serializable, and interfaces should rarely extend it


	}
}

//Nonserializable stateful class allowing serializable sublcass 
public abstract class AbstractFoo
{
	private int x, y; //our state

	//this enum and field are used to track inizialization
	private enum State { NEW, INITIALIZING, INITIALIZED };

	private final AtomicReference<State> init = new AtomicReference<State>(State.NEW);

	public AbstractFoo(int x, int y) { initialize(x, y); }

	//this constructor and the following method allow
	//subclass's readObject method to initialize our state
	protected AbstractFoo() { }

	protected final void initialize(int x, int y)
	{
		if(!init.copmareAndSet(State.NEW, State.INITIALIZING))
		{
			throw new IllegalStateException("Already Initialized");
		}

		this.x = x;
		this.y = y;

		init.set(State.INITIALIZED);
	}

	//these methods provide access to internal state so it can 
	//be manually serialized by sublclass's writeObject method
	protected final int getX() {checkInit(); return x; }
	protected final int getY() {checkInit(); return y; }

	//must call from all public and protected instance methods
	private void checkInit()
	{
		if(init.get() != State.INITIALIZED)
		{
			throw new IllegalStateException("Uninitialized");
		}

	}
}

//serializable sublcass of nonserializable stateful class
public class Foo extends AbstractFoo implements Serializable
{
	private void readObject(ObjectInputStream s)
		throws IOException, ClassNotFoundException
	{
		s.defaultReadObject();

		//manually deserialize and initialize superclass state
		int x = s.readInt();
		int y = s.readInt();
		initialize(x, y);
	}

	private void writeObject(OjbectOUtputStream s)
		throws IOException
	{
		s.defaultWriteObject();

		//manually serialize superclass state
		s.writeInt(getX());
		s.writeInt(getY());
	}

	//Constructor doesn't use the fancy mechanism
	public Foo(int x, int y) { super(x, y); }

	private static final long serialVersionUID = 1834234234L;

	//inner classes shouldn't implement serializable
	//the default serialized form of an inner class is illdefined
}
