public class FA2016LAB3_VehicleUnsortedOptimizedArray_Johnson{
        
    private int size;
    private int next;
    private FA2016LAB3_Vehicle_Johnson[] data;

    public FA2016LAB3_VehicleUnsortedOptimizedArray_Johnson(){
            
        next = 0;
        size = 100;
        data = new FA2016LAB3_Vehicle_Johnson[size];
    } 

    public boolean insert(FA2016LAB3_Vehicle_Johnson newNode){
        
        if(next >= size)
            return false;
        data[next] = newNode.deepCopy();

        if(data[next] == null)
            return false;
        next++;
        return true;
    }

    public FA2016LAB3_Vehicle_Johnson fetch(String targetKey){
            
        FA2016LAB3_Vehicle_Johnson node;
        FA2016LAB3_Vehicle_Johnson temp;

        int i = 0;
        while(i < next && !(data[i].compareTo(targetKey) == 0)){ i++; }

        if(i == next)
            return null;
        node = data[i].deepCopy();

        if(i != 0){
            temp = data[i-1];
            data[i-1] = data[i];
            data[i] = temp;
        }
        return node;
    }
    public boolean delete(String targetKey){
            
        int i = 0;
        while(i < next && !(data[i].compareTo(targetKey) == 0)){ i++; }
        if(i == next)
            return false;

        data[i] = data[next-1];
        data[next-1] = null;
        next--;
        return true;

    }

    public boolean update(String targetKey, FA2016LAB3_Vehicle_Johnson newNode){
            
        if(delete(targetKey) == false)
            return false;
        else if(insert(newNode) == false)
            return false;
        else
            return true;
    }

   public void showAll(){
        for(int i = 0; i < next; i++){
            System.out.println(data[i].toString());        
        }       
    }

}//end of class
