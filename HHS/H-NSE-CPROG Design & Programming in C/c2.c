
#include <stdio.h>

double bereken_gemiddelde(int getal) {
	static double sum = 0;
	static int i = 0;
	sum += getal;
	i++;
	return sum / i;
}

int main(void) {
	double gemiddelde;
	
	while (1) {
		int getal;
		scanf("%d", &getal);
		
		if (getal == 0)
			break;
		else
			gemiddelde = bereken_gemiddelde(getal);
	}
	
	printf("%.1f\n", gemiddelde);
}

