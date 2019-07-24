
public abstract class Product
{
	private String kleur;
	private double prijs;
	
	/**
	 * Getter
	 * @return returns something
	 */
	public String getKleur()
	{
		return kleur;
	}
	/**
	 * Setter
	 * @param kleur sets something
	 */
	public void setKleur(String kleur)
	{
		this.kleur = kleur;
	}
	
	/**
	 * Getter
	 * @return returns something
	 */
	public double getPrijs()
	{
		return prijs;
	}
	/**
	 * Setter
	 * @param kleur sets something
	 */
	public void setPrijs(double prijs)
	{
		this.prijs = prijs;
	}
	
	public Product(String kleur, double prijs)
	{
		this.kleur = kleur;
		this.prijs = prijs;
	}
}
