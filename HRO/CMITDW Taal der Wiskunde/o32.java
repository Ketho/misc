// opdracht 3.2; abc-formule; oplossingen
public class o32
{
	public static void main(String[] args)
	{
		double[] a = { 3,-2, .5,  1, 2, 0, 2};
		double[] b = { 2, 3, .3,  0, 5, 5, 0};
		double[] c = {-5, 0,-.2,-25, 4, 3, 0};
		
		for (int i=0; i<a.length; i++)
		{
			double D = Math.pow(b[i], 2) - (4 * a[i] * c[i]);
			
			if (a[i] == 0)
				System.out.println(i+"\tEr zijn geen oplossingen (a == 0)");
			else if (D < 0)
				System.out.println(i+"\tEr zijn geen oplossingen (D < 0)");
			else if (D == 0)
				System.out.println(i+"\tEr is een oplossing, namelijk x = "+-b[i]/(2*a[i]));
			else if (D > 0)
			{
				double v1 = Math.sqrt(D);
				double v2 = 2 * a[i];
				
				double x1 = (-b[i] + v1) / v2; // positive
				double x2 = (-b[i] - v1) / v2; // negative
				
				System.out.println(i+"\tEr zijn twee oplossingen, namelijk x1 = "+x1+"\tx2 = "+x2);
			}
		}
	}
}

