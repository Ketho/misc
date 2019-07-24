class Opdracht1_6
{
	public static void main(String[] args)
	{
		for (int i=0; i<6; i++)
		{
			// print rows with amount of asterisks == row index
			for (int j=0; j<=i; j++)
				System.out.print("* ");
			
			System.out.println(); // new row
		}
	}
}

