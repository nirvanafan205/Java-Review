public class heirarchies
{
	public static void main(String args[])
	{
		System.out.println("Hello World");
	}

	//tagged class, inferior to class hierarchy
	//tagged classes are verbose, error-prone, and inefficient
	class Figure
	{
		enum Shape { RECTANGLE, CIRCLE };
		
		//tag field - the shape of this figure
		final Shape shape;

		//used only if shape is rectangel
		double width;	
		double length;

		//only used if shape is CIRCLE
		double radius;

		//Constructor for circle
		
		Figure(double radius)
		{
			shape = Shape.CIRCLE;
			this.radius = radius;
		}

		//Constructor for rectangle
		
		Figure(double length, double width)
		{
			shape = Shape.RECTANGEL;
			this.length = length;
			this.width = width;
		}

		double area()
		{
			switch(shape)
			{
				case RECTANGLE:
					return length * width;

				case CIRCLE:
					return Math.PI * (radius * radius);
					
				default:
					throw new AssertionError();
			}
		}
	}

	//class hierarchy replacement for a tagged class
	abstract class Figure
	{
		abstract double area();
	}

	class Circle extends Figure
	{
		final double radius;

		Circle(double radius) { this.radius = radius; }

		double area() { return Math.PI * (radius * radius); }
	}

	class Rectangle extends Figure
	{
		final double length;
		final double width;

		Rectangle(double length, double width)
		{
			this.length = length;
			this.width = width;
		}

		double area() { return length * width; }
	}	

	//class hierarchies can be made to reflect natural hierarchical relationship among types
	//allowing flexibility and better compile time type checking
	//class hierarchy could be made to reflect the fact a square is a special kind of rectangle
	
	class Square extends Rectangle
	{
		Square(double side)
		{
			super(side, side);
		}
	}
}
