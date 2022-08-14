public class return
{
	public static void main(String[] args)
	{
		System.out.println("Hello World");
	}

	private final List<Cheese> cheesesInStock = ...;

	//@return an array containing all of the cheeses in the shop
	//or null if no cheeses are available for purchase
	public Cheese[] getCheeses()
	{
		if(cheesesInStock.Size() == 0)
		{
			return null;
		}
	}

	//no need to return empty arrays
	Cheese[] cheeses = shop.getCheeses();

	if(cheeses != null && Arrays.asList(cheeses).contains(Cheese.STILTON))
	{
		System.out.println("Jolly good, just the thing.");
	}

	//instead of 
	if(Arrays.asList(shop.getCheeses()).contains(cheese.STILTON))
	{
		System.out.println("Jolly good, just the thing.");
	}

	//the right way to return an array from a collection
	private final List<Cheese> cheesesInStock = ...;

	private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];

	//return an array containing all of the cheeses in the shop
	
	public Cheese[] getCheeses()
	{
		return cheesesInStock.toArray(EMPTY_CHEESE_ARRAY);
	}

	//the right way to return a copy of a collection
	public List<CHeese> getCheeseList()
	{
		if(cheesesInStock.isEmpty())
		{
			return Collections.emptyList(); // always returns same list
		}

		else
		{
			return new ArrayList<Cheese>(cheesesInStock);
		}
	}

	//there is no reason ever to return null from an array or collection valued method
	//instead of returning an empty array or collection
}
