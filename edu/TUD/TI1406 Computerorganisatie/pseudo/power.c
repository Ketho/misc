#include <stdio.h>

long int power(int, int);

int main()
{
	puts("Assignment 4: power");
	printf("%ld\n", power(2, 10));
	return 0;
}

long int power(int base, int exp)
{
	int total = 1;
	
	while (exp > 0)
	{
		exp--;
		total *= base;
	}
	
	return total;
}

