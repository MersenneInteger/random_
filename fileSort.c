#include <stdio.h>
#include <stdlib.h>

void bubbleSort(int k[], int num);

int main(int argc, char *argv[]){

  //create FILE pointer, open file to read
  FILE *file = fopen("numberSort.txt", "r+");
  int i, j, num, n;

  //if file does not exist, create one
  if(file == NULL) {
    file = fopen("numberSort.txt", "w");

    printf("How many numbers would you like to sort: \n");
    scanf("%d", &num);
    
    int k[num+1];

    // displays unsorted numbers in file for reference
    fprintf(file, "%s", "\nold data : ");
    printf("\nPlease enter %d numbers: ", num);

    //copy user entered numbers into array k, print as entered to file
    for(i = 0; i < num; i++){
      scanf("%d", &n);
      k[i] = n;
      fprintf(file, "%d ", n);
    }

    //call bubbleSort function
    //@param int k as array to be sorted and num as size of array
     bubbleSort(k, num);

    fprintf(file, "%s", "\nSorted : ");

    //print sorted data to file and terminal for confirmation
    for(i = 0; i < num; i++){
      fprintf(file, "%d ", k[i]);
      printf("%d ", k[i]);
    }

    //close numberSort
    fclose(file);

  }else{

    //declare k as a pointer variable to later be used as array
    //considering, at the time of declaration, the number of contents
    //in the file is unknown
    int *k;

    //num acts as counter to determine total numbers in file to sort
    num = 0;
    i = 0;

    //reads in data from file and stores in k
    while(fscanf(file, "%d", &k[i])==1){
      i++;
      num++;
    }

    //array is created and total number of contents is determined
    //call bubbleSort
    bubbleSort(k, num);
    
    fprintf(file, "%s", "\nSorted : ");
    
    for(i = 0; i < num; i++){
      fprintf(file, "%d ", k[i]);
      printf("%d ", k[i]);
    }
    
    fclose(file);
  } //end of else block
  
  return 0;
}
void bubbleSort(int k[], int num){
      int i, j;
      
       for(i = 0; i < num; i++){
	for(j = 0; j < num; j++){
	  if(k[i] < k[j]){
	    int temp = k[i];
	    k[i] = k[j];
	    k[j] = temp;
	  }
	}
      }
}
