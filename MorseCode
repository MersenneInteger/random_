import java.util.Scanner;

public class Morse{

  public int NUM_CHARS = 40;
  private String original;
  private String mcode = " ";
  private char[] regular =  {'a','b','c','d','e','f','g','h','i','j','k',
			       'l','m','n','o','p','q','r','s','t','u','v',
			       'w','x','y','z','1','2', '3','4','5','6','7',
			     '8','9','0', ' '};
    
  private String[] morse = {"._", "_...", "_._.","_..",".", ".._.", "_ _.",
			  "....","..", "._ _ _", "_._","._..","_ _", "_.",
			  "_ _ _", "._ _.","_ _._","._.","...","_",".._",
			  "..._","._ _","_.. _","_._ _","_ _..",//z-25
			  "._ _ _ _",".._ _ _","..._ _","...._",".....",
			  "_....","_ _...","_ _ _..","_ _ _ _.","_ _ _ _ _", " "};

  public Morse(String input){
	  
      char[] str = input.toCharArray(); //copy string passed into arg into char[]
      original = input;
      String str2;

      for(int i=0; i < input.length(); i++){
	  str2 = (toMorse(str[i])); //calls toMorse to evaluate each char in str
	  mcode = mcode.concat(str2) + " "; //concatenate each converted char into
	                                    //mcode
    }
  }
  public String toMorse(char ch){
      int pos = 0; //record position of ch in regular char[]
      for(int i =0; i <regular.length; i++){
	   if(ch == regular[i]) //if ch is found
	       pos = i; //return position
	  }
       return morse[pos]; //positon is correlated with parallel array morse
  }
  public String getMorseCode(){ return mcode;}
  public String getOriginal(){return original;}
    
}//end of class

public class MorseDriver{
   public static void main(String[] args){

    
      Scanner kb = new Scanner(System.in);
      System.out.println("Enter a string that will be converted to morse code :");
      String str = kb.nextLine();

      Morse codes = new Morse(str); //create Morse obj, pass str into arg to be evaluated
      //print original string and converted morse code
      System.out.println(codes.getOriginal() + ":\n" + codes.getMorseCode());
      
      kb.close();
   } //end of main
} //end of class
