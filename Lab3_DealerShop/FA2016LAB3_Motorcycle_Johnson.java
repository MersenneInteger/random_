public class FA2016LAB3_Motorcycle_Johnson extends FA2016LAB3_Vehicle_Johnson{
    
    private boolean hasSideCar = false;

    public FA2016LAB3_Motorcycle_Johnson(int vinNumber, String color, String make,
                                    String model, int year, int numberOfPassengers,
                                    int numberOfDoors, boolean sideCar)
    {   
        super(vinNumber, color, make, model, year);
        hasSideCar = sideCar;

    }

    public void setHasSideCar(boolean val){
        hasSideCar = val;        
    }
    public String getHasSideCar(){
        if(hasSideCar)
            return "yes";
        else
            return "no";
    }

    public String toString(){
            
        String str = super.toString();
        String str2 = "Has side car: " + getHasSideCar();
        str.concat(str2);
        return str;
    }
}
