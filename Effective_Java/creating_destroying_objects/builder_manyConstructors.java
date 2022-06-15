class builder_manyConstructors
{
	/* 	Telescoping constructor pattern
	 * 	
	 * 	public class NutritionFacts
	 *{
	 *
	 * 		private final int servingSize;
	 * 		private final int servings;
	 * 		private final int calories;
	 * 		private final int fat;
	 * 		private final int sodium;
	 * 		private final int carbohydrate;
	 *	
	 *	public NutritionFacts(int servingSize, int servings, int calories)
	 *	{
	 *		this(servingSize, servings, 0);
	 *	}
	 *
	 *	public NutritionFacts(int servingSize, int serviings, int caloreis)
	 *	{
	 *		this(servingSize, servings, calories, 0);
	 *	}
	 *
	 *	public NutritionFacts(int servingSize, int servings, int calories, int fat)
	 *	{
	 *		this(servingSize, servings, calories, fat, 0);
	 *	}
	 *
	 *	public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium)
	 *	{
	 *		this(servingSize, servings, caloreis, fat, sodium, 0);
	 *	}
	 *
	 *	public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate)
	 *	{
	 *		this.servingSize = servingSize;
	 *		this.servings = servings;
	 *		this.calories = calories
	 *		this.fat = fat;
	 *		this.sodium = sodium;
	 *		this.carbohydrate = carbohydrate;
	 *	}
	 *}
	 * hard to write client code when there are many paramdeters and still harder to read
	 */

	/*	Java beans Pattern (allows inconsistency, mandates mutability


		public class NutritionsFacts
		{
	//parameters inizialied to default values (if any)
	private int = -1;
	private int = -1;
	private int = 0;	
	private int = 0;	
	private int = 0;	
	private int = 0;	

	public NutritionFacts() {}

	//Setters

	public void setServingSize(int val)
	{
	servingSize = val;
	}

	public void setServings(int val)
	{
	servings = val;
	}

	public void setCalories(int val)
	{
	calories = val;
	}

	public void setFat(int val)
	{
	fat = val;
	}

	public void setSodium(int val)
	{
	sodium = val;
	}

	public void setCarbohydrate(int val)
	{
	carbohydrate = val;
	}
		}

	// inside of main

	NutritionFacts cocaCola = new NutritionFacts();

	cocaCola.setServingSize(240);
	cocaCola.setServings(8);
	cocaCola.setCalories(100);
	cocaCola.setSodium(35);
	cocaCola.setCarbohydrate(27);

	none of the disadvantages of telescoping constructor pattern
	easier, for elligble code

	DOWNSIDES

	since construction is split accross multiple alls, inconsistent state partway through its construction
	pattern precludes the possibility of making a class immutable

*/


	// Builder Pattern



	public class NutritionFacts
	{
		private final int servingSize;
		private final int serving;
		private final int calories;
		private final int fat;
		private final int sodium;
		private final int carbohydrate;

		public static class Builder
		{
			private final int servingSize;
			private final int servings;

			private int calories = 0;
			private int fat = 0;
			private int carbohydrate = 0;
			private int sodium = 0;

			public Builder(int servingSize, int servings)
			{
				this.servingSize = servingSize;
				this.servings = servings;
			}

			public Builder calories(int val)
			{
				calories = val; 
				return this;
			}

			public Builder fat(int val)
			{
				fat = val;
				return this;
			}

			public Builder carbohydrate(int val)
			{
				carbohydrate = val; 
				return this;
			}

			public Builder sodium(int val)
			{
				sodium = val;
				return this;
			}

			public NutritionFacts build()
			{
				return new NutritionFacts(this);
			}
		}

		private NutritionFacts(Builder builder)
		{
			servingSize = builder.servingSize;
			servings = builder.servings;
			calories = builder.calories;
			fat = builder.fat;
			sodium = builder.sodium;
			carbohydrate = builder.carbohydrate;
		}
	}		

	public static void main(String args[])
	{

		NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();
	}

}
