public class Employee_Johnson{
            
    private int id;
    private String lastName;
    private String firstName;
    private String department;
    private double salary;
    
    //no-arg constructor
    public Employee_Johnson(){}
    //parameterized constructor, initialize fields
    public Employee_Johnson(int id, String lastName, String firstName,
    			   String department, double salary){
    	
    	this.id = id;
    	this.lastName = lastName;
    	this.firstName = firstName;
    	this.department = department;
    	this.salary = salary;
    	
    }
    //accessors and mutators
    
    public void setId(int id){ 
        this.id = id;
    }
    public int getId() { 
        return id;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return lastName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }

    public void setDepartment(String department){ 
        this.department = department;
    }
    public String getDepartment(){
        return department;
    }

    public void setSalary(double salary){
        this.salary = salary;        
    }
    public double getSalary(){
        return salary;        
    }

    //format class's fields in a string
   public String toString(){
        
        String str = "\nId:\t " + id + 
                    "\nLast Name: " + lastName +
                    "\nFirst Name: " + firstName +
                    "\nDepartment: " + department + 
                    "\nSalary: " + salary;
        return str;
    } 
}//end of Employee_Johnson
