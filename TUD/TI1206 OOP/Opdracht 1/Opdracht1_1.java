class Opdracht1_1
{
	public static void main(String[] args)
	{
		int getal = 10;
		System.out.println("Een klein getal: "+getal);
		getal++;
		System.out.println("Een klein getal plus een: "+getal);
		
		int grootstegetal = Integer.MAX_VALUE;
		System.out.println("\nEen heel groot getal: "+grootstegetal);
		
		grootstegetal++; // overflow to sign bit
		System.out.println("Een heel groot getal plus een: "+grootstegetal);
	}
}
