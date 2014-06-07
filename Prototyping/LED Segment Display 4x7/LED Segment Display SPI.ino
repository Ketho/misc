// BL-Q56C-43 segment display (common cathode)
// KW4-56NCLB-P segment display (common cathode)
// MAX7219 led display driver
#include <SPI.h>

const int loadPin = 10; // chip select / slave select

// MAX7219 led display driver control registers
const int REG_DECODE_MODE = 0x9;
const int REG_INTENSITY = 0xA;
const int REG_SCAN_LIMIT = 0xB;
const int REG_SHUTDOWN = 0xC;
const int REG_DISPLAY_TEST = 0xF;

String delimit = ", ";

// MSBFIRST
// A, B, C, D, E, F, G, DP
// colon dot ommitted for laziness
int number[] = {
    B11111100, // 0
    B01100000, // 1
    B11011010, // 2
    B11110010, // 3
    B01100110, // 4
    B10110110, // 5
    B10111110, // 6
    B11100000, // 7
    B11111110, // 8
    B11110110, // 9
};

void setup()
{
	Serial.begin(9600);
	Serial.println("Hello World!");
	
	pinMode(loadPin, OUTPUT);
	
	// initiate SPI and set registers
	SPI.begin();
	Write(REG_DECODE_MODE, 0x0); // no decode for digits 7–0
	Write(REG_INTENSITY, 0x4); // 9/32 duty cycle
	Write(REG_SCAN_LIMIT, 0x7); // display digits 0 1 2 3 4 5 6 7
	Write(REG_SHUTDOWN, 0x1); // normal operation
	Write(REG_DISPLAY_TEST, 0x0); // normal operation
}

void loop()
{
	for (int v=0; v<10000; v++)
	{
		// split up number into 4 variables
		int D4 = v % 10;
		int D3 = (v - D4) / 10 % 10;
		int D2 = (v - D3) / 100 % 10;
		int D1 = (v - D2) / 1000 % 10;
		
		Write(0x1, number[D1]);
		Write(0x2, number[D2]);
		Write(0x3, number[D3]);
		Write(0x4, number[D4]);
		
		Serial.println(v + delimit + D1 + delimit + D2 + delimit + D3 + delimit + D4);
		delay(10);
	}
}

void Write(int address, int value)
{
	digitalWrite(loadPin, LOW);
	SPI.transfer(address); // first 8 bits (D15-D8)
	SPI.transfer(value); // last 8 bits (D7-D0)
	digitalWrite(loadPin, HIGH);
}

