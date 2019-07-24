
#define F_CPU 16000000

#include <stdlib.h>
#include <avr/io.h>
#include <avr/interrupt.h>
#include <util/delay.h>

void initInterrupt(void);
int receiveByte(void);
int receiveNumber(void);
void writeByte(char c);
void writeString(char s[]);
void writeNumber(int v);

// variables changed by interrupts
volatile int teller = 0;
volatile int isActive = 1;

int main(void) {
	// control and status register A
	UCSR0A = 0; // nothing needed to set
	
	// control and status register B
	UCSR0B = 1<<TXEN0; // transmit to host
	UCSR0B |= 1<<RXEN0; // receive from host
	UCSR0B |= 1<<RXCIE0; // receive interrupts from host
	
	// control and status register C
	UCSR0C = 1<<UCSZ01; // 7 data bits
	UCSR0C |= 1<<UPM01; // even parity
	// 1 stop bit by default
	
	// 19.2k baud rate, 16 MHz
	UBRR0H = 0; // baud rate register high
	UBRR0L = 103; // baud rate register low
	
	// data direction registers
	DDRB = 0;
	for (int i=PORTB0; i<=PORTB4; i++)
		DDRB |= 1<<i;
	
	PORTD |= 1<<PORTD3; // D3 pullup
	
	initInterrupt();
	writeString("main");
	
	while (1) {
		teller = receiveNumber(); // read a multi digit number
		writeNumber(teller); // show feedback

		sei(); // enable interrupts
		
		while (teller >= 0) {
			// if we set isActive to false we still want to stay in this while loop
			if (isActive) {
				PORTB = 1<<PORTB4 | teller;
				_delay_ms(100); // flash led B4
				
				PORTB &= teller; // show leds as binary representation
				_delay_ms(300);
				
				teller--; // count down
			}
		}
		
		cli(); // disable interrupts for next receiveNumber()
	}
}

void initInterrupt(void) {
	EIMSK |= 1<<INT1; // INT1 at port D3
	EICRA |= 1<<ISC11; // generate on falling edge (supposedly)
	writeString("initInterrupt");
}

// interrupt to change teller (single digit only)
ISR(USART_RX_vect) {
	teller = UDR0-'0'; // cast char to int
	teller++; // increment
	writeString("USART_RX");
}

// interrupt to pause teller
ISR(INT1_vect) {
	isActive = !isActive; // toggle
	UDR0; // prevent interrupt loop
	writeString("INT1");
}

int receiveByte(void) {
	while (~UCSR0A & 1<<RXC0); // receive complete
		return UDR0; // return data register 0
}

// read multiple chars (close with Enter) and convert to int
int receiveNumber(void) {
	char buf[8];
	int i = 0;
	
	while (1) { // prefer this over do-while loop
		char v = receiveByte();
		
		if (v == '\r') // carriage return (== 13)
			break;
		
		buf[i] = v;
		i++;
	}
	
	return atoi(buf); // convert string to int
}

void writeByte(char c) {
	while (~UCSR0A & 1<<UDRE0); // data register empty
		UDR0 = c; // set data register 0
}

void writeString(char s[]) {
	for (int i=0; s[i]!=0; i++)
		writeByte(s[i]);
	
	// newline
	writeByte('\r');
	writeByte('\n');
}

void writeNumber(int v) {
	char buf[8];
	itoa(v, buf, 10); // convert int to string
	writeString(buf);
}

