public class loops
{
	public static void main(String[] args)
	{
		System.out.println("Hello World");
	}

	//no longer preferred idiom to iterate over a collection
	for(Iterator i = c.iterator(); i.hasNext(); )
	{
		doSomething((Element) i.next() ); // no generics before 1.5
	}

	//preferred idiom for iterating over an array 
	//dont iterate array as so
	for(int i = 0; i < a.length; i++)
	{
		doSomething(a[i]);
	}

	// preferred method is for-each loop to iterate over collections and arrays
	for(Element e : elements) //read : as in; for each element e in elements
	{
		doSomething(e);
	}
	
	//common mistacks for nested iteration over two collections
	enum Suit { CLUB, DIAMOND, HEART, SPADE }
	enum Rank { ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING }

	Collection<Suit> suits = Arrays.asList(SUit.values());
	Collection<Rank> ranks = Arrays.asList(Rank.values());

	List<Card> deck = new ArrayList<Card>();

	for(Iterator<Suit> i = suits.iterator(); i.hasNext();)
	{
		for(Iterator<Rank> j = ranks.iterator(); j.hasNext(); )
		{
			deck.add(new Card(i.next(), j.next()));
		}
	}
	/*
		next method is called too many times for the outer collection (suits)
		should be called from the outer loop but is called from the inner loop, called once per card
		throws NoSuchElementException
	*/

	//other issue could be size of outer collection is a multiple of the size of inner collection
	//same bug, different symptom
	enum Face {ONE, TWO, THREE, FOUR, FIVE, SIX }

	Collection<Face> faces = Arrays.asList(Face.values() );

	for(Iterator<Face> i = faces.iterator(); i.hasNext(); )
	{
		for(Iterator<Face> j = faces.iterator(); j.hasNext(); )
		{
			System.out.println(i.next() + " " + j.next());
		}
	}
	//program doesnt throw an exception but prints only the six "doubles"
	//"ONE ONE" to "SIX SIX"
	
	//possible fix, but not really great
	//add a variable in the scope of the outer loop to hold the outer element
	for(Iterator<Suit> i = suits.iterator(); i.hasNext(); )
	{
		Suit suit = i.next();
		for(Iterator<Rank> j - ranks.iterator(); j.hasNext(); )
		{
			dec.add(new Card(suit, j.next()));
		}
	}

	//best idiom for nexted iteration on collections and arrays
	for(Suit suit in suits)
	{
		for(Rank rank : ranks)
		{
			dec.add(new Card(suit, rank));
		}
	}
	//any object that implements the iterable interface can be iterated
	

	//thre times you cant use a for-each loop
	
	/*
		Filtering - traversing a collection and removing a selected elments 

		Transforming - traversing as list or array and replace some or all values of its elements

		Parallel iteration - traversing multiple collections in parallel
	*/
}
