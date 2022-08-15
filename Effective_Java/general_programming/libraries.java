public class libraries
{
	public static void main(String[] args)
	{
		System.out.println("Hello World");
	}

	//suppose you want to generate random ints between zero and some upper bounds
	//this is wrong
	private static final Random rnd = new Random();

	static int random(int n)
	{
		return Math.abs(rnd.nextInt()) % n;
	}

	/*
	 	three flaws with this

		if n is small power of two, rnd will generate repeated numbers early

		if not a power of two, on average be returned more frequently than others

		if n is large, it can be crazy

		number can be returned thats outside of range
	*/

	//better way to have millions of random numbers generated
	int n = 2 * (Integer.MAX_VALUE / 3);
	int low = 0;

	for(int i = 0; i < 1000000; i++)
	{
		if(random(n) < n / 2)
		{
			low++;
		}
	}

	System.out.println(low);

	//using Random.nextInt(int) is your go to for random numbers
	//using standard library, you take advantage of knowledge of experts who wrote it 
	//and experience of those who used it before you
}
