package opdracht3_1;

class Opdracht3_1
{
	static int[] seq2 = {1, 2};
	static int[] seq6 = {4, 7, 2, -1, 5, 7};
	
	// shows the contents of an array, divided by spaces, cursor on the next line
	public static void println(int[] a)
	{
		for (int i=0; i<a.length; i++)
			System.out.print(a[i]+" ");
		
		System.out.println();
	}
	
	// substitutes the first and second element of an array
	public static void verwissel(int[] a)
	{
		// pre: array needs to have at least 2 elements
		if (a.length < 2)
			return;
		
		int temp = a[0]; // store value in temp variable
		a[0] = a[1];
		a[1] = temp;
	}
	
	// copy/return an array with the same length and contents as seq
	public static int[] kopieer(int[] a)
	{
		// new array with same array length
		int[] copy = new int[a.length];
		
		for (int i=0; i<a.length; i++)
			copy[i] = a[i];
		
		return copy;
	}
	
	// shift the elements of an array to the right
	// last element moves to the first element
	public static void roteer(int[] a)
	{
		int len = a.length;
		
		// pre: array most not be empty
		if (len == 0)
			return;
		
		// temporarily store the last element of the array
		int temp = a[len-1];
		
		// iterate from last element to first element in array (shift from left to right)
		for (int i=len-1; i>0; i--)
			a[i] = a[i-1];
		
		// store the contens of the previously last element in the first element of the array 
		a[0] = temp;
	}
	
	// method overloading, reuse other roteer method
	public static void roteer(int[] a, int n)
	{
		for (int i=0; i<n; i++)
			roteer(a);
	}
}

