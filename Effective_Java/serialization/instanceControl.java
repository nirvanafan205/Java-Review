//singleton pattern that restricts accesss to ts constructor to ensure that 
//onjly a single instance is ever created
public class Elvis
{
	public static final Elvis INSTANCE = new Elvis();
	priavate Elvis() { ... }

	public void leaveTheBuilding() { ... }
	//readResolve for instance control - you can do better!
	private Object readResolve()
	{
		//Return the one true Elvise and let the garbage collector
		//take care of the Elvis impersonator
		return INSTANCE;
	}

	//if you depend on readResolve for instance control
	//all instance fields with object reference types must be declared transient
}

//broken singleton - has nontransient object reference field
public class Elvis implements Serializable
{
	public static final Elvis INSTANCE = new Elvis();
	private Elvis() {}

	private String[] favoriteSongs = { "Hound Dog", "HeartBreak Hotel" };

	public void printFavorites() 
	{
		System.out.println(Arrays.toString(favoriteSongs));
	}

	private Object readResolve()
	{
		return INSTANCE;
	}
}

//stealer class
public class ElvisStealer implements Serializable
{
	static Elvis impersonator;
	private Elvis payload;

	private Object readResolve()
	{
		//save a reference to the "unresolved" Elvis instance
		impersonator = payload;

		//return object of correct type for favoriteSongs field
		return new String[] { "A FOol Such as I" };

	}

	private static final long serialVersionUID = 0;
}

//Enum singleton - preferred approach
public enum Elvis
{
	INSTANCE;

	private String[] favoriteSongs = { "Hound Dog", "Heartbreak Hotel" };

	public void printFavorites()
	{
		System.out.println(Arrays.toString(favoriteSongs));
	}
}
//the accessibility of readResovlve is significangt
