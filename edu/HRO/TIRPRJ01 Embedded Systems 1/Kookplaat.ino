// Kitchen stove simulation
// with LEDs as heat elements
// http://www.youtube.com/watch?v=H0yskQJYYjU

// JY-5461BS segment display (common anode, at digits)
// 2x 74HC595 shift registers

    ///////////////
    /// Knoppen ///
    ///////////////

// rij
const int row1 = A4;
const int row2 = A5;

// kolom
const int col1 = A0;
const int col2 = A1;
const int col3 = A2;
const int col4 = A3;

// vars
int btn1;
int btn2;
int btn3;
int btn4;
int btn5;
int btn6;
int btn7;
int btn8;

int curButton; // throttle knopdruk

    ///////////////////
    /// LED Display ///
    ///////////////////

// Shift Register
const int clock = 11; // 11 SH_CP
const int latch = 12; // 12 ST_CP
const int data = 13; // 14 DS

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

// vars
int num1 = 0; 
int num2 = 0;
int num3 = 0;
int num4 = 0;

    //////////////////
    /// Kookplaten ///
    //////////////////

const int cookPin1 = 3;
const int cookPin2 = 5;
const int cookPin3 = 6;
const int cookPin4 = 9;

// vars
boolean cooker1;
boolean cooker2;
boolean cooker3;
boolean cooker4;

int curCooker;

int heat[] = {
    0,  // 0
    15, // 1
    30, // 2
    50, // 3
    80, // 4
    110, // 5
    140, // 6
    180, // 7
    220, // 8
    255, // 9
};

const int kinderslotLED = 2;
boolean kinderslot;
boolean kinderslotCheck;


const int speaker = 10;

boolean enabled; // aan/uit

void setup()
{
    Serial.begin(9600); 
    Serial.println("Hello World!");
	
    pinMode(col1, INPUT);
    pinMode(col2, INPUT);
    pinMode(col3, INPUT);
    pinMode(col4, INPUT);
    pinMode(row1, OUTPUT);
    pinMode(row2, OUTPUT);
    
    pinMode(clock, OUTPUT);
    pinMode(latch, OUTPUT);
    pinMode(data, OUTPUT);
    
    pinMode(speaker, OUTPUT);
}

void loop()
{ 
    // Serial Monitor
    int input;
    if (Serial.available() > 0) {input = Serial.read();}
    
    ///////////////
    /// Knoppen ///
    ///////////////
    
    // rij 1
    digitalWrite(row1, HIGH);

    btn1 = digitalRead(col1);
    btn2 = digitalRead(col2);
    btn3 = digitalRead(col3);
    btn4 = digitalRead(col4);
    digitalWrite(row1, LOW);
    
    // rij 2
    digitalWrite(row2, HIGH);
    btn5 = digitalRead(col1);
    btn6 = digitalRead(col2);
    btn7 = digitalRead(col3);
    btn8 = digitalRead(col4);
    digitalWrite(row2, LOW);
    
    if (kinderslot == false)
    {
        // throttle knopdruk (1)
        if (btn1 == 0 && curButton != 1) {ToggleCooker(cookPin1, cooker1); PlayTone(100, 500);}
        else if (btn2 == 0 && curButton != 2) {ToggleCooker(cookPin2, cooker2); PlayTone(100, 500);}
        else if (btn5 == 0 && curButton != 5) {ToggleCooker(cookPin3, cooker3); PlayTone(100, 500);}
        else if (btn6 == 0 && curButton != 6) {ToggleCooker(cookPin4, cooker4); PlayTone(100, 500);}
        
        else if (btn3 == 0 && curButton != 3) {AddNumber(); PlayTone(100, 1500);}
        else if (btn7 == 0 && curButton != 7) {SubNumber(); PlayTone(100, 200);}
        
        else if (btn4 == 0 && curButton != 4) // kinderslot
        {
            PlayTone(400, 1200);
            kinderslot = true;
            analogWrite(kinderslotLED, 255);
        }
        else if (btn8 == 0 && curButton != 8)
        {
            // toggle aan/uit
            if (enabled) {enabled = false; PlayTone(400, 200);}
            else {enabled = true; PlayTone(400, 800);}
        }
    }
    else if (btn4 == 0 && curButton != 4)
    {
        // kijk opnieuw na 10 seconden
        delay(2000);
        kinderslotCheck = true;
    }
    else if (kinderslotCheck == true && btn4 == 0)
    {
        kinderslotCheck = false;
        kinderslot = false;
        PlayTone(400, 1500);
        analogWrite(kinderslotLED, 0);
    }
    
    // throttle knopdruk (2)
    if (btn1 == 0) {curButton = 1;}
    else if (btn2 == 0) {curButton = 2;}
    else if (btn3 == 0) {curButton = 3;}
    else if (btn4 == 0) {curButton = 4;}
    else if (btn5 == 0) {curButton = 5;}
    else if (btn6 == 0) {curButton = 6;}
    else if (btn7 == 0) {curButton = 7;}
    else if (btn8 == 0) {curButton = 8;}
    else {curButton = 0;}
    
    ///////////////////
    /// LED Display ///
    ///////////////////
    
    if (enabled)
    {
        Shift(B0001, number[num1], cooker1 ? 10 : .5); // D1
        Shift(B0010, number[num2], cooker2 ? 10 : .5); // D2
        Shift(B0100, number[num3], cooker3 ? 10 : .5); // D3
        Shift(B1000, number[num4], cooker4 ? 10 : .5); // D4
    }
    else
    {
        // reset LED Display
        Shift(0, number[0], 4);
        
        // reset nummers
        num1 = 0;
        num2 = 0;
        num3 = 0;
        num4 = 0;
        
        // reset cookers
        for (int cookerId=6; cookerId<10; cookerId++)
        {
            analogWrite(cookerId, 0);
        }
    }
}

void ToggleCooker(int id, boolean &state)
{
    if (state)
    {
        analogWrite(id, 0);
        state = false;
        
        // reset vars
        if (id == cookPin1) {num1 = 0;}
        else if (id == cookPin2) {num2 = 0;}
        else if (id == cookPin3) {num3 = 0;}
        else if (id == cookPin4) {num4 = 0;}
        curCooker = 0;
    }
    else
    {  
        state = true;
        curCooker = id;
    }
}

void DimCooker(int id)
{
    if (id == cookPin1) {analogWrite(id, heat[num1]);}
    else if (id == cookPin2) {analogWrite(id, heat[num2]);}
    else if (id == cookPin3) {analogWrite(id, heat[num3]);}
    else if (id == cookPin4) {analogWrite(id, heat[num4]);}
}

void AddNumber()
{
    if (curCooker == cookPin1) {(num1 < 9) ? num1++ : false;}
    else if (curCooker == cookPin2) {(num2 < 9) ? num2++ : false;}
    else if (curCooker == cookPin3) {(num3 < 9) ? num3++ : false;}
    else if (curCooker == cookPin4) {(num4 < 9) ? num4++ : false;}
    DimCooker(curCooker);
}

void SubNumber()
{
    if (curCooker == cookPin1) {(num1 > 0) ? num1-- : false;}
    else if (curCooker == cookPin2) {(num2 > 0) ? num2-- : false;}
    else if (curCooker == cookPin3) {(num3 > 0) ? num3-- : false;}
    else if (curCooker == cookPin4) {(num4 > 0) ? num4-- : false;}
    DimCooker(curCooker);
}

void Shift(int digit, int segment, int delayTime)
{
    digitalWrite(latch, LOW);
    shiftOut(data, clock, MSBFIRST, digit);
    shiftOut(data, clock, LSBFIRST, segment);
    digitalWrite(latch, HIGH);
    delay(delayTime);
}

void PlayTone(long duration, int freq)
{
    duration *= 500;
    int period = (1.0 / freq) * 1000000;
    long elapsed_time = 0;
    
    while (elapsed_time < duration)
    {
        digitalWrite(speaker,HIGH);
        delayMicroseconds(period / 2);
        digitalWrite(speaker, LOW);
        delayMicroseconds(period / 2);
        elapsed_time += (period);
    }
}

