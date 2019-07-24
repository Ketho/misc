
#include <TimerOne.h>
#include <MultiFuncShield.h>

// game
int gameState;
int attempts;
boolean hasHighscore;

const int STATE_START = 1;
const int STATE_TOUCHWIRE = 2;
const int STATE_END = 3;

// time
float timer;
float curTime;
float startTime;
float fastestTime = 1e6;

// leds, buttons
const int led1 = 13;
const int led2 = 12;
const int led3 = 11;
const int led4 = 10;

const int button1 = A1;
const int button2 = A2;
const int button3 = A3;

int buttonState1;
int buttonState2;
int buttonState3;
int buttonPrevState1;
int buttonPrevState2;
int buttonPrevState3;

int buttonTime1;
int buttonTime2;
int buttonTime3;

// wire loop
const int wireGnd = A5; // ground
const int wire1 = 5; // start
const int wire2 = 6; // wire
const int wire3 = 9; // end

int wireState1;
int wireState2;
int wireState3;

void setup() {
  Serial.begin(9600);
  
  pinMode(led1, OUTPUT);
  pinMode(led2, OUTPUT);
  pinMode(led3, OUTPUT);
  pinMode(led4, OUTPUT);
  
  pinMode(button1, INPUT);
  pinMode(button2, INPUT);
  pinMode(button3, INPUT);

  pinMode(wireGnd, OUTPUT);
  pinMode(wire1, INPUT_PULLUP);
  pinMode(wire2, INPUT_PULLUP);
  pinMode(wire3, INPUT_PULLUP);
  
  Timer1.initialize();
  MFS.initialize(&Timer1);
}

void loop() {
  curTime = millis();
  
  buttonState1 = digitalRead(button1);
  buttonState2 = digitalRead(button2);
  buttonState3 = digitalRead(button3);

  wireState1 = digitalRead(wire1);
  wireState2 = digitalRead(wire2);
  wireState3 = digitalRead(wire3);

  Serial.println(wireState1);
  
  // started
  if ((buttonState1 == 0 && buttonPrevState1 == 1 && curTime > buttonTime1 + 100) || wireState1 == 0) {
    buttonTime1 = curTime; // avoid debounce
    
    if (gameState != STATE_START) {
      gameState = STATE_START; // start timer
      attempts++;
      showAttemptNumber(attempts);
      
      for (int i=3; i>0; i--) {
        MFS.write(i); // countdown
        delay(1000);
      }
      
      MFS.write("STRT"); // show START notification
      delay(1000);
      
      startTime = millis();
    }
  }

  // touched wire
  if ((buttonState2 == 0 && buttonPrevState2 == 1 && curTime > buttonTime2 + 100 && gameState == STATE_START) || wireState2 == 0) {
    buttonTime2 = curTime;
    gameState = STATE_TOUCHWIRE; // touched wire, reset timer
    MFS.beep();
    delay(1000);
    evaluateAttempts();
  }

  // finished
  if ((buttonState3 == 0 && buttonPrevState3 == 1 && curTime > buttonTime3 + 100 && gameState == STATE_START) || wireState3 == 0) {
    gameState = STATE_END; // unused
    buttonTime3 = curTime;
    hasHighscore = true;
    fastestTime = min(fastestTime, curTime - startTime); // update highscore
    evaluateAttempts();
  }

  // update button states to avoid debounce
  buttonPrevState1 = buttonState1;
  buttonPrevState2 = buttonState2;
  buttonPrevState3 = buttonState3;

  if (gameState == STATE_START)
    timer = (curTime - startTime) / 1000.00; // divide by float
  else if (gameState == STATE_TOUCHWIRE)
    timer = 0; // reset timer

  MFS.write(timer, timer < 100 ? 2 : 1); // show elapsed time in 2 decimals
}

void showAttemptNumber(int v) {
  digitalWrite(led1, v != 1);
  digitalWrite(led2, v != 2);
  digitalWrite(led3, v != 3);
}

void evaluateAttempts() {
  if (attempts == 3) {
    attempts = 0;
    gameState = 0;
    showAttemptNumber(attempts); // update reading
    delay(1000);

    if (hasHighscore) { // show high score
      hasHighscore = false;
      float highScore = fastestTime/1000.0;

      for (int i=0; i<5; i++) { // blink high score
        MFS.write(highScore, 2);
        delay(500);
        MFS.write(0);
        delay(50);
      }

      MFS.beep(); // success, beep twice
      delay(250);
      MFS.beep();

      fastestTime = 1e6; // reset
      timer = 0; // reset
      delay(3000);
    }
    else { // no successful attempts
      MFS.write("FAIL");
      delay(2000);
    }
  }
}

