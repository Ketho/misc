
#include <stdio.h>
#include <math.h>

int IsPrime(int value);

int main(void) {
	// ask for number
	int a;
	printf("Geef een nummer\n");
	scanf("%d", &a);
	
	// show whether number is a prime
	int priem = IsPrime(a);
	printf("%d %s priemgetal\n", a, priem ? "is een" : "is geen");
	
	/*
	// print prime numbers up to n
	for (int i=0; i<1e3; i++) {
		int isPrime = IsPrime(i);
			if (isPrime)
				printf("%d\n", i);
	}
	*/	
	
	return 0;
}

int IsPrime(int value) {
	if (value>=2) { // value must be equal or bigger than 2
		for (int i=2; i<=sqrt(value); i++) // only check up to sqrt for efficiency
			if (value%i == 0) // evaluate if value can be wholly divided by all smaller values
				return 0; // not prime
		
		return 1; // value is prime
	}
	else
		return 0;
}

