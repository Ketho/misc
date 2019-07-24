// input
const int input1 = 2;
const int input2 = 3;
const int input3 = 4;
const int input4 = 5;

// output 
const int output1 = 6;
const int output2 = 7;

// variables
int state1 = 0;
int state2 = 0;
int state3 = 0;
int state4 = 0;

String delimit = "\t";

void setup()
{
    pinMode(input1, INPUT);  
    pinMode(input2, INPUT);  
    pinMode(input3, INPUT);  
    pinMode(input4, INPUT);  
    
    pinMode(output1, OUTPUT);
    pinMode(output2, OUTPUT);
	
    Serial.begin(9600); 
    Serial.println("Hello World!");
}

void loop()
{
	digitalWrite(output2, LOW);
	digitalWrite(output1, HIGH);

	state1 = digitalRead(input1); // 1
	state2 = digitalRead(input2); // 2
	state3 = digitalRead(input3); // 3
	state4 = digitalRead(input4); // 4

	Serial.println(state1 + delimit + state2 + delimit + state3 + delimit + state4);

	digitalWrite(output2, HIGH);
	digitalWrite(output1, LOW);

	state1 = digitalRead(input1); // 5
	state2 = digitalRead(input2); // 6
	state3 = digitalRead(input3); // 7
	state4 = digitalRead(input4); // 8
	
	Serial.println(state1 + delimit + state2 + delimit + state3 + delimit + state4);

	delay(100);
}

