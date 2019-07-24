
#include <avr/io.h>

int ButtonPressed(int id);

int i = 0; // led index
int led[10] = {
	PORTD0, PORTD1, PORTD2, PORTD3,
	PORTD4, PORTD5, PORTD6, PORTD7,
	PORTB0, PORTB1,
};

int btn[8][2] = {}; // use port number for indices

int main(void) {
	DDRB = 1<<PORTB0; // output B0: led
	DDRB |= 1<<PORTB1; // output B1: led
	DDRB |= 1<<PORTB5; // output B5: internal led
	
	DDRD = 0xFF; // output D: all leds
	
	int PB;
	PB = 1<<PORTB4; // custom button pullup register
	PB |= 1<<PORTB7; // stock button pullup register
	PORTB = PB;
	
	while (1) {
		if (btnPressed(PORTB4))
			i = i==0 ? 9 : i-1; // backward
		
		if (btnPressed(PORTB7))
			i = i==9 ? 0 : i+1; // forward
		
		if (i < 8) {
			PORTB = PB; // retain B ports 4 and 7
			PORTD = 1<<led[i]; // turn on respective D led
		}
		else {
			PORTB = PB | 1<<i-8; // turn on respective B led
			PORTD = 0; // all D leds off
		}
	}
}

// index 0 : current button state
// index 1 : previous button state
int btnPressed(int id) {
	int isPressed = 0;
	btn[id][0] = ~PINB & 1<<id;
	
	// only track keypress down
	if (btn[id][0] && btn[id][0] != btn[id][1])
		isPressed = 1;
	
	btn[id][1] = btn[id][0];
	return isPressed;
}

