
#include <stdio.h>

double CelsiusToFahrenheit(double c);
double CelsiusToKelvin(double c);
void PrintTemperature(double celsius);

double celsiusFloor = -273.15;

int main() {
	printf("Hoe veel graden Celsius?\n");
	
	// scan values
	double celsius;
	scanf("%lf", &celsius); // scan long float
	
	if (celsius > celsiusFloor) {
		// convert
		double fahrenheit = CelsiusToFahrenheit(celsius);
		double kelvin = CelsiusToKelvin(celsius);
		
		// print conversion
		printf("C\t\tF\t\tK\n");
		PrintTemperature(celsius);
	}
	else
		puts("ERROR");
}

// F = C*1.8 + 32
double CelsiusToFahrenheit(double c) {
	return c*1.8 + 32;
}

// K = C + 273.15
double CelsiusToKelvin(double c) {
	return c + 273.15;
}

void PrintTemperature(double celsius) {
	double f = CelsiusToFahrenheit(celsius);
	double k = CelsiusToKelvin(celsius);
	printf("%f\t%f\t%f\n", celsius, f, k);
}
