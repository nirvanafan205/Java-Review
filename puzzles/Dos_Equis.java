public class Dos_Equis
{
	public static void main(String args[])
	{
		char x = 'X';
		int i = 0;

		System.out.println(true ? x : 0);
		/*
			If one of the operands is of type T where T is byte, short, or char
		        and the other operand is a constant expression of type int whose value
			is representable in type T, the type of the conditional expression is T	
		*/

		System.out.println(false ? i : x); // its return type is the result of applying binary numeric promotion to int and char which is int
		/*
			Binary numeric promotion is applied to the operand types,
		        and the type of conditional expression is the promoted type of
			the second and third operands	
		*/

		// ? the value of the condition is true
		// : the value to use if the condition is false

		// use the same type for the second and third operands in condition expressions
	}
}
