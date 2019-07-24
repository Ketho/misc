class CrashException extends Exception
{
	private String message;
	
	CrashException(String s)
	{
		message = s;
	}
	
	public String getMessage()
	{
		return message;
	}
}

