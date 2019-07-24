
#define F_CPU 16000000 // 16 MHz

#include <stdlib.h>
#include <avr/io.h>
#include <avr/interrupt.h>
#include <util/delay.h>

void initTimer1();

void initADC();
int readAD(int analogInput);

void initUsart();
int receiveByte(void);
void writeByte(char c);
void writeString(char s[]);
void writeNumber(int v);
void writeNewline();

volatile char state = '1';
const int hz_one = (1<<16) - 15625; // 1 Hz (2^16 - 16M/1024/1) Hz; state '1'
const int hz_half = (1<<16) - 34286; // 0.5 Hz (2^16 - 16M/(1024*2)) Hz; state '2'

int main(void) {
	DDRB |= 1<<PORTB1; // output LED1
	DDRB |= 1<<PORTB4; // output LED4
	
	initUsart(); // initialize serial communication
	initADC(); // initialize analog-to-digital converter
	sei(); // enable interrupts
	initTimer1(); // initialize timer1
	
	while (1) {
		int pmeter = readAD(PORTC4);
		int light = readAD(PORTC5);

		writeByte(12); // clear terminal screen
		writeString("potmeter: ");
		writeNumber(pmeter);
		
		writeString("lichtsensor: ");
		writeNumber(light);
		
		if (light < pmeter)
			PORTB |= 1<<PORTB4; // turn LED4 on
		else
			PORTB &= ~(1<<PORTB4); // turn LED4 off
		
		_delay_ms(250);
	}
}

	/////////////
	//  Timer  //
	/////////////

void initTimer1() {
	// TC1 Control Register B
	TCCR1B |= 1<<CS10; //  Clock Select 1: [101] = clkI/O/1024 (From prescaler)
	TCCR1B |= 1<<CS12;
	
	// Timer/Counter 1 Interrupt Mask Register
	TIMSK1 = 1<<TOIE1; // Overflow Interrupt Enable
}

ISR(TIMER1_OVF_vect) {
	if (state == '1')
		TCNT1 = hz_one; // 1 Hz
	else if (state == '2')
		TCNT1 = hz_half; // 0.5 Hz
	
	PORTB ^= 1<<PORTB1; // toggle LED1
}

	///////////
	//  ADC  //
	///////////

void initADC() {
	// ADC Control and Status Register
	ADCSRA |= 1<<ADPS0; // ADC Prescaler Select: [111] = 128 (16 MHz / 128 = 125 KHz)
	ADCSRA |= 1<<ADPS1;
	ADCSRA |= 1<<ADPS2;
	ADCSRA |= 1<<ADEN; // ADC Enable
}

int readAD(int analogInput) {
	// ADC Multiplexer Selection Register
	ADMUX = 1<<REFS0; // Reference Selection: [01] = AVCC with external capacitor at AREF pin
	
	if (analogInput == 4) // Analog Channel Selection: [0100] = ADC4 (PC4)
		ADMUX |= 1<<MUX2;
	else if (analogInput == 5) { // Analog Channel Selection: [0101] = ADC5 (PC5)
		ADMUX |= 1<<MUX0;
		ADMUX |= 1<<MUX2;
	}
	
	ADCSRA |= 1<<ADSC; // ADC Start Conversion
	ADCSRA |= 1<<ADIF; // ADC Interrupt Flag
	
	int value = 0;
	
	while (~ADCSRA & 1<<ADIF);
		value = ADC; // read ADC in
	
	return value;
}

	/////////////
	//  USART  //
	/////////////

void initUsart() {
	// USART Control and Status Register 0 B
	UCSR0B = 1<<TXEN0; // Transmitter Enable 0: transmit to host
	UCSR0B |= 1<<RXEN0; // Receiver Enable 0: receive from host
	UCSR0B |= 1<<RXCIE0; // RX Complete Interrupt Enable 0: receive interrupts from host
	
	// USART Control and Status Register 0 C
	UCSR0C |= 1<<UCSZ00; // USART Character Size: [011] = 8 data bits
	UCSR0C |= 1<<UCSZ01;
	
	// 19.2k baud rate, 16 MHz
	UBRR0H = 0; // baud rate register high
	UBRR0L = 103; // baud rate register low
}

int receiveByte(void) {
	while (~UCSR0A & 1<<RXC0); // receive complete
		return UDR0; // return data register 0
}

void writeByte(char c) {
	while (~UCSR0A & 1<<UDRE0); // data register empty
		UDR0 = c; // set data register 0
}

void writeString(char s[]) {
	for (int i=0; s[i]!=0; i++)
		writeByte(s[i]);
}

void writeNumber(int v) {
	char buf[16];
	itoa(v, buf, 10); // convert int to string
	writeString(buf);
	writeNewline();
}

void writeNewline() {
	writeByte('\r');
	writeByte('\n');
}

// serial interrupt to change state
ISR(USART_RX_vect) {
	state = UDR0;
}

