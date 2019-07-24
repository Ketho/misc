package opdracht3_2;

class Opdracht3_2
{
	// returns the element with the highest number value
	public static int max(int[] a)
	{
		// initially compare all elements with the lowest value possible
		int maxv = Integer.MIN_VALUE;
		
		// pre: array must have at least 1 element or more
		if (a.length > 0)
		{
			for (int i=0; i<a.length; i++)
			{
				if (a[i] > maxv)
					maxv = a[i];
			}
		}
		
		// maxv stays at Integer.MIN_VALUE if array has zero elements
		return maxv;
	}
	
	// returns the element index of a given value if there is any in the array
	public static int index(int[] a, int el)
	{
		// pre: array must have at least 1 element or more
		if (a.length > 0)
		{
			for (int i=0; i<a.length; i++)
			{
				if (a[i] == el)
					return i;
			}
		}
		
		// array has 0 elements or did not find the element
		return -1;
	}
	
	// returns whether an array has an element with value == el
	// reuse the index method
	public static boolean bevat(int[] a, int el)
	{
		return index(a, el) != -1;
	}
	
	// calculates and returns whether value el is a prime number
	public static boolean isPriem(int el)
	{
		// prime numbers cant be smaller than zero (and smaller than two) by definition
		if (el < 2)
			return false;
		
		for (int p=2; p<el; p++)
		{
			if (el%p == 0)
				return false; // el is not a prime number
		}
		return true; // el is a prime number
	}
	
	// calculates and returns the amount of prime numbers in the array
	// multiple instances of the same value are also counted
	public static int telPriemgetallen(int[] a)
	{
		int numPriem = 0;
		
		for (int v : a) // for-each loop
		{
			// check if element is a prime
			if (isPriem(v))
				numPriem++;
		}
		
		return numPriem;
	}
	
	// returns a copy of an array but containing only the prime numbers
	public static int[] priemgetallenIn(int[] a)
	{
		int index = 0;
		
		// set the copied array length to the amount of prime numbers
		int[] onlyPriem = new int[telPriemgetallen(a)];
		
		for (int v : a) // for-each loop
		{
			if (isPriem(v)) // check if element is a prime
			{
				onlyPriem[index] = v; // store prime number
				index++;
			}
		}
		
		// trim uninitialized elements (zeros) at the end
		return onlyPriem;
	}
	
	// calculate the prime numbers up to value n and return them in an array
	public static int[] priemgetallenTot(int n)
	{
		if (n < 2) // prime cant be smaller than zero or two by definition
			return new int[0]; // return empty array
		
		int index = 0; // index of the found prime number
		int[] priem = new int[n]; // not optimal; trim this array afterwards
		
		for (int p=2; p<n; p++) // number to be checked
		{
			if (isPriem(p)) // p is a prime number
			{
				priem[index] = p; 
				index++;
			}
		}
		
		// trim the prime number array before returning it
		return trim(priem, index);
	}
	
	// trim/copy an array to a specified top boundary
	public static int[] trim(int[] a, int boundary)
	{
		int[] copy = new int[boundary];
		
		for (int i=0; i<boundary; i++)
			copy[i] = a[i];
		
		return copy;
	}
}

