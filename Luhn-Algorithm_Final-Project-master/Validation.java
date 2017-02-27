import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Validation {
	
	private static String str;
	private static boolean valid = false;
	
	public Validation(){}

	public static void getValidation(String s) {
		
		setValidityFalse();
		long n = Long.parseLong(s);
		int i, j, sum = 0;
		long digit, lastDigit;
		int length = Long.toString(n).length();
		long[] list = new long[length];
		long[] dropLast = new long[length - 1];
		
		for (i = length - 1; i >= 0; i--) {
			digit = n % 10;
			list[i] = digit;
			n /= 10;
		}
		lastDigit = list[length - 1];
		// drop last digit by copying array to dropLast array
		for (i = 0; i < length - 1; i++)
			dropLast[i] = list[i];
		j = length - 1;
		// reverse digits
		for (i = 0; i <= j; i++, j--) {
			long temp = dropLast[j - 1];
			dropLast[j - 1] = dropLast[i];
			dropLast[i] = temp;
		}
		// multiple odd digits by 2
		for (i = 0; i < length - 1; i += 2) {
			long temp = dropLast[i];
			temp *= 2;
			if (temp > 9)
				temp -= 9;
			dropLast[i] = temp;
		}
		// add all numbers
		for (i = 0; i < length - 1; i++)
			sum += dropLast[i];
		// check digit
		if ((sum + lastDigit) % 10 == 0){
			setValidityTrue();
			getCardIssuer(s);
		}
		else
			setValidityFalse();
	}

	public static void getCardIssuer(String s) {
		
		str = s;
			

		
		if (str.length() == 14) {
			if (str.startsWith("36"))
				str = str.concat(" is a Diners Club-International card.");
			else
				str = str.concat(" is a Diners Club-Carte Blanche card.");
		}
		if (str.startsWith("3") && s.length() != 14) {
			if (str.length() == 15)
				str = str.concat(" is a American Express card.");
			else
				str = str.concat(" is a JCB card.");
		}// end of 3
		
		if (str.startsWith("4")) {
			if(str.startsWith("44")||str.startsWith("45"))
				str = str.concat(" is a Visa card.");
			else if(str.startsWith("48")||str.startsWith("49"))
				str = str.concat(" is a Visa Electron card.");
		} // end of 4
		
		if (str.startsWith("5")) {
			
			if(str.startsWith("51")||str.startsWith("53"))
				str = str.concat(" is a Master Card.");
			else if(str.startsWith("54")||str.startsWith("55"))
				str = str.concat(" is a Diners Club-North America card.");
			else if(str.startsWith("58"))
				str = str.concat(" is a Maestro card.");

		}//end of 5
		if (str.startsWith("6")) {

			if(str.startsWith("60"))
				str = str.concat(" is a Discover card.");
			else if(str.startsWith("67"))
				str = str.concat(" is a Laser card.");
			else
				str = str.concat(" is an InstaPayment card.");
			
			
		} // end of 6*/
	}// end of getCardIssuer

	public static void setValidityTrue() {
		valid = true;
	}

	public static void setValidityFalse() {
		valid = false;
	}

	public static boolean getValidity() {
		return valid;
	}

	public static void checkValidity() throws IOException{
		
		PrintWriter outValid;
		PrintWriter outInvalid;
		
		if(valid == true){

			try {
				outValid = new PrintWriter(new FileWriter("valid_cards.txt", true));
				outValid.write(str + "\n");
				outValid.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
			
			else {

				try {
					outInvalid = new PrintWriter(new FileWriter("invalid_cards.txt", true));
					outInvalid.write(str+ "\n");
					outInvalid.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
}//end of checkValidity

	public String getStr() {
		return str;
	}

	
}// end of class

