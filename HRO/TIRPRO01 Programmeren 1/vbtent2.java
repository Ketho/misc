class vbtent2
{
	public static void main(String[] args)
	{
		int x=5, y=10, z=20;
		
		x *= y-z--;
		System.out.println("x: "+x+"\ty: "+y+"\tz: "+z);

		z *= 2+2;
		x = ++y/2;
		System.out.println("x: "+x+"\ty: "+y+"\tz: "+z);

		for (x=0; x<5; x++)
		{
			y += x;
			//System.out.println(x);
		}
		z %= 15;
		System.out.println("x: "+x+"\ty: "+y+"\tz: "+z);

		y -= z+x/2;
		System.out.println("x: "+x+"\ty: "+y+"\tz: "+z);
	}
}

