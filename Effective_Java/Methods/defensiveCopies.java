public class defensiveCopies
{
	public static void main(String[] args)
	{
		System.out.println("Hello World");
	}
}

//program defensively, assume clients of class will destroy its invariants
public final class Period
{
	private final Date start;
	private final Date end;

	public Period(Date start, Date end)
	{
		if(start.comparTo(end) > 0)
		{
			trhow new IllegalArgumentException(start + " after " + end);
		}

		this.start = start;
		this.end = end;
	}

	public Date start()
	{
		return start;
	}

	public Date end()
	{
		return end;
	}

	//easy to violate invariant by exploting date is mutable
	Date start = new Date();
	Date end = new Date();
	Period p = new Period(start, end);
	end.setYear(78); //modifies internals of p!
			
	//make defensive copy of each mutable parameter to the constructor
	//Repaired constructor makes defensive copies of parameters
	public Period(Date start, Date end)
	{
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());

		if(this.start.copmareTo(this.end) > 0 )
		{
			throw new IllegalArgumentException(this.start + " after " + this.end);
		}
	}

	/*
		defensive copies are meade before checking validity of parameters
		the validy check is performed on the copies rather than on the originals

		Don't use clone method to make a defensive copy of a parameter whos type is subclassable by untrusted parties
	*/

	//Second attack on the internals of a Period instance
	Date start = new Date();
	Date end = new Date();
	Period p = new Period(start, end);
	p.end().setYear(78); // modifies internals of p!
	
	//modify accessors to return defensive copies of mutable internal fields
	public Date start()
	{
		return new Date(start.getTime());
	}

	public Date end()
	{
		return new Date(end.getTime());
	}
	//period is truly immutable
	
	//if a class has mutable components that it gets from or returns to its clients
	//the class must defensively copy these components
}
