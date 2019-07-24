#include <stdio.h>

long int inout();

int main()
{
	puts("Assignment 2: inout");
	
	long int x = inout();
	x++;
	
	printf("%ld\n", x);
	return 0;
}

long int inout()
{
	long int *n;
	scanf("%ld", n);
	return *n;
}

