
#include <stdlib.h>
#include <stdio.h>
#include <time.h>

#define SIZE 10

void initDots(char a[][SIZE]);
void iterateAlphabet(char a[][SIZE]);
void explodeArray(char a[][SIZE]);
	
int main(void) {
	char matrix[SIZE][SIZE]; // two-dimensional array
	initDots(matrix);
	iterateAlphabet(matrix);
	explodeArray(matrix);
}

void initDots(char a[][SIZE]) {
	// initialize/fill array with dots
	for (int i=0; i<SIZE; i++)
		for (int j=0; j<SIZE; j++)
			a[i][j] = '.';
}

void iterateAlphabet(char a[][SIZE]) {
	// set random seed
	srand(time(NULL));
	
	int x = 0, y = 0;
	
	// iterate over uppercase alphabet
	for (char i='A'; i<='Z'; i++) {
		a[x][y] = i; // set char at current array position
		
		// not the most efficient way to do this
		int noLeft = 0,
			noRight = 0,
			noUp = 0,
			noDown = 0;
		
		while (1) {
			int d = rand()%4; // get random number [0-3]
			
			// left
			if (d == 0) {
				// stay within array bounds
				// only move to a position with a dot
				if (x>0 && a[x-1][y] == '.') {
					x--;
					break;
				}
				else
					noLeft = 1;
			}
			// right
			else if (d == 1) {
				if (x<SIZE-1 && a[x+1][y] == '.') {
					x++;
					break;
				}
				else
					noRight = 1;
			}
			// up
			else if (d == 2) {
				if (y<SIZE-1 && a[x][y+1] == '.') {
					y++;
					break;
				}
				else
					noUp = 1;
			}
			// down
			else if (d == 3) {
				if (y>0 && a[x][y-1] == '.') {
					y--;
					break;
				}
				else
					noDown = 1;
			}
			
			if (noLeft && noRight && noUp && noDown) {
				printf("Stuck at %c, can't continue!\n", i);
				i = 'Z'; // move out of loop bound
				break;
			}
		}
	}
}

// explode array
void explodeArray(char a[][SIZE]) {
	for (int i=0; i<SIZE; i++) {
		for (int j=0; j<SIZE; j++)
			printf("%c ", a[i][j]); // print char with space delimiter
		
		puts(""); // newline
	}
}

