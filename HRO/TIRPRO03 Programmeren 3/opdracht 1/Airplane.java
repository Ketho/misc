class Airplane
{
	static Part[] parts = new Part[9];
	static boolean[] fails = new boolean[parts.length];
	
	Airplane()
	{
		parts[0] = new Engine(); // engine 1: outer
		parts[1] = new Engine(); // engine 2: inner
		parts[2] = new Engine(); // engine 3: inner
		parts[3] = new Engine(); // engine 4: outer
		
		parts[4] = new Flap(); // flap 1: left
		parts[5] = new Flap(); // flap 2: right
		
		parts[6] = new Pilot(); // pilot 1: captain
		parts[7] = new Pilot(); // pilot 2: first officer
		parts[8] = new Pilot(); // pilot 3: second officer
	}
	
	static void flight(int n) throws CrashException
	{
		int numEngine = 0;
		int numFlap = 0;
		int numPilot = 0;
		
		for (int i=0; i<parts.length; i++)
		{
			try
			{
				parts[i].calculate();
			}
			catch (EngineException e)
			{
				numEngine++;
				fails[i] = true;
			}
			catch (FlapException e)
			{
				numFlap++;
				fails[i] = true;
			}
			catch (PilotException e)
			{
				numPilot++;
				fails[i] = true;
			}
			catch (Exception e){} // dummy
		}
		
		Recorder.tEngine += numEngine;
		Recorder.tFlap += numFlap;
		Recorder.tPilot += numPilot;
		
		// chance for fEngine is really small (0.001^3)
		// check if both inner engines failed
		boolean fEngine = (numEngine >= 3 && fails[1] && fails[2]);
		
		if (fEngine || numFlap == 2 || numPilot == 3)
		{
			String s = "\n\tFlight: "+n
				+(numEngine>0 ? "\n\tEngines: "+numEngine : "")
				+(numFlap>0 ? "\n\tFlaps: "+numFlap : "")
				+(numPilot>0 ? "\n\tPilots: "+numPilot : "");
			
			throw new CrashException(s);
		}
	}
}

