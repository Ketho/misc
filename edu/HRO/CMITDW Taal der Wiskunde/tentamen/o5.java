import java.util.Random;

public class o5
{
	public static int[] numbers = {4, 6, 8, 10, 12, 14};
	
	public static void main(String[] args)
	{
		Random rnd = new Random();
		int[] times = new int[100000]; // number of times
		boolean[] bingo = new boolean[18]; // bingo card
		
		for (int i=0; i<times.length; i++)
		{
			int tries = 0;
			clear(bingo);
			
			while (true)
			{
				tries++;
				int sum = 0;
				
				for (int j=1; j<=3; j++) // number of dices
					sum += (1 + rnd.nextInt(6));
				
				//System.out.println(sum);
				bingo[sum-1] = true;
				
				if (check(bingo))
				{
					times[i] = tries;
					//System.out.println(i+"\t"+tries);
					break;
				}
			}
		}
		
		System.out.println(average(times));
	}
	
	public static double average(int t[])
	{
		double sum = 0;
		for (int v : t)
			sum += v;
		return sum / t.length;
	}
	
	public static void clear(boolean t[])
	{
		for (int i=0; i<t.length; i++)
			t[i] = false;
	}
	
	public static boolean check(boolean t[])
	{
		for (int v : numbers)
		{
			if (!t[v-1])
				return false;
		}
		return true;
	}
}

