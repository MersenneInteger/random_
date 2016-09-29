public class FA2016LAB3_Car_Johnson extends FA2016LAB3_Vehicle_Johnson{
    
    private int numberOfPassengers;
    private int numberOfDoors;

    public FA2016LAB3_Car_Johnson(){}

    public FA2016LAB3_Car_Johnson(int vinNumber, String color, String make,
                                String model, int year, int numberOfPassengers,
                                int numberOfDoors)
    {   
        super(vinNumber, color, make, model, year);
        this.numberOfPassengers = numberOfPassengers;
        this.numberOfDoors = numberOfDoors;
            
    }

    public void setNumberOfPassengers(int passengers){
        numberOfPassengers = passengers;        
    }
    public int getNumberOfPassengers(){ return numberOfPassengers; }

    public void setNumberOfDoors(int doors){
        numberOfDoors = doors;        
    }
    public int getNumberOfDoors(){ return numberOfDoors; }
    
    public String toString(){
        
        String str = super.toString();
        String str2 = "\nNumber of Passengers: " + numberOfPassengers +
                      "\nNumber of Doors: " + numberOfDoors;
        str.concat(str2);
        return str;
            
    }
}
