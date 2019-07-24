class factorial
{
	public static void main(String[] args)
	{
		System.out.println(factorial(4)); // = 24
	}
	
	public static int factorial(int n)
	{
		if (n > 1)
			return n * factorial(n-1);
		else
			return 1;
	}
}

