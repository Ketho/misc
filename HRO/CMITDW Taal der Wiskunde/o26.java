// opdracht 2.6; Sigmoidefunctie
// http://www.wolframalpha.com/input/?i=1%2F%281%2Bexp%28-t%29%29
public class o26
{
	public static void main(String[] args)
	{
		double min = 1337;
		double max = 0;
		
		for (int i=-10; i<=10; i++)
		{
			double s = sigmoide(i);
			min = Math.min(min, s);
			max = Math.max(max, s);
			System.out.println(i+"\t"+s);
		}
		
		System.out.println(min+"\t"+max); // range = [0 ; 1]
	}
	
	public static double sigmoide(double t)
	{
		return 1 / (1 + Math.exp(-t));
	}
}

