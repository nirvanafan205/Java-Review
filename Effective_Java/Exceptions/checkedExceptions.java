public class checkedExceptions
{
	public static void main(String[] args)
	{
		System.out.println("Hello World");
		
		//checked exception into an unchecked exception
		//break the method that throws the exception tino two methods
		try {
			obj.action(args);
		} catch(TheCheckedException e) {
			//handle exceptional condition
		}

		//into this: invocation with state-testing method and unchecked exception
		if(obj.actionPermitted(args)) 
		{
			obj.action(args);
		}

		else 
		{
			//handle exceptional condition
		}
	}
}
