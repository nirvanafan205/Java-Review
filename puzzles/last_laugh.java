public class last_laugh
{
	public static void main(String[] args)
	{
		System.out.print("H" + "a");

		System.out.print('H' + 'a'); //H and a are char literals adds the two ascii 72 + 97; uses widening primitive conversion
		//prints out Ha169


		//to concatanate characters, use libraries such ass string buffer

		StringBuffer sb = new StringBuffer();
		sb.append('H');
		sb.append('a');
		System.out.println(sb);

		//another way would be forcing + operator to perform string concatenation rather than addition
		//ensure that at least one of its operands is a string; empty string ("")
		System.out.print("" + 'H' + 'a');
		//may be confusing for numbers so use printf
		System.out.printf("%c%c", 'H', 'a');

		//The + operator performs string concatenation if and only if
		//at least one of its operands is of type string
		//otherwise it performs addition
	}
}
