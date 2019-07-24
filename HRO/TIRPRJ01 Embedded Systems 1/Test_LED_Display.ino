
int clockPin = 11; // 11 SH_CP
int loadPin = 12; // 12 ST_CP
int dataPin = 13; // 14 DS

int incomingByte;
int blaat = 0;

void setup()
{
    pinMode(loadPin, OUTPUT);
    pinMode(clockPin, OUTPUT);
    pinMode(dataPin, OUTPUT);
    
    Serial.begin(9600);
    Serial.println("Hello World!");
}

void loop()
{
    digitalWrite(loadPin, LOW);
    
    if (Serial.available() > 0)
    {
        incomingByte = Serial.read();
        Serial.println(String("Serial.read: ") + incomingByte + String(", ") + char(incomingByte));
        
        if (incomingByte == 48) // 0
        {
            shiftOut(dataPin, clockPin, MSBFIRST, blaat); // Digits
            shiftOut(dataPin, clockPin, LSBFIRST, B00000011); // Segments
        }
        else if (incomingByte == 49) // 1
        {
            shiftOut(dataPin, clockPin, MSBFIRST, blaat);
            shiftOut(dataPin, clockPin, LSBFIRST, B10011111);
        }
        else if (incomingByte == 50) // 2
        {
            shiftOut(dataPin, clockPin, MSBFIRST, blaat);
            shiftOut(dataPin, clockPin, LSBFIRST, B00100101);
        }
        else if (incomingByte == 51) // 3
        {
            shiftOut(dataPin, clockPin, MSBFIRST, blaat);
            shiftOut(dataPin, clockPin, LSBFIRST, B00001101);
        }
        else if (incomingByte == 52) // 4
        {
            shiftOut(dataPin, clockPin, MSBFIRST, blaat);
            shiftOut(dataPin, clockPin, LSBFIRST, B10011001);
        }
        else if (incomingByte == 53) // 5
        {
            shiftOut(dataPin, clockPin, MSBFIRST, blaat);
            shiftOut(dataPin, clockPin, LSBFIRST, B01001001);
        }
        else if (incomingByte == 54) // 6
        {
            shiftOut(dataPin, clockPin, MSBFIRST, blaat);
            shiftOut(dataPin, clockPin, LSBFIRST, B01000001);
        }
        else if (incomingByte == 55) // 7
        {
            shiftOut(dataPin, clockPin, MSBFIRST, blaat);
            shiftOut(dataPin, clockPin, LSBFIRST, B00011111);
        }
        else if (incomingByte == 56) // 8
        {
            shiftOut(dataPin, clockPin, MSBFIRST, blaat);
            shiftOut(dataPin, clockPin, LSBFIRST, B00000001);
        }
        else if (incomingByte == 57) // 9
        {
            shiftOut(dataPin, clockPin, MSBFIRST, blaat);
            shiftOut(dataPin, clockPin, LSBFIRST, B00001001);
        }
        else if (incomingByte == 65) // A
        {
            shiftOut(dataPin, clockPin, MSBFIRST, blaat); 
            shiftOut(dataPin, clockPin, LSBFIRST, B00010001); 
        }
        else if (incomingByte == 66) // b
        {
            shiftOut(dataPin, clockPin, MSBFIRST, blaat); 
            shiftOut(dataPin, clockPin, LSBFIRST, B11000001); 
        }
        else if (incomingByte == 67) // C
        {
            shiftOut(dataPin, clockPin, MSBFIRST, blaat); 
            shiftOut(dataPin, clockPin, LSBFIRST, B01100011); 
        }
        else if (incomingByte == 68) // d
        {
            shiftOut(dataPin, clockPin, MSBFIRST, blaat); 
            shiftOut(dataPin, clockPin, LSBFIRST, B10000101); 
        }
        else if (incomingByte == 69) // E
        {
            shiftOut(dataPin, clockPin, MSBFIRST, blaat); 
            shiftOut(dataPin, clockPin, LSBFIRST, B01100001); 
        }
        else if (incomingByte == 70) // F
        {
            shiftOut(dataPin, clockPin, MSBFIRST, blaat); 
            shiftOut(dataPin, clockPin, LSBFIRST, B01110001); 
        }
        else if (incomingByte == 71) // G
        {
            shiftOut(dataPin, clockPin, MSBFIRST, 0); 
            shiftOut(dataPin, clockPin, LSBFIRST, 0); 
        }
        else if (incomingByte == 72) // H
        {
            shiftOut(dataPin, clockPin, MSBFIRST, 255); 
            shiftOut(dataPin, clockPin, LSBFIRST, 0); 
        }
        else if (incomingByte == 97) // a
            blaat = 1; // D1
        else if (incomingByte == 98) // b
        {
            blaat = 2; // D2
        }
        else if (incomingByte == 99) // c
        {
            blaat = 4; // D3
        }
        else if (incomingByte == 100) // d
        {
            blaat = 8; // D4
        }
        else if (incomingByte == 101) // e
        {
            blaat = 15; // D1-4
        }
    }
	
    digitalWrite(loadPin, HIGH);
}

