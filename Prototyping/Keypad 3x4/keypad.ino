// row
const int row[] = {2, 3, 4, 5};

// column
const int col[] = {6, 7, 8};

// vars
int btn[12];
int btnstate[12];

char remap[] = {
	'1',
	'2',
	'3',
	'4',
	'5',
	'6',
	'7',
	'8',
	'9',
	'*',
	'0',
	'#',
};

void setup()
{
	Serial.begin(9600); 
	Serial.println("Hello World!");
	
	for (int i=0; i<4; i++)
		pinMode(row[i], OUTPUT);
	
	for (int i=0; i<3; i++)
		pinMode(col[i], INPUT);
}

void loop()
{
	int n = 0;
	
	// read buttons
	for (int i=0; i<4; i++)
	{
		digitalWrite(row[i], HIGH);
		
		for (int j=0; j<3; j++)
		{
			btn[n] = digitalRead(col[j]);
			n++;
		}
		
		digitalWrite(row[i], LOW);
	}
	
	// compare button state changes
	for (int i=0; i<12; i++)
		if (btnstate[i] != btn[i] && btn[i])
			Serial.println(String("Pressed ") + remap[i]);
	
	// update button state
	for (int i=0; i<12; i++)
		btnstate[i] = btn[i];
	
	delay(10);
}

