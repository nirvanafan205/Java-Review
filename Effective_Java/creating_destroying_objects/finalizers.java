public class finalizers
{
	public static void main(String args[])
	{
		/*
			Explicit termination methods are typically used
	       		in combination with try-finally construct to ensure termination		
		*/

		Foo foo = new Foo(...);

		// try-finally block guarantees execution of termination method
		try
		{
			// do what mus be done with foo
		} 

		finally
		{
			foo.terminate(); //Explicit termination method
		}
	}
}	

/*
	Finalizers are unpredicatable, dangerous, and unnecessary
        never do anything time-critical in a finalizer
	never depend on a finalizer to updtate critical persistent state
	severe performance penality for using finalizers
	use an explicit termination method	
 */
