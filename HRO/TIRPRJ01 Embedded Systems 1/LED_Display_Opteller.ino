// JY-5461BS segment display (common anode, at digits)
// 2x 74HC595 shift registers
int clockPin = 11; // 11 SH_CP
int loadPin = 12; // 12 ST_CP
int dataPin = 13; // 14 DS
String delimit = ", ";

// MSBFIRST
// A, B, C, D, E, F, G, DP
// inverse (because common anode)
int number[] = {
    B00000011, // 0
    B10011111, // 1
    B00100101, // 2
    B00001101, // 3
    B10011001, // 4
    B01001001, // 5
    B01000001, // 6
    B00011111, // 7
    B00000001, // 8
    B00001001, // 9
};

void setup()
{
    Serial.begin(9600);
    Serial.println("Hello World!");
	
    pinMode(clockPin, OUTPUT);
    pinMode(loadPin, OUTPUT);
    pinMode(dataPin, OUTPUT);
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
        
		// simulate multiplexing
        for (int i=0; i<2; i++)
        {
            Shift(B0001, number[D1], 5);
            Shift(B0010, number[D2], 5);
            Shift(B0100, number[D3], 5);
            Shift(B1000, number[D4], 5);
        }
        
        Serial.println(v + delimit + D1 + delimit + D2 + delimit + D3 + delimit + D4);
    }
}

void Shift(int digit, int segment, int delayTime)
{
    digitalWrite(loadPin, LOW);
    shiftOut(dataPin, clockPin, LSBFIRST, digit); // digits on second shift register, cathode
    shiftOut(dataPin, clockPin, MSBFIRST, segment); // segments on first shift register, anode
    digitalWrite(loadPin, HIGH);
    delay(delayTime);
}

