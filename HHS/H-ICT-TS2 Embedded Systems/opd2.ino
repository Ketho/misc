// libraries
#include <TimerOne.h>
#include <MultiFuncShield.h>

// leds
const int LED1 = 13;
const int LED2 = 12;
const int LED3 = 11;
const int LED4 = 10;
const int BUTTON = A1;

int teller = 0;
int buttonState = 0;
int buttonTime = 0;
int prevState = 0;

char hexDigits[] = {
  '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
  'A', 'B', 'C', 'D', 'E', 'F',
};

void setup() {
  // set io pins
  pinMode(LED1, OUTPUT);
  pinMode(LED2, OUTPUT);
  pinMode(LED3, OUTPUT);
  pinMode(LED4, OUTPUT);
  pinMode(BUTTON, INPUT);

  // init libraries
  Timer1.initialize();
  MFS.initialize(&Timer1);

  randomSeed(analogRead(A5)); // set random seed
}

void loop() {
  int randomVal = random(1, 16);
  displayLEDs(randomVal);

  unsigned long initial = millis();
  unsigned long waitTime = initial + 2000;

  while (millis() < waitTime) {
    MFS.write(hexDigits[teller], 3);
    buttonState = digitalRead(BUTTON);

    if (buttonState == 0 && prevState == 1 && millis() > buttonTime + 100) {
      waitTime = millis() + 2000;
      buttonTime = millis(); // avoid debounce
      teller++; // pressed BUTTON

      if (teller > 15)
        teller = 0;
    }
    prevState = buttonState; // update state
  }

  if (teller != 0) { // BUTTON not yet pressed
    if (teller == randomVal)
      correctAnswer(initial);
    else
      wrongAnswer();
  }

  teller = 0; // reset
}

// led display, use bitwise AND operator
void displayLEDs(int v) {
  digitalWrite(LED1, !(v & B1));
  digitalWrite(LED2, !(v & B10));
  digitalWrite(LED3, !(v & B100));
  digitalWrite(LED4, !(v & B1000));
}

void correctAnswer(int startTime) {
  MFS.write("GOOD");
  delay(1000);

  //show time taken
  MFS.write((int) millis() - startTime);
  delay(3000);
}

void wrongAnswer() {
  MFS.write("BAD");
  delay(1000);
}

