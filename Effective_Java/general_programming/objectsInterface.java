public class objectInterfaces
{
	public static void main(String[] args)
	{
		System.out.println("Hello World");
	}
	//if appropriate interface types exist, then parameters, return values, variables, and fields
	//should all be declared using interface types
	//Good- uses interface as type
	List<Subscriber> subscribers = new Vector<Subscriber>();

	//bad - uses class as type
	Vector<Subscriber> subscribers = new Vector<Subscriber>();

	//if you get into the habit of using interfaces as types
	//your program will be much more flexible
	
	//to switch implementations
	//change class name in constructor
	List<Subscriber> subscribers = new ArrayList<Subscriber>();
}
