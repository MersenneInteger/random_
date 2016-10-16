public class Employee_Stack{
    
    //array to store Employee objects
    private Employee_Johnson[] data;
    private int top;
    private int size;
    
    //no arg constructor
    public Employee_Stack(){
        
        top = -1;
        size = 5;
        data = new Employee_Johnson[size];
    
    }
    //parameterized constructor, initialize to size n
    public Employee_Stack(int n){
        top = -1;
        size = n;
        data = new Employee_Johnson[n];
    }
    //add Employee node to stack
    public boolean push(Employee_Johnson newNode){
        if(top == size-1)
            return false;

        data[++top] = newNode;
        return true;

    }
    //remove Employee node to stack
    public Employee_Johnson pop(){
        if(top == -1)
            return null;
        int topLocation = top;
        top--;
        return data[topLocation];
    }
    //return Employee node without removing
    public Employee_Johnson peek(){
        if(top == -1)
            return null;

        return data[top];
    }
    //print all nodes in stack
    public void showAll(){
        for(int i = 0; i < size; i++)
            System.out.println(data[i].toString() + "\n--------\n");
    }
        
}//end of Employee_Stack_
