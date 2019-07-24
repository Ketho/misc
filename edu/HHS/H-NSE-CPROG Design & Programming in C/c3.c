
#include <stdio.h>
#include <math.h>

void abc(double a, double b, double c);
double discriminant(double a, double b, double c);

int main(void) {
	// scan number of equations
	int testcases;
	scanf("%d", &testcases);
	
	for (int i=0; i<testcases; i++) {
		// scan parameters
		double a;
		scanf("%lf", &a);
		
		double b;
		scanf("%lf", &b);
		
		double c;
		scanf("%lf", &c);
		
		// print solutions to quadratic equation
		abc(a, b, c);
	}
}

double discriminant(double a, double b, double c) {
	return b*b - 4*a*c;
}

void abc(double a, double b, double c) {
	double disc = discriminant(a, b, c);
	double x1 = (-b + sqrt(disc)) / (2*a);
	double x2 = (-b - sqrt(disc)) / (2*a);
	
	if (disc < 0)
		printf("De vergelijking %.4fx^2 + %.4fx + %.4f heeft geen reële oplossingen.\n", a, b, c);
	else if (disc == 0) {
		printf("De oplossing van %.4fx^2 + %.4fx + %.4f is:\n", a, b, c);
		printf("x1 = %.4f\n", x1);
	}
	else if (disc > 0) {
		printf("De oplossingen van %.4fx^2 + %.4fx + %.4f zijn:\n", a, b, c);
		printf("x1 = %.4f, x2 = %.4f\n", x1, x2);
	}
}

