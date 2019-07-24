


public class Cirkel
{
	private Punt middelpunt;
	private double straal;
	
	// constructor
	public Cirkel(Punt mp, double st)
	{
		middelpunt = mp;
		
		//if straal <= 0 straal = -1
		straal = st>0 ? st : -1;
	}
	
	// getters, setters
	public Punt getMiddelpunt() {return middelpunt;}
	public void setMiddelpunt(Punt mp) {middelpunt = mp;}
	
	public double getStraal() {return straal;}
	public void setStraal(double st) {straal = st;}
	
	public String toString() // override
	{
		//return "<Cirkel(<Punt("+middelpunt.getX()+","+middelpunt.getY()+")>,"+straal+")>";
		return "<Cirkel("+middelpunt.toString()+","+straal+")>";
	}
	
	public boolean equals(Object obj) // override
	{
		if (obj instanceof Cirkel) // check if obj is more specifically, a Cirkel object
		{
			Cirkel c = (Cirkel) obj; // temp Cirkel object
			//return this.middelpunt.getX()==c.middelpunt.getX() && this.middelpunt.getY()==c.middelpunt.getY() && this.straal==c.straal;
			return this.middelpunt.equals(c.middelpunt) && this.straal==c.straal;
		}
		return false; // obj is not Cirkel type
	}
	
	public double omtrek()
	{
		// 2pi * r
		return 2*Math.PI * straal;
	}
	
	public double oppervlakte()
	{
		// oppervlakte van een cirkel = pi * r^2
		return Math.PI * Math.pow(straal, 2);
	}
	
	public void transleer(double dx, double dy)
	{
		middelpunt.transleer(dx, dy);
	}
	
	// compare euclidian distance between both center points, to sum of their radiuses
	public boolean overlapt(Cirkel c)
	{
		// euclidian distance < (r1 + r2)
		return this.middelpunt.afstand(c.middelpunt) < this.straal + c.straal;
	}
}

