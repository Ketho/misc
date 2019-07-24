// opdracht 7.2; puzzel 2
public class o72
{
	public static void main(String[] args)
	{
		System.out.println("i\ti^2\ti^3\tsingle");
		
		for (int i=1; i<=1000; i++)
		{
			int square = (int) Math.pow(i, 2);
			int cube = (int) Math.pow(i, 3);
			String s = String.valueOf(square)+String.valueOf(cube);
			boolean hasNumbers = true;
			
			for (int j=0; j<=9; j++)
			{
				// check for each number in either strings
				if (!s.contains(String.valueOf(j)))
				{
					hasNumbers = false;
					break;
				}
			}
			
			if (hasNumbers)
			{
				boolean single = true;
				
				for (int j=0; j<=9; j++)
				{
					// ommitted first instance of number
					String sub = s.substring(s.indexOf(String.valueOf(j))+1);
					// find any second instance of number
					if (sub.contains(String.valueOf(j)))
					{
						single = false;
						break;
					}
				}
				
				System.out.println(i+"\t"+square+"\t"+cube+"\t"+single);
			}
		}
	}
}

