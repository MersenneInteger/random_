PROGRAM_NAME='MCP-108'
(***********************************************************)
(*          DEVICE NUMBER DEFINITIONS GO BELOW             *)
(***********************************************************)
DEFINE_DEVICE

dvMaster = 0:1:1;
dvKP = 5001:28:1;
dvDisplay = 5001:1:1;

(***********************************************************)
(*               CONSTANT DEFINITIONS GO BELOW             *)
(***********************************************************)
DEFINE_CONSTANT

volatile integer POW_ON_BTN = 7;
volatile integer POW_OFF_BTN = 8;

volatile integer HDMI_1_BTN = 1;
volatile integer HDMI_2_BTN = 2;
volatile integer VGA_BTN = 3;
volatile integer MUTE_BTN = 4;

volatile integer sourceBtns[] = {1, 2, 3};

char TV_POW_ON[] = {$50, $4f, $57, $52, $31, $20, $20, $20, $0D};
char TV_POW_OFF[] = {$50, $4f, $57, $52, $30, $20, $20, $20, $0D};
char WAKE_ON_RS232[] = {$52, $53, $50, $57, $31, $20, $20, $20, $0D};
char TV_MUTE_ON[] = {$4d, $55, $54, $45, $31, $20, $20, $20, $0D};
char TV_MUTE_OFF[] = {$4d, $55, $54, $45, $32, $20, $20, $20, $0D};
char TV_HDMI_1[] = {$49, $41, $56, $44, $31, $20, $20, $20, $0D};
char TV_VGA_1[] = {$78, $62, $20, $30, $31, $20, $36, $30, $0D};
char TV_POW_QUERY[] = {$50, $4f, $57, $52, $3f, $20, $20, $20, $0D};
char TV_MUTE_QUERY[] = {$4d, $55, $54, $45, $3f, $20, $20, $20, $0D};
char TV_ACK[] = {$4f, $4b}
char TV_NACK[] = {$45, $52, $52};

volatile char switchCmds[][] = {TV_HDMI_1, TV_VGA_1};
volatile integer keypadBtns[] = {1,2,3,4,5,6,7,8,11,12,13};

char volCmds[][255] =
{
	{$56, $4f, $4c, $4d, $31, $20, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $32, $20, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $33, $20, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $34, $20, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $35, $20, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $36, $20, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $37, $20, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $38, $20, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $39, $20, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $31, $30, $20, $20, $0D}, //10
	{$56, $4f, $4c, $4d, $31, $31, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $31, $32, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $31, $33, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $31, $34, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $31, $35, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $31, $36, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $31, $37, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $31, $38, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $31, $39, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $32, $30, $20, $20, $0D}, //20
	{$56, $4f, $4c, $4d, $32, $31, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $32, $32, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $32, $33, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $32, $34, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $32, $35, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $32, $36, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $32, $37, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $32, $38, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $32, $39, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $33, $30, $20, $20, $0D}, //30
	{$56, $4f, $4c, $4d, $33, $31, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $33, $32, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $33, $33, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $33, $34, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $33, $35, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $33, $36, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $33, $37, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $33, $38, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $33, $39, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $34, $30, $20, $20, $0D}, //40
	{$56, $4f, $4c, $4d, $34, $31, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $34, $32, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $34, $33, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $34, $34, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $34, $35, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $34, $36, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $34, $37, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $34, $38, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $34, $39, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $35, $30, $20, $20, $0D}, //50
	{$56, $4f, $4c, $4d, $35, $31, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $35, $32, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $35, $33, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $35, $34, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $35, $35, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $35, $36, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $35, $37, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $35, $38, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $35, $39, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $36, $30, $20, $20, $0D}, //60
	{$56, $4f, $4c, $4d, $36, $31, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $36, $32, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $36, $33, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $36, $34, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $36, $35, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $36, $36, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $36, $37, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $36, $38, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $36, $39, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $37, $30, $20, $20, $0D}, //70
	{$56, $4f, $4c, $4d, $37, $31, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $37, $32, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $37, $33, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $37, $34, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $37, $35, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $37, $36, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $37, $37, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $37, $38, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $37, $39, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $38, $30, $20, $20, $0D}, //80
	{$56, $4f, $4c, $4d, $38, $31, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $38, $32, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $38, $33, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $38, $34, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $38, $35, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $38, $36, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $38, $37, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $38, $38, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $38, $39, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $39, $30, $20, $20, $0D}, //90
	{$56, $4f, $4c, $4d, $39, $31, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $39, $32, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $39, $33, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $39, $34, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $39, $35, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $39, $36, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $39, $37, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $39, $38, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $39, $39, $20, $20, $0D},
	{$56, $4f, $4c, $4d, $31, $30, $30, $20, $0D} //100
};

(***********************************************************)
(*               VARIABLE DEFINITIONS GO BELOW             *)
(***********************************************************)
DEFINE_VARIABLE

volatile integer currentVolume;
non_volatile integer isMuted;
volatile integer pollCmd;

define_function integer scaleVolume(integer vol)
{
	local_var integer scaled_vol;
	if(vol > 0)
		scaled_vol = type_cast(vol / 2.55);
	else
		scaled_vol = 1
	return scaled_vol;
}
(***********************************************************)
(*                STARTUP CODE GOES BELOW                  *)
(***********************************************************)
DEFINE_START

(***********************************************************)
(*                THE EVENTS GO BELOW                      *)
(***********************************************************)
DEFINE_EVENT

data_event[dvDisplay]
{
	online:
	{
		send_command dvDisplay,'SET BAUD 9600,N,8,1 485 DISABLE';
		wait 100 {
			send_string dvDisplay, "WAKE_ON_RS232"; //wake up on rs232
		}
    }

	string:
	{
		char rxBuffer[255];
		rxBuffer = data.text;
		rxBuffer = left_string(rxBuffer, length_string(rxBuffer)-1);
		send_string dvMaster, "rxBuffer";
		
		if(find_string(rxBuffer, TV_NACK, 1))
			send_string dvMaster, "'Error parsing display fb: ', rxBuffer";
		else if(find_string(rxBuffer, TV_ACK, 1))
		{
			switch(pollCmd)
			{
				case 1: //power?
				{
					if(atoi(rxBuffer) == 31)
						on[dvKP, POW_ON_BTN];
					else
						off[dvKP, POW_ON_BTN];			
				}
				case 2: //mute?
				{
					if(atoi(rxBuffer) == 31)
						on[dvKP, MUTE_BTN];
					else
						off[dvKP, MUTE_BTN];
				}
			}
			pollCmd = 0;
		}
	}
}

button_event[dvKP, POW_ON_BTN]
{
	push:
	{
		pollCmd = 1;
		send_string dvDisplay, "TV_POW_ON";
		on[dvKP, POW_ON_BTN];
		wait 1 {
			send_string dvDisplay, "TV_POW_QUERY";
		}
	}
}

button_event[dvKP, POW_OFF_BTN]
{
	push:
	{
		stack_var integer i;
		pollCmd = 1;
		send_string dvDisplay, "TV_POW_OFF";
		wait 1 {
			send_string dvDisplay, "TV_POW_QUERY";
		}
		for(i = 1; i <= max_length_array(keypadBtns); i++)
			off[dvKP, i];
	}
}

button_event[dvKP, MUTE_BTN]
{
	push:
	{
		isMuted = !isMuted;
		pollCmd = 2;
		if(isMuted)
			send_string dvDisplay, "TV_MUTE_ON";
		else
			send_string dvDisplay, "TV_MUTE_OFF";	
		wait 1 {
			send_string dvDisplay, "TV_MUTE_QUERY";
		}
	}
}

button_event[dvKP, sourceBtns]
{
	push:
	{
		stack_var integer i;
		local_var integer lastSourceSelected;
		lastSourceSelected = get_last(sourceBtns);

		send_string dvDisplay, "switchCmds[lastSourceSelected]";
		for(i = 1; i <= max_length_array(sourceBtns); i++)
			off[sourceBtns[i]];
		on[sourceBtns[lastSourceSelected]];
	}
}

level_event[dvKP, 2]
{
	local_var char str[255];
    	currentVolume = type_cast(scaleVolume(level.value));
	str = volCmds[currentVolume];
	send_string dvDisplay, "str";
	send_level dvKP, 1, level.value; //send level to bargraph keypad
}

DEFINE_PROGRAM
