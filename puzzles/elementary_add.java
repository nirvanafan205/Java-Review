class add
{
	public static void main (String[] args)
	{
		//System.out.println(12345 + 5432l);  always use 'L' instead of 'l' (el)
		//makes things confusing differentiating the number one and letter l
		
		System.out.println(12345 + 5432L);
	}

	// also never use el (l) as a variable name, too confusing
	
	/*
	 	List<String> l = new ArrayList<String>();
		l.add("Foo");
		System.out.println(l);

		THIS IS BAD
	 */
}
