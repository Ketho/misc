
#define F_CPU 16000000 // 16 MHz

#include <avr/io.h>
#include <avr/interrupt.h>
#include <util/delay.h>

void initTimer0();
void setFrequence(float freq, float *_ocr, int *_prescale);
void playNote(float freq, int dur);
void playTune();

#define NOTE_G 392
#define NOTE_F 349
#define NOTE_DS 311
#define NOTE_D 294

#define KORT 200
#define UIT 100

volatile int duration = 0;

int main(void) {
	DDRD |= 1<<PORTD5; // output OC0B
	initTimer0(); // initialize timer 0
	sei(); // enable global interrupts
	
	// play twice
	for (int i=0; i<2; i++)
		playTune();
}

void initTimer0() {
	// TC0 Control Register A
	TCCR0A |= 1<<WGM01; // Waveform Generation Mode: [010] = CTC (Clear Timer on Compare Match)
	TCCR0A |= 1<<COM0B0; // Toggle OC0B on compare match
	
	// Timer/Counter 0 Interrupt Mask Register
	TIMSK0 |= 1<<OCIE0B; // Output Compare B Match Interrupt Enable
}

// Timer/Counter0 Compare Match B
ISR(TIMER0_COMPB_vect) {
	if (!duration)
		TCCR0B = 0; // stop clock and sound
	else
		duration--; // decrement
}

// OCR = fclk / (f * 2 * N)
void setFrequence(float freq, float *_ocr, int *_prescale) {
	float ocr = F_CPU / (freq*(1<<7)); // 2 * 2^6
	int pre = 3; // Clock Select: [011] = clk / 64 (prescaler)
	
	if (ocr > 255) {
		// too big for ocr, change prescale
		ocr = F_CPU / (freq*(1<<9)); // 2 * 2^8
		pre = 4; // [100] = clk / 256
		
		if (ocr > 255) {
			ocr = F_CPU / (freq*(1<<11)); // 2 * 2^10
			pre = 5; // [101] = clk / 1024
		}
	}
	*_ocr = (int) ocr; // cast back to int
	*_prescale = pre;
}


void playNote(float freq, int dur) {
	float ocr = 0;
	int pre = 0;
	setFrequence(freq, &ocr, &pre); // pass by reference
	OCR0B = (int) ocr; // TC0 Output Compare Register B
	OCR0A = OCR0B; // update top to OCR0B register
	TCCR0B = pre; // TC0 Control Register B
	
	duration = dur;
	while (duration); // wait until duration is over
}

// beethoven
void playTune() {
	// G, G, G, DS
	for (int i=0; i<3; i++) {
		playNote(NOTE_G, KORT);
		_delay_ms(UIT);
	}
	playNote(NOTE_DS, 4 * KORT);
	_delay_ms(2 * UIT);
	
	// F, F, F, D
	for (int i=0; i<3; i++) {
		playNote(NOTE_F, KORT);
		_delay_ms(UIT);
	}
	playNote(NOTE_D, 4 * KORT);
	_delay_ms(2000);
}
