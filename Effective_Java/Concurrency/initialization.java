public class initialization
{
	//lazy initialization holder class idiom for static fields
	private static class FieldHolder
	{
		static final FieldType field = computeFieldValue();
	}

	static FieldType getField() 
	{
		return FieldHolder.field;
	}

	public static void main(String[] args)
	{
		//normal initialization is preferable to lazy initialization
		
		//normal initialization of an instance field
		
		private final FieldType field = computeFieldValue();

		//if lazy initialization to break an initialization circularity
		//use a synchronized accessor

		//lazy initialization of instance field - synchronized accessor
		private Fieldtype field;

		synchronized FieldType getField()
		{
			if(field == null)
			{
				field = computeFieldValue();

				return field
			}
		}
	}

	//if you need to use lazy initialization for performance on an instance field
	//use the double-check idiom
	//double check idiom for lazy initialization of instance fields
	private volatile FieldType field;

	FieldType getField()
	{
		Fieldtype result = field;

		if(result == null)
		{
			synchronized(this)
			{
				result = field;

				if(result == null)
				{
					field = result = computeFieldValue();
				}
			}
		}
		return result;
	}

	//single-check idiom - can cause repeated initialization
	private volatile FieldType field;

	private FieldType getField()
	{
		FIeldType result = field;

		if(result == null)
		{
			field = result = computeFIeldValue();
		}

		return result;
	}
}
