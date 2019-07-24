
#define F_CPU 16000000 // 16 MHz

#include <stdlib.h>
#include <avr/io.h>
#include <avr/interrupt.h>
#include <util/delay.h>

void initTimer1FastPWM_ICR();
void initTimer2FastPWM();
void dimLed(int value);
void pasPeriodeTijdTimer1Aan(int prescaler);

void initADC();
int readAD(int analogInput);

void initUsart();
int receiveByte(void);
void writeByte(char c);
void writeString(char s[]);
void writeNumber(int v);
void writeNewline();

volatile int direction = 0;
int periodetijden[] = {1, 2, 3, 4, 5}; // prescalers

int main(void) {
	DDRB |= 1<<PORTB1; // output OC1A (PB1), timer 1
	DDRD |= 1<<PORTD3; // output OC2B (PD3), timer 2
	
	initUsart(); // initialize serial communication
	initTimer1FastPWM_ICR(); // initialize timer 1
	initTimer2FastPWM(); // initialize timer 2
	initADC(); // initialize analog-to-digital converter
	sei(); // enable interrupts
	
	writeString("main");
	
	_delay_ms(1000);
	dimLed(255); // duty cycle 100%
	_delay_ms(1000);
	
	while (1) {
		int pmeter = readAD(PORTC5);
		pmeter /= 4;
		dimLed(pmeter);
		//writeNumber(pmeter);
	}
}

void initTimer1FastPWM_ICR() {
	writeString("initTimer1FastPWM_ICR");
	// TC1 Control Register A
	TCCR1A |= 1<<WGM11; // Waveform Generation Mode: [1110] = Fast PWM, TOP: ICR1
	TCCR1B |= 1<<WGM12;
	TCCR1B |= 1<<WGM13;
	TCCR1A |= 1<<COM1A1; // Clear OC1A on Compare Match, set OC1A at BOTTOM (non-inverting mode)
	
	// Timer/Counter 1 Interrupt Mask Register
	TIMSK1 |= 1<<ICIE1; // Input Capture Interrupt Enable
	TIMSK1 |= 1<<OCIE1A;//  Output Compare A Match Interrupt Enable
	
	// 0.238 Hz, duty cycle 50%; 16e6 / (2*1024*0.238) -1 = 127
	TCCR1B |= 1<<CS10; // TC1 Control Register B: Clock Select: [100] = clk / 256
	TCCR1B |= 1<<CS12;
	OCR1A = 255; // full duty cycle
	ICR1 = 1500; // Input Capture Register 1
}

ISR(TIMER1_CAPT_vect) {
	// turn on OC2B (PD3)
	DDRD |= 1<<PORTD3;
}

ISR(TIMER1_COMPA_vect) {
	// turn off OC2B (PD3)
	DDRD &= ~(1<<PORTD3);
}

void initTimer2FastPWM() {
	writeString("initTimer2FastPWM");
	// TC2 Control Register A
	TCCR2A |= 1<<WGM20; // Waveform Generation Mode: [011] = Fast PWM
	TCCR2A |= 1<<WGM21;
	TCCR2A |= 1<<COM2B1; // Clear OC2B (PD3) on compare match, set OC0B at BOTTOM, (non-inverting mode)
	
	// TC2 Control Register B
	TCCR2B |= 1<<CS21; // Clock Select: [010] = clk / 8
}

void dimLed(int value) {
	OCR2B = value; // set duty cycle
}

// update prescaler
void pasPeriodeTijdTimer1Aan(int prescaler) {
	writeNumber(prescaler);
	// TC1 Control Register B
	TCCR1B = prescaler; 
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
	
	writeNewline();
}

void writeNumber(int v) {
	char buf[16];
	itoa(v, buf, 10); // convert int to string
	writeString(buf);
}

void writeNewline() {
	writeByte('\r');
	writeByte('\n');
}

