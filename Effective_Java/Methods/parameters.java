public class parameters
{
	public static void main(String[] args)
	{
		System.out.println("hello World");
	}
}

//throws @ArithmeticException if m is less than or equal to 0

public BigInteger mod(BigInteger m)
{
	if(m.signum() <= 0)
	{
		throw new ArithmeticException("Modulus <= 0: " + m);
	}
}

//unexported method should generally check parameters w/ assertions
private static void sort(long a[], int offset, int length)
{
	assert a != null;
	assert offset >= 0 && offset <= a.length;
	assert length >= 0 && length <= a.length - offset;
}
/*asserted condition will be true no matter what
assertions throw AssertionError if they fail

Document restrictions and enforce them with explicit checks at the beginning of the method body
clearly document restrictions and enforce them with checks at the beginning
/*
 

