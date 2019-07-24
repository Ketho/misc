
#include <stdio.h>
#include <math.h>

double Round(double value, int decimal);
double Func1(double a, int N, double r);

int main() {
	printf("Geef a, N en r voor ∑(n=0, N, a*r^n)\n");
	
	double a;
	int N;
	double r;
	
	// scan values
	scanf("%lf", &a);
	scanf("%d", &N);
	scanf("%lf", &r);
	
	// print function output
	printf("%f\n", Func1(a, N, r));
}

// multiply to whole number, round, then divide back again for X decimals precision
double Round(double value, int decimal) {
	double a = pow(10, decimal);
	return round(value*a) / a;
}

// double a		parameter a
// int N		summation upper bound
// double r		parameter r
double Func1(double a, int N, double r) {
	double sum = 0;
	
	for (int i=0; i<=N; i++)
		sum += a * pow(r, i);
	
	return Round(sum, 2);
}

