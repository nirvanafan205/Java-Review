public class float_double
{
	//float and double types are particularly illsuited for monetary calculations
	public static void main(String[] args)
	{
		//borken - uses floating point for monetary calculation
		double funds = 1.00;
		int itemsbought = 0;

		for(double price = .10; funds >- price; price += .10)
		{
			funds -= price;
			itemsBought++;
		}

		System.out.println(itemsBought + " items bought."); 
		System.out.println("Change: $" + funds); //wrong funds left is $0.39999 left
		//use BigDecimal, int or long for monetary calculations

		//correct way
		final BigDecimal TEN_CENTS = new BigDecimal(".10");

		int itemsBought = 0;
		BigDecimal funds = new BigDecimal("1.00");

		for(BigDecimal price = TEN_CENTS; funds.compareTo(price) >= 0; price = price.add(TEN_CENTS))
		{
			funds = funds.subtract(price);
			itemsBought++;
		}

		System.out.println(itemsBought + " items bought.");
		System.out.println("Money left over: $" + funds);
		//all four pieces are affordable
		//$0.00 is left over which is correct


		//using BigDecimal is less conveinient than using primitive arithmetic type and its slower


		//substitution using ints
		int itemsBought = 0;
		int funds = 100;

		for(int price = 10; funds >= price; price += 10)
		{
			funds -= price;
			itemsBought++;
		}

		System.out.println(itemsBought + " items bought.");
		SYstem.out.println("Money left over: "+ funds + " cents");
		//use int if quantities doesn't exceed 9 decimal digits
		//if they dont exceed eighteen digits, use long
		//if quantities exceed 18 digitss, use BigDecimal
	}
}
