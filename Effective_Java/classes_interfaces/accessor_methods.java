public class accessor_methods
{
	public static void main(String arg[])
	{
		System.out.println("Hello World");
	}

	//degenerate classes like this shouldn't be public
	class Point
	{
		public double x;
		public double y;
	}
	//doesn't offer encapsulation, can't change representation w/o changing API
	
	//use setters and getters
	class Point
	{
		private double x;
		private double y;

		public Point(double x, double y)
		{
			this.x = x;
			this.y = y;
		}

		public double getX() { return x;}
		public double getY() { return y;}

		public void setX(double x) { this.x = x; }
		public void setY(double y) { this.y = y;}
	}
	//if a class is accessible outside its package, provide accessor methods
	//if a class is package-private or is a private nested class
	//there is nothing wrong wit exposing data fields
	
	//exposed public class fields
	public final class Time
	{
		private static final int HOURS_PER_DAY = 24;
		private static final int MINUTES_PER_HOUR = 60;

		//exposed fields- questionable since immutable
		public final int hour;
		public final int minute;

		public Time(int hour, int minute)
		{
			if(hour < 0 || hour >= HOURS_PER_DAY)
			{
				throw new IllegalArgumentException("Hour: " + hour);
			}

			if (minute < 0 || minute >= MINUTES_PER_HOUR)
			{
				throw new IllegalArgumentException("Min: " + minute);
			}

			this.hour = hour;
			this.minute = minute;
		}
	}

	/*
	 	public classes should never expose mutable fields
		less harmful, but still questionable for public classes to expose immutable fields
		sometimes desirable for package-private or private nexted classes to expose fields
	 */
}
