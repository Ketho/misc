import java.util.Random;

public class o1bc
{
	public static void main(String[] args)
	{
		Random rnd = new Random();
		int[] coins = new int[320000];
		
		for (int i=0; i<coins.length; i++)
		{
			//coins[i] = rnd.nextInt(6); // dit is fout blijkbaar
			for (int j=0; j<=4; j++)
				coins[i] += rnd.nextInt(2);
		}
		
		count(coins);
		
		double var = variance(coins);
		System.out.println("average =\t"+average(coins));
		System.out.println("variance =\t"+var);
		System.out.println("standard deviation =\t"+Math.sqrt(var));
	}
	
	public static void count(int t[])
	{
		for (int i=0; i<=5; i++)
		{
			int n = 0;
			for (int v : t)
			{
				if (v == i)
					n += 1;
			}
			System.out.println(i+": "+n+"x voorgekomen");
		}
	}
	
	public static double average(int t[])
	{
		double sum = 0;
		for (int v : t)
			sum += v;
		return sum / t.length;
	}
	
	public static double variance(int t[])
	{
		double avg = average(t);
		double sum = 0;
		for (int v : t)
			sum += Math.pow(v-avg, 2);
		return sum / t.length;
	}
	
	public static void explode(int t[])
	{
		for (int i=0; i<t.length; i++)
			System.out.println(i+"\t"+t[i]);
	}
}

