class Flap extends Part
{
	void calculate() throws FlapException
	{
		// F(flap) = 0.0005
		if (Math.random() < .0005)
			throw new FlapException();
	}
}

