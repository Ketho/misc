#include "project.h"
#include "subroutines.h"

//convert int to binary number
int dec2bcd(int v) 
{
	int num = 0;
	int leftshift = 0;
	
	while (v) {
		// add modulo 10 to get the remainder
		// shift left to get the bcd value of the 
		num += v%10 << leftshift;
		
		v /= 10; // divide by 10
		leftshift += 4; // update lshift bits
	}
	
	return num;
}
 
int main(void)
{
	init();

	uint8 lastcounterval=255u;
	unsigned int timerMaster =0;
	unsigned int timer=0;
	unsigned int send_msg_interval=40; //send message every 40 ms. 
	int running = 0; // timer state

	// bcd variables
	unsigned int seconds = 0;
	unsigned int minutes = 0;
	unsigned int hours = 0;
 
	for(;;)
	{
		//read 8bit ms counter,counting from 255 down to 0.
		uint8 ms_counter_val=ms_Counter_ReadCounter();
 
		//read buttons and switches
		uint8 buttons=LEDsAndSwitches_Inp3_0_Read();    //buttons
		uint8 sliders=LEDsAndSwitches_Inp7_4_Read();    //sliders
		uint8 rotarySwitch = Encoder_GetCounter();      //rotary
  
		//timing, calc timer ticks
		uint8 timer_tick=lastcounterval-ms_counter_val;
		if (timer_tick>128) timer_tick=256-timer_tick;
 
		//add timer ticks to timer
		timer=timer+timer_tick;
		timerMaster += timer_tick;
		lastcounterval=ms_counter_val;

		//Timer control
		if (buttons == 0B001) // SW1: start
			running = 1;
		else if (buttons == 0B010) // SW2: stop
			running = 0;
		else if (buttons == 0B100 && !running) { // SW3: reset, only when already stopped
			seconds = 0;
			minutes = 0;
			hours = 0;
		}

		//update screen master
		//LDQ_M284RI_Driver_DPReg_Write(0B00000100);
		//LDQ_M284RI_Driver_DataReg1_Write(rotarySwitch);
		//LDQ_M284RI_Driver_DataReg2_Write(dec2bcd(hours));
		//LDQ_M284RI_Driver_DataReg3_Write(dec2bcd(minutes));
		//LDQ_M284RI_Driver_DataReg4_Write(dec2bcd(seconds));

		//update timer values
		if (timerMaster > 1000 && running) {
			seconds++;
			timerMaster = 0;
	  
			if (seconds >= 60) {
				seconds = 0;
				minutes++;
			}
			if (minutes >= 60) {
				minutes = 0;
				hours++;
			}
		}

		//receive messages from message que. 
		CAN_Message msg;
		uint8 msg_available=receive(&msg);//check for message in que. 
		if (msg_available&&msg.id==0x08000001){//if message was transfered from queue
			LDQ_M284RI_Driver_DataReg1_Write(msg.data[0]);
			LDQ_M284RI_Driver_DataReg2_Write(msg.data[1]);
		}

		//send message every 40ms.
		if (timer>send_msg_interval){
			CAN_Message txmessage;
			txmessage.id=0x08000002; //mesage ID.             
			txmessage.rtr=0; //no remote transmission request.
			txmessage.ide=1; //extended can ID. 
			txmessage.dlc=6; //message length, 6 bytes. 

			txmessage.data[0]=(rotarySwitch);       // Segment 1
			txmessage.data[1]=dec2bcd(hours);       // Segment 2
			txmessage.data[2]=dec2bcd(minutes);     // Segment 3
			txmessage.data[3]=dec2bcd(seconds);     // Segment 4
			txmessage.data[4]=0B00000100;           // Segment dots
			txmessage.data[5]=buttons|(sliders<<4); // LEDs
 
			send(&txmessage);//send message
			timer=timer-send_msg_interval;//subtract intervaltime from timer. 
		}   
	}
}
