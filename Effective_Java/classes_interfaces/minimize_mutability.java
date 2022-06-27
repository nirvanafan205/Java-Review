public class minimize_mutability
{
	public static void main(String args[])
	{
		System.out.println("Hello World");
	}

	public final class Complex
	{
		private final double re;
		private final double im;

		public Complex(double re, double im)
		{
			this.re = re;
			this.im = im;
		}

		//accessors with no corresponding mutators
		public double realPart() { return re; }
		public double imaginaryPart() { return im; }

		publicComplex add(Complex c)
		{
			return new Complex(re + c.re, im + c.im);
		}

		public Complex subtract(Complex c)
		{
			return new Complex(re - c.re, im - c.im);
		}

		public Complex multiply(Complex c)
		{
			return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
		}

		public Complex divide(Complex c)
		{
			double tmp = c.re * c.re + c.im * c.im;

			return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re  * c.im) / tmp);
		}

		@Override public boolean equals(Object o)
		{
			if(o == this)
			{
				return true;
			}

			if(!(o instanceof Complex))
			{
				return false;
			}

			Complex c = (Complex) o;

			return Double.compare(re, c.re) == 0 && Double.compare(im, c.im) == 0;
		}

		@Override public int hasCode()
		{
			int result = 17 + hasDouble(re);
			result = 31 * result + hasDouble(im);
			return result;
		}

		private static int hashDouble(double val)
		{
			long longBits = Double.doubleToLongBits(val);
			return (int) (longBits ^ (longBits >>> 32));
		}

		@Override public String toString()
		{
			return "(" + re + " + " + im + "i)";
		}

		//immutable objects are inherently thread-safe; they require no synchronization
		//immutable objects can be shared freely
		//provide public static final constants for frequently used values

		public static final Complex ZERO = new Complex(0, 0);
		public static final Complex ONE = new Complex(1, 0);
		public static final Complex I = new Complex(0, 1);
		//not only can you share immutable objects, but you can share their internals
		//immutable objects make great building lbokcs for other objects
		//The only real disadvantage of immuta ble classes is that they require seperate object for each distinct value
		
		//immutable class with static factories instead of constructors
		public class Complex
		{
			private final double re;
			private final double im;

			private Complex(double re, double im)
			{
				this.re = re;
				this.im = im;
			}

			public static Complex valueOf(double re, double im)
			{
				return new Complex(re, im);
			}
		}
	}
}

/* To make a class immutable, follow these five rules

   1. Don't provide any methods that modify the object's state

   2. Ensure that class can't be extended

   3. Make all fields final

   4. make all fields private

   5. Ensure exclusive access to any mutable components
   */
