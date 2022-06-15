class singleton
{
	//making a class a singleton can make it diffucult to test clients
	
	
	public class Elvis
	{
		public static final Elvis INSTANCE = new Elvis();
		private Elvis() {}

		public void leaveTheBuilding() {}

		/*
		 	 no protected or public constructor guarantees one elvis instance
			 it can be attacked by a privileged client that could invoke privtate constructor
			 with AccessibleObject.setAccissible method
		 */
	}

	/* the following defends against the attack to throw an exception
	   if asked to create a second instance
	*/

	public class Elvis
	{
		private static final Elvis INSTANCE = new Elvis();
		private Elvis() {}
		public static Elvis getInstance() { return INSTANCE;}

		public void leaveTheBuilding() {}

		/*
			all calls to Elvis.getInstance returns the same object reference
		        no other Elvis instance will be created ever, even with the attack	

			with public, declarations make it clear that the class is a singleton
			public stat field is final, so it'll contain the same object reference

			with static factory method, one can change their mind about a class should
			be a singleton w/o changing its API


		 */
	}

	//Enum singleton
	
	public enum Elvis
	{
		INSTANCE;

		public void leaveTheBuilding() {}

		/*
			just like the public field approach except it provides
			serialization and more protection against multiple instansiation	 
		 */
	}
}
