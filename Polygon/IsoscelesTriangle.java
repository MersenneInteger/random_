public class IsoscelesTriangle extends Triangle{
    
    public IsoscelesTriangle(double b, double h){
    
        super(b, h);
        
    }
    public double area(double b, double h){
    
        double area = 0.5 * b * h;
        return area;
        
    }
    public double perimeter(double b, double h){
    
        double perimeter = b + b + h;
        return perimeter;
        
    } 
    
}
