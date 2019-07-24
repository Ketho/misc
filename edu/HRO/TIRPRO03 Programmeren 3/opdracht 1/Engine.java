class Engine extends Part
{
	void calculate() throws EngineException
	{
		// F(motor) = 0.001
		if (Math.random() < .001)
			throw new EngineException();
	}
}

