import java.util.StringTokenizer;

public class SortingIntegerArray_Johnson{ 
    
    private int[] array;
    private int[] unsortedArray;

    public void getArray(String str){   
        
        //create StringTokenizer object and get # of tokens
        StringTokenizer st = new StringTokenizer(str);
        int size = st.countTokens();
        
        int list[] = new int[size];
        int counter = 0;
        while(st.hasMoreTokens()){ //convert String tokens to int
            list[counter] = Integer.parseInt(st.nextToken());
            counter++;
        } 
       //initialize fields
       array = new int[size];
       unsortedArray = new int[size];
       
       //copy list(int) to fields
       for(int i = 0; i < size; i++){
            array[i] = list[i];
            unsortedArray[i] = list[i];
       }
    
    }
    public void bubbleSort(String str){
        
        getArray(str);
        int temp;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                
                if(array[i] < array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }                   
        }
        //print
        System.out.println("Sorting method: BUBBLE SORT");
        printArray();
            
    }//end of bubble sort
    public void insertionSort(String str){
        
        getArray(str);
        int i, j, k;

        for(i = 1; i < array.length; i++){
                
            k = array[i];
            j = i -1;
            while(j >= 0 && k < array[j]){
                array[j+1] = array[j];
                --j;
            }
            array[j+1] = k;
        }
        System.out.println("Sorting method: INSERTION SORT");
        printArray();

    }// end of insertionSort 
    public void selectionSort(String str){
        
        getArray(str); 
        int i, j, minIndex;
        for(i = 0; i < array.length -1; i++){
            minIndex = i;
            for(j = i + 1; j < array.length; j++){
                if(array[j] < array[minIndex])
                    minIndex = j;
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        System.out.println("Sorting method: SELECTION SORT");
        printArray();
    
    }
    public void printArray(){

        System.out.print("Original list of numbers: ");
        for(int i = 0; i < array.length; i++)
            System.out.print(unsortedArray[i] + " "); 

        System.out.print("\nSorted list: ");
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i]+ " ");

        System.out.println("\n");
    }      
}
