// opdracht 3.3; 5e-graads functie
// http://www.wolframalpha.com/input/?i=x%5E5-3x%5E2-2
public class o33
{
	public static void main(String[] args)
	{
		for (int i=0; i<=20; i++)
		{
			double x = (double) i/10;
			System.out.println(x+"\t"+(Math.pow(x, 5) - 3*Math.pow(x, 2) - 2));
		}
	}
}

