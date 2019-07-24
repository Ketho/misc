/*
* The pow subroutine calculates powers of natural bases
* and exponents.
*
* Arguments:
*
* base - the exponential base
* exp - the exponent
*
* Return value: 'base' raised to the power of 'exp'.
*/
class power
{
	public static void main(String[] args)
	{
		System.out.println(pow(2, 10)); // = 1024
	}
	
	public static int pow(int base, int exponent)
	{
		int sum = 1;
		
		while (exponent > 0)
		{
			sum *= base;
			exponent--;
		}

		return sum;
	}
}

