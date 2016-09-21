import java.util.Scanner;

public class FA2016LAB2_SortingApplication_Johnson {
    
    public static void main(String[] args){
        
        int choice;
        String numberList; 
        Scanner kb = new Scanner(System.in);
        
        do{
            System.out.println("Choose a sorting method: " +
                                "\n1. Bubble Sort" +
                                "\n2. Insertion Sort" +
                                "\n3. Selection Sort" + 
                                "\n4. Exit");
            choice = kb.nextInt();
            kb.nextLine(); //clear buffer
            
            if(choice < 1 || choice > 4){ //if choice is out of range, restart loop
                System.out.println("Enter a number between 1-4\n\n");
                continue;    
            }
            else if(choice == 4){ //if choice is 4, exit loop
                System.out.println("Application terminating...");
                break;
            }

            System.out.println("Enter a list of numbers seperated by a space");
            numberList = kb.nextLine();

            SortingIntegerArray_Johnson list = new SortingIntegerArray_Johnson();
            System.out.println("---------------");

            if(choice == 1)
                list.bubbleSort(numberList);
            else if(choice == 2)
                list.insertionSort(numberList);
            else if(choice == 3)
                list.selectionSort(numberList);

            System.out.println("---------------"); 
        }while(choice != 4);
            
    }//end of main    
}//end of class
