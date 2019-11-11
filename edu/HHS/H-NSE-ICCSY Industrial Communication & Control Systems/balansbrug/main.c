#define F_CPU 16000000 // 16 MHz

#include <stdlib.h>
#include <avr/io.h>
#include <util/delay.h>

void initSerial();
int receiveByte(void);
void writeByte(char c);
void writeString(char s[]);
void writeNumber(int v);
void writeNewline();

void SetLED(int enabled, int led);
void InitTimer();
void initADC();
int analogRead();
int PID(int feedback);

#define SERVO_PWR	1<<PORTB0
#define SERVO_PWM	1<<PORTB1
#define LED1		1<<PORTB3
#define LED2		1<<PORTB2
#define SW1			1<<PINB5
#define SW2			1<<PINB4

#define SERVO_CENTER	2775
#define SERVO_LEFT		4850
#define SERVO_RIGHT		800

#define PID_TARGET		236
#define PID_IN_P		3
#define PID_IN_I		.1
#define PID_IN_D		12

int iterPID = 0;

int main(void) {
	DDRB = SERVO_PWR | SERVO_PWM | LED1 | LED2; // set outputs
	PORTB = SERVO_PWR; // turn on servo

	initSerial();
	InitTimer();
	initADC();

	while (1) {
		_delay_ms(50); // smooth the PID process
		int button1 = ~PINB & SW1;
		int button2 = ~PINB & SW2;
		SetLED(button1, LED1);
		SetLED(button2, LED2);

		// left = 127 -> 417
		// center = 211 -> 236
		// right = 792 -> 57
		// max analog read voltage = 1023
		// factor from datasheet = .42
		// offset from experimenting = -30
		int distance = analogRead();
		float converted = (.42 * (1023.0 / (distance-30)) * 100);

		writeNumber(distance);
		writeString(", ");
		writeNumber(converted);
		writeString(" : ");

		PID(converted); // update PID
	}
}

void SetLED(int enabled, int led) {
	if (enabled)
		PORTB |= led; // turn on
	else
		PORTB &= ~led; // turn off
}

void InitTimer() {
	// Timer/Counter1: Mode 14 - Fast PWM, TOP = ICR1
	TCCR1A = 1<<WGM11;
	TCCR1B = 1<<WGM12 | 1<<WGM13;
	// Compare Output Mode: Clear OC1A on Compare Match, set at BOTTOM (non-invert)
	TCCR1A |= 1<<COM1A1;
	// servo has a period of 20 ms = 50 Hz -> ICR1 = F_CPU/50 = 320,000
	// ICR1 = 16000000/50/8 = 40,000 which is lower than 65,536
	TCCR1B |= 1<<CS11; // Clock Select: [010] = clk/8 prescaler
	ICR1 = 40000;
}

float errorSum, prevError;

// PID controller
int PID(int distance){
	int error = PID_TARGET - distance; // get error for D
	errorSum += error; // get sum of error for I
	// get P, I, D and output
	float outP = PID_IN_P * error;
	float outI = PID_IN_I * errorSum;
	float outD = PID_IN_D * (error-prevError);
	float output = (outP + outI + outD);

	OCR1A = (int)(SERVO_CENTER + output); // update angle for servo
	prevError = error; // update last error

	SetLED(OCR1A < SERVO_CENTER, LED1); // fancy lights
	SetLED(OCR1A > SERVO_CENTER, LED2);

	writeNumber(outP);
	writeString(", ");
	writeNumber(outI);
	writeString(", ");
	writeNumber(outD);
	writeString(" : ");
	writeNumber(errorSum);
	writeString(", ");
	writeNumber(output);
	writeNewline();
	
	iterPID++;
	return error;
}

// ADC
void initADC() {
	ADMUX = 0; // Sharp GP2Y0A41SK0F on ADC0
	ADCSRA = 1<<ADPS0 | 1<<ADPS1 | 1<<ADPS2; // Prescaler Select: [111] = 128
	ADCSRA |= 1<<ADEN; // ADC Enable
}

int analogRead() {
	ADCSRA |= 1<<ADSC; // ADC Start Conversion
	while (~ADCSRA & 1<<ADSC); // wait until conversion is ready
	return ADC;
}

// Serial
void initSerial() {
	UCSR0B = 1<<TXEN0; // Transmitter Enable 0: transmit to host
	UCSR0C |= 1<<UCSZ00; // USART Character Size: [011] = 8 data bits
	UCSR0C |= 1<<UCSZ01;
	UBRR0H = 0; // // 19.2k baud rate, 16 MHz
	UBRR0L = 103;
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
}

void writeNewline() {
	writeByte('\r');
	writeByte('\n');
}
