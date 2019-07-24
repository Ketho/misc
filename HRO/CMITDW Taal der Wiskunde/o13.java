// opdracht 1.3; Bol
public class o13
{
	public static void main(String[] args)
	{
		System.out.println(Oppervlakte(7)+"\n"+Inhoud(7)); // 615.7521601035994, 1436.7550402417319
	}
	
	public static double Oppervlakte(int r)
	{
		return 4 * Math.PI * Math.pow(r, 2); // 4pr^2
	}
	
	public static double Inhoud(int r)
	{
		return (double)4/3 * Math.PI * Math.pow(r, 3); // 4/3pr^3
	}
}

