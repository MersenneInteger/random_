import java.util.Scanner;

public class Electricity {

    private double I; //current
    private double R; //resistance
    private double V; //voltage
    private double P; //power

    public Electricity(){}

    public void setCurrent(double c){


	System.out.println("Given the voltage and current, the resistance of the circuit is: ");
	
	I = c;
    }
    public double getCurrent(double r, double v){

	I = v/r;
	return I;
    }

    public void setResistance(double r){

	R = r;
    }

    public double getResistance(double i, double v){

	R = v/i;
	return R;
    }

    public void setVoltage(double v){

	V = v;
    }

    public double getVoltage(double i, double r){

	V = i * r;
	return V;
    }

    public void setPower(double p){

	P = p;
	
    }
    public double getPower(double i, double v){

	P = v * i;
	return P;
	
    }
    /*   public double getPower(double i, double r){

	P = (i * i) * r;
	return P;
    }
    public double getPower(double v, double r){

	P= (v * v)/ r;
	return P;
    }
    */

    public static void main(String[] args){

	Scanner kb = new Scanner(System.in);
	Electricity e = new Electricity();

	System.out.println("Given the voltage and current, the resistance of the circuit is: ");
	
	double i, v, r, p;

	System.out.println("Enter the number of ampheres to set the current.");
	i = kb.nextDouble();
	e.setCurrent(i);

	System.out.println("Enter the number volts to set the voltage.");
	v = kb.nextDouble();
	e.setVoltage(v);

	r = v/i;
	System.out.println("Given the voltage and current, the resistance of the circuit is: ");
	System.out.println(e.getResistance(i, v));



    }//end of main
}//end of class
