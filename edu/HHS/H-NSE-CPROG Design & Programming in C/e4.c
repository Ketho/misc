
#include <stdio.h>

void explode(char s[]);
int findInString(char str[], char substr[]);

int size1 = 64;
// two character substring, including carriage return and zero termination
int size2 = 4;

int main() {
	// scan sentences
	char str1[size1];
	fgets(str1, size1, stdin); // read from stream
	
	char str2[size2];
	fgets(str2, size2, stdin);
	
	//explode(str1); // test printing char array elements
	
	// find any multiple instances of substring in string
	int count = findInString(str1, str2);
	printf("In de gegeven zin komt de combinatie '%s' %d keer voor.", str2, count);
}


void explode(char s[]) {
	// read until carriage return instead of zero termination
	for (int i = 0; *(s+i) != '\n'; i++)
		printf("%c\n", *(s+i));
}

int findInString(char str[], char substr[]) {
	int count = 0; // number of substring matches
	
	// iterate through string elements
	for (int i=0; *(str+i) != '\n'; i++) {
		if (*(str+i) == *substr) { // found a match with substring first element

			int match = 1; // boolean 
			// check if substring elements match with corresponding string element
			for (int j=0; *(substr+j) != '\n'; j++) {
				// a substring element didnt match
				if (*(str+i+j) != *(substr+j)) {
					match = 0;
					break;
				}
			}
			
			if (match == 1) // all substring elements matched, add to counter
				count++;
		}
	}
	return count;
}

