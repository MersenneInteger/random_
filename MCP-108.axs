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

volatile char TV_POW_ON[] = 'POWR1   ';
volatile char TV_POW_OFF[] = 'POWR0   ';
volatile char WAKE_ON_RS232[] = 'RSPW1   ';
volatile char TV_VOL[] = 'VOLM';
volatile char TV_MUTE_ON[] = 'MUTE1   ';
volatile char TV_MUTE_OFF[] = 'MUTE2   ';
volatile char TV_HDMI_1[] = 'IAVD1   ';
volatile char TV_HDMI_2[] = 'IAVD2   ';
volatile char TV_VGA_1[] = 'IAVD6   ';
volatile char TV_POW_QUERY[] = 'POWR?   ';
volatile char TV_MUTE_QUERY[] = 'MUTE?   ';

volatile char switchCmds[][] = {TV_HDMI_1, TV_HDMI_2, TV_VGA_1};
volatile integer keypadBtns[] = {1,2,3,4,5,6,7,8,11,12,13};

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
	scaled_vol = vol / 4; //scale from 0-255 to 0-64
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
		wait 100 {
			send_string dvDisplay, "WAKE_ON_RS232, $0D";
		}
    }

	string:
	{
		char rxBuffer[255];
		rxBuffer = data.text;
		rxBuffer = left_string(rxBuffer, length_string(rxBuffer)-1);
		send_string dvMaster, "rxBuffer";
		
		if(find_string(rxBuffer, 'ERR', 1))
			send_string dvMaster, "'Error parsing display fb: ', rxBuffer";
		else if(find_string(rxBuffer, 'OK', 1))
		{
			switch(pollCmd)
			{
				case 1: //power?
				{
					if(atoi(rxBuffer) == 1)
						on[dvKP, POW_ON_BTN];
					else
						off[dvKP, POW_ON_BTN];			
				}
				case 2: //mute?
				{
					if(atoi(rxBuffer) == 1)
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
		send_string dvDisplay, "TV_POW_ON, $0D";
		wait 1 {
			send_string dvDisplay, "TV_POW_QUERY, $0D";
		}
	}
}

button_event[dvKP, POW_OFF_BTN]
{
	push:
	{
		stack_var integer i;
		pollCmd = 1;
		send_string dvDisplay, "TV_POW_OFF, $0D";
		wait 1 {
			send_string dvDisplay, "TV_POW_QUERY, $0D";
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
			send_string dvDisplay, "TV_MUTE_ON, $0D";
		else
			send_string dvDisplay, "TV_MUTE_OFF, $0D";
		wait 1 {
			send_string dvDisplay, "TV_MUTE_QUERY, $0D";
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

		send_string dvDisplay, "switchCmds[lastSourceSelected], $0D";
		for(i = 1; i <= max_length_array(sourceBtns); i++)
			off[sourceBtns[i]];
		on[sourceBtns[lastSourceSelected]];
	}
}

level_event[dvKP, 2]
{
	local_var char str[10];
    currentVolume = scaleVolume(level.value);

	if(currentVolume < 10)
		str = "TV_VOL, itoa(currentVolume),'   ',$0D";
	else
		str = "TV_VOL, itoa(currentVolume),'  ',$0D";

	send_string dvDisplay, "str";
	send_level dvKP, 1, level.value;
}

DEFINE_PROGRAM
