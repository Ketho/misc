class Pilot extends Part
{
	void calculate() throws PilotException
	{
		// F(piloot) = 0.005
		if (Math.random() < .005)
			throw new PilotException();
	}
}

