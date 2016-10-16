public class Employee_Queue{
    
    //array to store Employee objects
    private Employee_Johnson[] data;
    private int size;
    private int numOfNodes;
    private int front;
    private int rear;
    
    //no-arg constructor
    public Employee_Queue(){
    
        size = 5;
        numOfNodes = 0;
        front = 0; 
        rear = 0;
        data = new Employee_Johnson[size];
    
    }
    //parameterized constructor, initialize to size n
    public Employee_Queue(int n){
    
        size = n;
        numOfNodes = 0;
        front = 0; 
        rear = 0;
        data = new Employee_Johnson[n];
    
    }

    //add Employee node to queue
    public boolean enqueue(Employee_Johnson newNode){
        //check if queue is full
        if(numOfNodes == size)
            return false;
        
        numOfNodes++;
        data[rear] = newNode;
        rear = (rear +1) % size;
        return true;
    }
    //remove Employee node from queue
    public Employee_Johnson dequeue(){
            
        int frontLocation = front;
        if(numOfNodes == 0)
            return null;
        
        front = (front +1) %size;
        numOfNodes--;
        return data[frontLocation];
    }
    //return Employee node without removing
    public Employee_Johnson peek(){
        if(numOfNodes == 0)
            return null;
        return data[front];
    }
    //print all nodes in queue
    public void showAll(){
        for(int i = 0; i < numOfNodes; i++){
            System.out.println(data[i].toString() + "\n-------\n");
	    i = (i + 1) % size;
	}
    }
}//end of Employee_Queue
