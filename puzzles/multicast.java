public class multicast
{
	public static void main(String args[])
	{
		System.out.println((int) (char) (byte) -1); //prints out 65535

		/*
			sign extension is the root of this problem	 
			conversion from byte to char isn't widening primitive conversion
			it is widening and narrowing primitive conversion as the byte is converted
			to an int and the int to a char

			sign extension is performed if the type of the original value is signed; zero extension if it is a char
			if it is a char, regardless of its type to which it is beign converted to

			byte is signed type, sign extension happens converting byte value -1 to a char
			char value has all 16 bits so it's 2^16 (65535)

			if you can't tell what a program does by looking at it,
			it probably doesn't do what you want
		*/
	}
}
