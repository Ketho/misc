// libraries
#include <TimerOne.h>
#include <MultiFuncShield.h>

// button and leds
const int buttonPin = A1;
const int led1 = 13;
const int led2 = 12;
const int led3 = 11;
const int led4 = 10;

int buttonPushCounter = 0;   // number of button presses
int buttonState = 0;         // current state of button
int lastButtonState = 0;     // previous state of button

// this somehow works, char array pointer with double quotes 
char* hexDigits[] = {
  "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
  "A", "B", "C", "D", "E", "F",
};

void setup() {
  pinMode(buttonPin, INPUT);
  pinMode(led1, OUTPUT);
  pinMode(led2, OUTPUT);
  pinMode(led3, OUTPUT);
  pinMode(led4, OUTPUT);

  Timer1.initialize();
  MFS.initialize(&Timer1); // set up MFS

  Serial.begin(9600);
}

void loop() {
  // read the pushbutton input pin:
  buttonState = !digitalRead(buttonPin);

  // compare the buttonState to its previous state
  if (buttonState != lastButtonState) {
    // if the state has changed, increment the counter
    if (buttonState == HIGH) {
      // if the current state is HIGH then the button went from off to on:
      buttonPushCounter++;
      Serial.println("on");
      Serial.print("number of button pushes: ");
      Serial.println(buttonPushCounter);
    } else {
      Serial.println("off");
    }
    
    delay(50); // avoid bouncing
  }
  
  lastButtonState = buttonState; // update last button state

  // use bitwise AND operator
  digitalWrite(led1, !(buttonPushCounter & B1));
  digitalWrite(led2, !(buttonPushCounter & B10));
  digitalWrite(led3, !(buttonPushCounter & B100));
  digitalWrite(led4, !(buttonPushCounter & B1000));

  MFS.write(hexDigits[buttonPushCounter], 3); // position 3 digits to the right

  // reset counter at 16
  if (buttonPushCounter >= 16 )
    buttonPushCounter = 0;

}

