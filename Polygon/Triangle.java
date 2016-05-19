public abstract class Triangle implements Polygon{

    private double base;
    private double height;
        
    public Triangle(double b, double h){
    
        base = b;
        height = h;
    }
    public double area(){
    
        double area = 0.5 * base * height;
        return area;
        
    }
    public double perimeter(){
        
        double perimeter = base * 3;
        return perimeter;
        
    } 
    
}
