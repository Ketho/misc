// opdracht 3.1; abc-formule
public class o31
{
	public static void main(String[] args)
	{
		double[] a = { 3,-2, .5,  1, 2, 0};
		double[] b = { 2, 3, .3,  0, 5, 5};
		double[] c = {-5, 0,-.2,-25, 4, 3};
		
		for (int i=0; i<=5; i++)
		{
			double v1 = Math.sqrt(Math.pow(b[i], 2) - (4 * a[i] * c[i]));
			double v2 = 2 * a[i];
			
			double x1 = (-b[i] + v1) / v2; // positive
			double x2 = (-b[i] - v1) / v2; // negative
			
			System.out.println(a[i]+"\t"+b[i]+"\t"+c[i]+"\t"+x1+"\t"+x2);
		}
	}
}

