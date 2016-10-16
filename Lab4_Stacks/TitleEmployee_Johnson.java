public class TitleEmployee_Johnson extends Employee_Johnson{
    
    private String title;
    private double bonus;
    //no-arg constructor
    public TitleEmployee_Johnson(){}
    //parameterized constructor, initialize fields
    public TitleEmployee_Johnson(int id, String lastName, String firstName,
    				 String department, double salary,
				 String title, double bonus){
        
        super(id, lastName, firstName, department, salary);
        this.title = title;
        this.bonus = bonus;
    }
    
    //accessors and mutator methods

    public void setTitle(String title){
        this.title = title;        
    }
    public String getTitle(){
        return title;        
    }

    public void setBonus(double bonus){
        this.bonus = bonus;        
    }
    public double getBonus(){
        return bonus;        
    }

    public String toString(){
        
        String str = super.toString();
        String str2 = "\nTitle: " + title +
                      "\nBonus: " +  bonus;

        str.concat(str2);
        return str;
    }
        
}//end of TitleEmployee_Johnson
