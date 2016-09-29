public class FA2016LAB3_Vehicle_Johnson {
	
	private String vinNumber;
	private String color;
	private String make;
	private String model;
	private int year;
	
	public FA2016LAB3_Vehicle_Johnson(){}
	public FA2016LAB3_Vehicle_Johnson(String vinNumber, String color, String make,
					String model, int year){
		
		this.vinNumber = vinNumber;
		this.color = color;
		this.make = make;
		this.model = model;
		this.year = year;
	}
	public String getVinNumber() {
		return vinNumber;
	}
	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

        public void moveForward(int distance){
	    System.out.println("Move forward " + distance + " miles.\n");
	}
        public void moveBackward(int distance){
	    System.out.println("Move backward " + distance + " miles.\n");
	}
        public void turnLeft(){System.out.println("Turning left.\n");}
        public void turnRight(){System.out.println("Turning right.\n");}
    
        public String toString(){
	    String str = "\nCar make: " + make +
		         "\nModel: " + model + 
                         "\nVIN: " + vinNumber +
		         "\nColor: " + color +
		         "\nYear: " + year;
	    return str;
        }
        public FA2016LAB3_Vehicle_Johnson deepCopy(){
	    FA2016LAB3_Vehicle_Johnson clone = new FA2016LAB3_Vehicle_Johnson(
					       vinNumber,color,
					       make, model, 
					       year);
	    return clone;
    }

    public int compareTo(String targetKey){
	return(vinNumber.compareTo(targetKey));
    }
}//end of class
