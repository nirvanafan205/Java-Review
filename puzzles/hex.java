public class hex
{
	public static void main(String args[])
	{
		System.out.println(Long.toHexString(0x100000000L + 0xcafebabe)); // this will make it mix 1 infront of 'cafebabe'
		// above is adding a long with an int. sign extension promotes the int value to a Long value type
		
		System.out.println(Long.toHexString(0x100000000L + 0xcafebabeL));
		//make these both a long data type to get '1cafebabe'
	}
}
