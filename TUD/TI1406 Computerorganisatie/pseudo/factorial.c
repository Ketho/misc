#include <stdio.h>

long int factorial(int);

int main()
{
	puts("Assignment 5: factorial");
	printf("%ld\n", factorial(4));
	return 0;
}

long int factorial(int n)
{
	if (n > 1)
		return n * factorial(n-1);
	else
		return 1;
}

