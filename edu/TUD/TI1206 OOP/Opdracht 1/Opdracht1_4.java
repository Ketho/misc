import java.util.Scanner;

class Opdracht1_4
{
	// string array remap 1=eerste, 2=tweede, etc
	static String[] s = {"eerste", "tweede", "derde"};

	public static void main(String[] args)
	{
		System.out.println("Geef 3 onderling verschillende hele getallen:");
		
		Scanner sc = new Scanner(System.in);
		int[] numbers = new int[3]; // int array
		
		// input numbers
		numbers[0] = sc.nextInt();
		numbers[1] = sc.nextInt();
		numbers[2] = sc.nextInt();
		
		int max = 0;
		int index = 0;
		
		// check for highest number to corresponding array index
		for (int i=0; i<numbers.length; i++)
		{
			if (numbers[i] > max)
			{
				max = numbers[i];
				index = i;
			}
		}
		
		System.out.println("Het "+s[index]+" ("+max+") getal is het grootst.");
		sc.close();
	}
}

