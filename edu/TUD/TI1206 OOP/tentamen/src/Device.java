
public abstract class Device extends Product
{
	int capaciteit;
	double grootteScherm;
	String processor;
	String model;
	
	/**
	 * Getter
	 * @return returns something
	 */
	public int getCapaciteit()
	{
		return capaciteit;
	}
	/**
	 * Setter
	 * @param capaciteit sets something
	 */
	public void setCapaciteit(int capaciteit)
	{
		this.capaciteit = capaciteit;
	}
	
	/**
	 * Getter
	 * @return returns something
	 */
	public double getGrootteScherm()
	{
		return grootteScherm;
	}
	/**
	 * Setter
	 * @param grootteScherm sets something
	 */
	public void setGrootteScherm(double grootteScherm)
	{
		this.grootteScherm = grootteScherm;
	}
	
	/**
	 * Getter
	 * @return returns something
	 */
	public String getProcessor()
	{
		return processor;
	}
	/**
	 * Setter
	 * @param processor sets something
	 */
	public void setProcessor(String processor)
	{
		this.processor = processor;
	}

	/**
	 * Getter
	 * @return returns something
	 */
	public String getModel()
	{
		return model;
	}
	/**
	 * Setter
	 * @param model sets something
	 */
	public void setModel(String model)
	{
		this.model = model;
	}
	
	/**
	 * Constructor with too much params too list..
	 */
	public Device(String kleur, double prijs, String model, int capaciteit, double grootteScherm, String processor)
	{
		super(kleur, prijs);
		this.model = model;
		this.capaciteit = capaciteit;
		this.grootteScherm = grootteScherm;
		this.processor = processor;
	}
}
