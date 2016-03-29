import java.util.Scanner;
public class Array{

    private final int size = 10;
    private int[] list = new int[size];

    public Array(){}
    
    public int getSize(){
	return size;
    }

    public void printArray(){
	for(int i = 0; i < size; i++)
	  System.out.print(list[i] + " ");	
    }

    public void initializeArray(){
	
	Scanner kb = new Scanner(System.in);
	
	for(int i = 0; i < size; i++)
	    list[i] = kb.nextInt();
    }
    public void bubbleSort(){
	int temp, i , j;

	for(i =0; i<size;i++){
	    for(j = 0; j < size -1; j++){
		if(list[i] < list[j]){
		    temp = list[i];
		    list[i] = list[j];
		    list[j] = temp;
		}
	    }
	}
    }

    public void insertionSort(){
	
	for(int i = 1; i < size; i++){
	    int cur = list[i];
	    int j = i;
	    while(j > 0 && list[j-1] > cur){
		list[j] = list[j-1];
		j--;
	    }
	    list[j] = cur;
	}
   }

    public static void main(String[] args){

	Array list = new Array();
	System.out.println("Enter 10 numbers to fill array.");
	
	list.initializeArray();
	list.printArray();

	System.out.println();
	
	list.insertionSort();
	list.printArray();

	
    }//end of main
}//end of class
