public class overriding_equals
{
	public static void main(String args[])
	{
		System.out.println("Hello World");
	}

	// Broken - violates symmetry
	public final class CaseInsensitiveString
	{
		private final String s;

		public CaseInsensitiveString(String s)
		{
			if(s == null)
			{
				throw new NullPointerException();
			}
		
			this.s = s;
		}

		//Broken - violates symmetry
		@Override public boolean equals(Object o)
		{
			if(o instanceof CaseInsensitiveString)
			{
				return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
			}

			if(o instanceof String) // One-way interoperability! return s.equalsIgnoreCase((String) o);
			{
				return false;
			}

		}

		// cis.equals(s) returns true
		// s.equals(cis) returns calse
		// symmetry violationg
		CaseInsensitiveString cis = CaseInsensitiveString("Polish");
		String s = "polish";
		
		//once you've violated the equals contract
		//you don't know how other objects will behave when confronted with your object
		List<CaseInsensitiveString> list = new ArrayList<CaseInsensitiveString>();
		list.add(cis)

		//we don't know what list.contains(s) returns
	}

	public class Point
	{
		private final int x; 
		private final int y;

		public Point(int x, int y)
		{
			this.x = x;
			this.y = y;
		}

		@Override public boolean equals(Object o)
		{
			if(!(o instanceof Point))
			{
				return false;
			}

			Point p = (Point)o;

			return p.x == x && p.y == y;
		}

		public class ColorPoint extends Point
		{
			private final Color color;

			public ColorPoint(int x, int y, Color color)
			{
				super(x, y);
				this.color = color;
			}
		}

		//suppose you write an equals method and returns true only if
		//its argument is another color point with the same position and color

		//Broken - violates symmetry
		@Override public boolean equals(Object o)
		{
			if(!(o instance of ColorPoint))
			{
				return false;
			}
			
			//return super.equals(o) && ((ColorPoint) o).color == color;
			//thyere is no way to extend an instantiable class and
			//add a value component while perserving the equals contract
		}

		Point p = new Point(1, 2);
		ColorPoint cp = new ColorPoint(1, 2, Color.Red);

		//p.equals(cp) returns true; cp.equals(p) returns false


		//Ignores color
		@Override public boolean equals(Object o)
		{
			if(!(o instanceof Point))
			{
				return false;
			}

			//If o is a normal Point, do a color-blind comparision
			/*
			 	if(!(o instance of ColorPoint))
				{
					return o.equals(this);
				}
			*/

			// o is a colorPoint; do a full comparision

			return super.equals(o) && ((ColorPoint) o).color == color;
		}

		ColorPoint p1 = new ColorPoint(1, 2, Color.Red);
		Point p2 = new Point(1, 2);
		ColorPoint p3 = new ColorPoint(1, 2, Color.Blue);

		/*
		 	p1.equals(p2) and p2.equals(p3) returns true
			p1.equals(p3) returns false
			transivity violation
		*/
		//there is no way to extend an instantiable class and
		//adda  value component while preserving the equals contract
	}

	/*Liskov substitution; any important property of a type
	should also hold for its subtypes, so that any method writtien
	for the type should work equally well on its subtypes
	*/
	
	//Broken- biolates Liskov substition principle
	@Override public boolean equals(Object o)
	{
		if(o == null || o.getClass() != getClass())
		{
			return false;
		}

		Point p = (Point) o;
		return p.x == x && p.y == y;
	}
}

/*
	Contracts when overriding equals
	
	Each instance of the class is inherently unique

	Disregard if a class provides a "logical equality" test
		example
			java,util.Random could have overriden equals to check 
			whether two Random instances would produce the same sequence
			of random numbers going forward
	
	A superclass has already overridden equals, and the superclass behavior is appropriate for this class
		example
			Set implementations inherit their equals implementation from AbstractSet
			List implementations from AbstractList, and Map implementations from AbstractMap

	The class is private or package-private, and you are certain that its equals method will never be invoked.
*/

/*
 	when should one override Object.equals?
	when a class has a notion of logical equality that differs from object identity
	and when a superclass has not already overridden equals to implement the desired behavior
*/

/*
	General contract: equivalence relation

	*Reflective: For any non-null reference value x, x.equals(x) must return true

	*Symmetric: For any non-null reference values x and y, x.equals(y) mus return true
	if and only if y.equals(x) returns true

	*Transitive: For any non-null reference values x, y, z, if x.equals(y) returns true 
	and y.equals(z) returns true, then x.equals(z) must return true

	*Consistent: For any non0null reference values x and y, multiple invocations of x.equals(y)
	consistently return true or consistently return false, provided no information used in equals
	comparisons on the objects is modified

	For any non-null reference value x, x.equals(null) must return false

	Consistency requirements says that if two objects are equal, they must remain equal for all time unless
	one (or both) of them is modified
		mutable objects can be equal to different objects at different times while
		immutable objects can't

	DONT WRITE AN EQUALS METHOD THAT DEPENDS ON UNRELIABLE RESOURCES
		EX
			java.net.URL relies on comparison of the IP addresses of the hosts associated w/ URLS

	"Non-nullity" - all objects must be unequal to null
*/

//high quality equals method

/*
 	1. Use the == operator to check if the argument is a reference to this object

	2. Use the instanceof operator to check if the arguments has the correct type

	3. Cast the argument to the correct type

	4. For each "significant" field in the class, check if the filed of the argument
	   matches the corresponding field of this object

	5. When finished writing equals method, ask if its symmetric, transitive, and consistent
*/
