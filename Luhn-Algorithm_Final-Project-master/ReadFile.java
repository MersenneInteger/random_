import java.io.*;
//import java.util.Scanner;
public class ReadFile{
	
	public static void main(String[] args) throws IOException{
    	
		Validation cc = new Validation();
    	
    	try{
    		BufferedReader in = new BufferedReader(new FileReader("cardNumbers.txt"));
    		String s;		
    		
    		while((s = in.readLine()) != null){
    			
    			Validation.getValidation(s);
        		
        		if(Validation.getValidity()==true)
        			Validation.getCardIssuer(s);
        			
        			Validation.checkValidity(); 
        		//}
        		//else
        			//Validation.checkValidity();

        		System.out.println(cc.getStr());
    		}
    		
    		in.close();
    	}catch(FileNotFoundException e){System.out.println("File not found");}	

    }//end of main
}//end of class
