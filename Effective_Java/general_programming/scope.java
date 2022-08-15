public class scope
{
	public static void main(String[] args)
	{
		System.out.println("Hello World");
	}

	//declare a local variable where it is first used, not before it's used
	//just about every local variable declaration should contain an initializer


	//prefer for loops to while loops
	//preferred idiom for iterating over a collection
	for(Element e : c)
	{
		doSomething(e);
	}

	//while looop - bad practice
	Iterator<Element> i = c.iterator();
	
	while(i.hasNext() )
	{
		doSomething(i.next());
	}

	Iterator<Element> i2 = c2.iterator();

	while(i.hasNext() )  //bug copy past error
	{
		doSomethingElse(i2.next() );
	}

	//for loop copy paste error
	for(Iterator<Element> i = c.iterator(); i.hasNext(); )
	{
		doSomething(i.next() );
	}

	//Compile-time error - cannot find symbol i
	for(Iterator<Element> i2 = c2.iterator(); i.hasNext(); )
	{
		doSomething(i2.next() );
	}

	//for loop is shorter which makes better readability
	for(int i = 0, n = expensiveComputation(); i < n; i++)
	{
		doSomething(i);
	}
	//keep methods small and focuesed
}
