

public class Punt
{
	// implement UML notation
	private double x;
	private double y;
	
	// constructor
	public Punt(double xCoordinaat, double yCoordinaat)
	{
		x = xCoordinaat;
		y = yCoordinaat;
	}
	
	// getters,setters
	public double getX() {return x;}
	public void setX(double x) {this.x = x;}
	
	public double getY() {return y;}
	public void setY(double y) {this.y = y;}	
	
	public String toString() // override
	{
		return "<Punt("+x+","+y+")>";
	}
	
	public void transleer(double dx, double dy)
	{
		x += dx;
		y += dy;
	}
	
	// Euclidean distance between 2 points (kortste weg)
	public double afstand(Punt p)
	{
		// sqrt( (x2-x1)^2 + (y2-y1)^2 )
		return Math.sqrt(Math.pow(p.x - this.x,2) + Math.pow(p.y - this.y,2));
	}
	
	public boolean equals(Object obj) // override
	{
		if (obj instanceof Punt) //  check if obj is more specifically, a Punt object
		{
			Punt p = (Punt) obj; // temp Punt object
			return this.x==p.x && this.y==p.y;
		}
		return false; // obj is not Punt type
	}
}

