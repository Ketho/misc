class vbtent5
{
	public static void main(String[] args)
	{
		System.out.println(product(3)); // 48
		System.out.println(sigmaproduct(2, 3)); // 690
	}
	
	public static float product(int a)
	{
		int sum = 1;
		for (int i=1; i<=a; i++)
		{
			sum *= 2*i;
		}
		return sum;
	}
	
	public static float sigmaproduct(int a, int b)
	{
		int sigma = 0;
		for (int x=1; x<=a; x++)
		{
			int pi = 1;
			for (int y=1; y<=b; y++)
			{
				pi *= 2*x*y+1;
			}
			sigma += pi;
		}
		return sigma;
	}
}

