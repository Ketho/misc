// opdracht 5.3; Monte Carlo methode
import java.util.Random;

public class o53
{
	public static void main(String[] args)
	{
		int sum = 0;
		int n = 100; // amount of tests
		
		for (int i=1; i<=n; i++)
		{
			int result = MonteCarlo();
			sum += result;
			System.out.println(i+"\t"+result);
		}
		
		System.out.println((double) sum/n+" * 10 euro gemiddeld uitgegeven");
	}
	
	public static int MonteCarlo()
	{
		Random rnd = new Random();
		int i = 0;
		boolean[] p = new boolean[15 * 18]; // 15 plaatjes, 18 teams
		
		while (!IsFilled(p))
		{
			i++; // pakjes
			
			for (int j=1; j<=5; j++) // 5 plaatjes per pakje
				p[rnd.nextInt(270)] = true;
		}
		
		return i;
	}
	
	public static boolean IsFilled(boolean b[])
	{
		for (boolean v : b)
		{
			if (!v)
				return false;
		}
		return true;
	}
}

