import java.util.Random;

public class BinarySearch{
    
    public static boolean binarySearch(int[] data, int target, int low, int high){
        
        if(low > high)
            return false;//empty array, exit method
        else {
            
            int mid = (low + high)/2; //finds midpoint in array
            if(target == data[mid]) //if mid is element searching for, return true
                return true;
            else if(target < data[mid]) //if target is less than element at mid
                return binarySearch(data, target, low, mid-1);//recursively call bS for 
            else                                            //lower portion of array
                return binarySearch(data, target, mid+1, high);//if target is greater than
        }                                                     //search upper portion of array
    }// end of binarySearch

    public static void insertionSort(int list[], int length){
    
        for(int j = 1; j < length; j++){ //start with second element
            int key = list[j]; //assign key to second
            int k = j -1; //assign k to first

            while(k >= 0 && key < list[k]){//k is not less than 0 and key is less than element
                                          //prior to it
                list[k+1] = list[k]; //switch so that first element takes place of second
                --k;//decrement k till while loop exits
            }
            list[k+1] = key;//k should be -1 so k is assigned to first element
        }
        
    }//end of insertionSort
    
    public static void fillArray(int list[], int size){
        
       Random rand = new Random();//create random obj
       rand.setSeed(System.currentTimeMillis());//set seed to current time in milliseconds

       for(int i = 0; i < size; i++)
           list[i] = rand.nextInt(100);//assign each index to a random number
        
    }//end of fillArray
    
    public static int sumArray(int list[], int size){
        
       if(size == 0)
           return 0;
        else
            return sumArray(list, size-1) + list[size-1];
        
    
    }//end of sumArray
    
    public static void reverseArray(int[] list, int low, int high){
        
        if(low < high){
            
            int temp = list[low];
            list[low] = list[high];
            list[high] = temp;

            reverseArray(list, low + 1, high -1);
        }    
    }//end of reverseArray
    public static void printArray(int[] list, int size){
        
        for(int i = 0; i < size; i++)
            System.out.print(" " + list[i]);
        
    }
    public static void main(String[] args){
        
        int size = 10;
        int[] list = new int[size];
        
        fillArray(list, size);//static call to fillArray

        for(int i =0; i < size; i++)
            System.out.print(" " + list[i]);//print
        System.out.println("\n");
        
        System.out.println("\nArray in reverse order: ");
        reverseArray(list, 0, 9);

        printArray(list, size);

        insertionSort(list, size);//static call to insertionSort
        System.out.println("Sorted: \n\n");
        printArray(list, size);
            
        if(binarySearch(list, 14, 0 ,10))//search for number 14 with index 0 being low
            System.out.println("\nFound");  //and 10 being high
        else
            System.out.println("\nElement not found.");
        
        System.out.println("\n\nSum of array: ");

        int sum = sumArray(list, size);
        System.out.println(sum);
        
        printArray(list, size);

    }//end of main     
}//end of class



