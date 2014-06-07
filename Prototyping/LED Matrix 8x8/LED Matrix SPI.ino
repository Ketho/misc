#include <SPI.h>

const int loadPin = 10; // chip select / slave select

// MAX7219 led display driver control registers
const int REG_DECODE_MODE = 0x9;
const int REG_INTENSITY = 0xA;
const int REG_SCAN_LIMIT = 0xB;
const int REG_SHUTDOWN = 0xC;
const int REG_DISPLAY_TEST = 0xF;

int matrices[][8][8] = {
	{ // 1 top
		{1, 1, 1, 1, 1, 1, 1, 1},
		{1, 1, 1, 1, 1, 1, 1, 1},
		{1, 1, 1, 1, 1, 1, 1, 1},
		{1, 1, 1, 1, 1, 1, 1, 1},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
	},
	{ // 2 bottom
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{1, 1, 1, 1, 1, 1, 1, 1},
		{1, 1, 1, 1, 1, 1, 1, 1},
		{1, 1, 1, 1, 1, 1, 1, 1},
		{1, 1, 1, 1, 1, 1, 1, 1},
	},
	{ // 3 left
		{1, 1, 1, 1, 0, 0, 0, 0},
		{1, 1, 1, 1, 0, 0, 0, 0},
		{1, 1, 1, 1, 0, 0, 0, 0},
		{1, 1, 1, 1, 0, 0, 0, 0},
		{1, 1, 1, 1, 0, 0, 0, 0},
		{1, 1, 1, 1, 0, 0, 0, 0},
		{1, 1, 1, 1, 0, 0, 0, 0},
		{1, 1, 1, 1, 0, 0, 0, 0},
	},
	{ // 4 right
		{0, 0, 0, 0, 1, 1, 1, 1},
		{0, 0, 0, 0, 1, 1, 1, 1},
		{0, 0, 0, 0, 1, 1, 1, 1},
		{0, 0, 0, 0, 1, 1, 1, 1},
		{0, 0, 0, 0, 1, 1, 1, 1},
		{0, 0, 0, 0, 1, 1, 1, 1},
		{0, 0, 0, 0, 1, 1, 1, 1},
		{0, 0, 0, 0, 1, 1, 1, 1},
	},
	{ // 5 block A
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 1, 1, 1, 1, 1, 1, 0},
		{0, 1, 0, 0, 0, 0, 1, 0},
		{0, 1, 0, 1, 1, 0, 1, 0},
		{0, 1, 0, 1, 1, 0, 1, 0},
		{0, 1, 0, 0, 0, 0, 1, 0},
		{0, 1, 1, 1, 1, 1, 1, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
	},
	{ // 6 block B
		{1, 1, 1, 1, 1, 1, 1, 1},
		{1, 0, 0, 0, 0, 0, 0, 1},
		{1, 0, 1, 1, 1, 1, 0, 1},
		{1, 0, 1, 0, 0, 1, 0, 1},
		{1, 0, 1, 0, 0, 1, 0, 1},
		{1, 0, 1, 1, 1, 1, 0, 1},
		{1, 0, 0, 0, 0, 0, 0, 1},
		{1, 1, 1, 1, 1, 1, 1, 1},
	},
	{ // 7 smile
		{0, 0, 1, 1, 1, 1, 0, 0},
		{0, 1, 0, 0, 0, 0, 1, 0},
		{1, 0, 1, 0, 0, 1, 0, 1},
		{1, 0, 0, 0, 0, 0, 0, 1},
		{1, 0, 1, 0, 0, 1, 0, 1},
		{1, 0, 0, 1, 1, 0, 0, 1},
		{0, 1, 0, 0, 0, 0, 1, 0},
		{0, 0, 1, 1, 1, 1, 0, 0},
	},
	{ // 8 raster A
		{1, 0, 1, 0, 1, 0, 1, 0},
		{0, 1, 0, 1, 0, 1, 0, 1},
		{1, 0, 1, 0, 1, 0, 1, 0},
		{0, 1, 0, 1, 0, 1, 0, 1},
		{1, 0, 1, 0, 1, 0, 1, 0},
		{0, 1, 0, 1, 0, 1, 0, 1},
		{1, 0, 1, 0, 1, 0, 1, 0},
		{0, 1, 0, 1, 0, 1, 0, 1},
	},
	{ // 9 raster b
		{0, 1, 0, 1, 0, 1, 0, 1},
		{1, 0, 1, 0, 1, 0, 1, 0},
		{0, 1, 0, 1, 0, 1, 0, 1},
		{1, 0, 1, 0, 1, 0, 1, 0},
		{0, 1, 0, 1, 0, 1, 0, 1},
		{1, 0, 1, 0, 1, 0, 1, 0},
		{0, 1, 0, 1, 0, 1, 0, 1},
		{1, 0, 1, 0, 1, 0, 1, 0},
	},
	
	{ // H
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 1, 0, 0, 0, 1, 0, 0},
		{0, 1, 0, 0, 0, 1, 0, 0},
		{0, 1, 0, 0, 0, 1, 0, 0},
		{0, 1, 1, 1, 1, 1, 0, 0},
		{0, 1, 0, 0, 0, 1, 0, 0},
		{0, 1, 0, 0, 0, 1, 0, 0},
		{0, 1, 0, 0, 0, 1, 0, 0},
	},
	{ // E
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 1, 1, 1, 1, 1, 0, 0},
		{0, 1, 0, 0, 0, 0, 0, 0},
		{0, 1, 0, 0, 0, 0, 0, 0},
		{0, 1, 1, 1, 1, 1, 0, 0},
		{0, 1, 0, 0, 0, 0, 0, 0},
		{0, 1, 0, 0, 0, 0, 0, 0},
		{0, 1, 1, 1, 1, 1, 0, 0},
	},
	{ // L
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 1, 0, 0, 0, 0, 0, 0},
		{0, 1, 0, 0, 0, 0, 0, 0},
		{0, 1, 0, 0, 0, 0, 0, 0},
		{0, 1, 0, 0, 0, 0, 0, 0},
		{0, 1, 0, 0, 0, 0, 0, 0},
		{0, 1, 0, 0, 0, 0, 0, 0},
		{0, 1, 1, 1, 1, 1, 0, 0},
	},
	{ // O
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 1, 1, 0, 0, 0},
		{0, 0, 1, 0, 0, 1, 0, 0},
		{0, 1, 0, 0, 0, 0, 1, 0},
		{0, 1, 0, 0, 0, 0, 1, 0},
		{0, 1, 0, 0, 0, 0, 1, 0},
		{0, 0, 1, 0, 0, 1, 0, 0},
		{0, 0, 0, 1, 1, 0, 0, 0},
	},
};

int bits[][8] = {
	{
		B11001100,
		B11001100,
		B00110011,
		B00110011,
		B11001100,
		B11001100,
		B00110011,
		B00110011,
	},
	{
		B11111111,
		B00000000,
		B11111111,
		B00000000,
		B11111111,
		B00000000,
		B11111111,
		B00000000,
	},
	{
		B10101010,
		B10101010,
		B10101010,
		B10101010,
		B10101010,
		B10101010,
		B10101010,
		B10101010,
	},
};

// not enough memory? with this the program doesnt seem to run
/*
#define CHAR_A { \
	{0, 0, 0, 0, 0, 0, 0, 0}, \
	{0, 0, 1, 1, 1, 1, 0, 0}, \
	{0, 1, 0, 0, 0, 0, 1, 0}, \
	{0, 1, 0, 0, 0, 0, 1, 0}, \
	{0, 1, 1, 1, 1, 1, 1, 0}, \
	{0, 1, 0, 0, 0, 0, 1, 0}, \
	{0, 1, 0, 0, 0, 0, 1, 0}, \
	{0, 1, 0, 0, 0, 0, 1, 0}, \
}

int chars[][8][8] = {CHAR_A};
*/

void setup()
{
	Serial.begin(9600);
	Serial.println("Hello World!");
	
	pinMode(loadPin, OUTPUT);
	
	SPI.begin();
	Write(REG_DECODE_MODE, 0x0, 100); // no decode for digits 7–0
	Write(REG_INTENSITY, 0x4, 100); // 9/32 duty cycle
	Write(REG_SCAN_LIMIT, 0x7, 100); // display digits 0 1 2 3 4 5 6 7
	Write(REG_SHUTDOWN, 0x1, 100); // normal operation
	Write(REG_DISPLAY_TEST, 0x0, 100); // normal operation
}

void loop()
{
	// show moving cols
	for (int col=1; col<=8; col++)
	{
		Write(col, (1<<8)-1, 50);
		Write(col, 0, 0); // set to low again or it persists
	}
	
	for (int col=8; col>=0; col--)
	{
		Write(col, (1<<8)-1, 50);
		Write(col, 0, 0);
	}
	
	// show moving rows
	for (int row=0; row<8; row++)
	{
		for (int col=1; col<=8; col++)
			Write(col, 1<<row, 0);
		
		delay(50);
	}
	
	for (int row=6; row>=0; row--)
	{
		for (int col=1; col<=8; col++)
			Write(col, 1<<row, 0);
		
		delay(50);
	}
	
	for (int i=0; i<20; i++)
		ShowRandomMatrix(50);
	
	for (int i=0; i<13; i++)
		ShowMatrix(matrices[i], 500);
	
	for (int i=0; i<3; i++)
		ShowBitMatrix(bits[i], 500);
	
	MoveTranslate(matrices[6], 100); // translate smile
	
	//ShowMatrix(chars[0], 500);
}

void Write(int address, int value, int delayTime)
{
	digitalWrite(loadPin, LOW);
	SPI.transfer(address); // first 8 bits (D15-D8)
	SPI.transfer(value); // last 8 bits (D7-D0)
	digitalWrite(loadPin, HIGH);
	delay(delayTime);
}


void ShowMatrix(int matrix[][8], int delayTime)
{
	for (int rol=0; rol<8; rol++)
	{
		int v = 0;
		
		for (int i=0; i<8; i++)
			if (matrix[rol][i]) // can change direction
				v += 1<<7-i;
		
		Write(rol+1, v, 0);
	}
	
	delay(delayTime);
}

void ShowRandomMatrix(int delayTime)
{
	for (int rol=0; rol<8; rol++)
	{
		int v = 0;
		
		for (int i=0; i<8; i++)
			if (rand()%2) // can change direction
				v += 1<<7-i;
		
		Write(rol+1, v, 0);
	}
	
	delay(delayTime);
}

void ShowBitMatrix(int bit[], int delayTime)
{
	for (int rol=0; rol<8; rol++)
		Write(rol+1, bit[rol], 0);
	
	delay(delayTime);
}

void MoveTranslate(int matrix[][8], int delayTime)
{
	for (int x=0; x<9; x++)
	{
		TranslateMatrix(x, matrix);
		delay(delayTime);
	}
	
	// can not go negative because of left bit shifting
	for (int x=7; x>=0; x--)
	{
		TranslateMatrix(x, matrix);
		delay(delayTime);
	}
}

void TranslateMatrix(int trans, int matrix[][8])
{
	for (int rol=0; rol<8; rol++)
	{
		int v = 0;
		
		for (int i=0; i<8; i++)
			if (matrix[rol][i]) // can change direction
				v += 1<<7-i+trans;
		
		Write(rol+1, v, 0);
	}
}

