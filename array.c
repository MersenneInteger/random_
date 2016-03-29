#include <stdio.h>
#include <string.h>
#define TRUE 1
#define FALSE 0

void printArray(int array[], int size);
int findLargest(int array[], int size);
int searchArray(int array[], int size, int n);
void swap_elements(int array[], int index1, int index2);
double get_avg(int a[], int size);
void bubble_sort(int array[], int size);
int nth_smallest(int array[], int size, int n);
void string_swap(char str[], int size);
void search_string(char str[], char c);
void insertion_sort(int array[], int size);
void merge_array(int a[], int s1, int b[], int s2);
void similar_array(int a[], int s1, int b[], int s2);


int main(){
    
    int size_a = 5, size_b = 2;
    int a[] = {2,4,7,1,3};
    int b[] = {6,9};

    merge_array(a, size_a, b, size_b);

/*

    int sizeB = 5;
    int b[] = {2,7,3,1,5};
    insertion_sort(b[], sizeB);

    printArray(b[], sizeB);


    char str[7] = "string";
    int size_of= strlen(str);
    string_swap(str, size_of);
    string_swap(str, size_of);

    char ch;
    printf("Enter a letter to search for in the string: ");
    scanf("%c", &ch);
    search_string(str, ch);


	int size, counter;
	printf("Enter the number of elements to put in an array: ");
	scanf("%d", &size);
	
	int a[size];

	printf("Enter the elements: ");
	for(int i =0; i < size; i++)
		scanf("%d", &a[i]); //get input from user

	printArray(a, size); //prints array	
	printf("\n\n");

    int max = findLargest(a, size); //store largest element in max
    printf("max: %d\n", max);

    int first, second;

    printf("Enter the index you want to swap: ");
    scanf("%d", &first);
    printf("Which index do you want to swap with? ");
    scanf("%d", &second);

    if (first >= size || second >= size)
        printf("Index out of range.\n");
    else 
	    swap_elements(a, 3, 2); //swaps elements at index
    
    printArray(a, size);

    int find; 
    printf("\nEnter the element you are searching for: ");
    scanf("%d", &find);
    
    searchArray(a, size, find); //search element for number 
    
    double avg = get_avg(a, size);
    printf("\n%f\n", avg);
*/

    return 0;

}
void printArray(int array[],int size){

	for(int i = 0; i < size; i++)
		printf("%d ", array[i]);

}

int findLargest(int array[], int size){
	
	int max;
    max = array[0]; //set first element as max
	for(int i =1; i < size; i++){
		if(max < array[i]){	//if another element is larger than max
			max = array[i]; //set new max
        }
	}
	return max; 
    
}

void swap_elements(int array[], int index1, int index2){

	int temp = array[index1]; 
	array[index1] = array[index2];
	array[index2] = temp;
}

int searchArray(int array[], int size, int n){
	
    int validity, index;
	for(int i = 0; i < size; i++){
		if(array[i] == n){ //if n is in array
			validity = TRUE; //array contains element
            index = i+1; //stores index where n is found
            break;
        }else
            validity = FALSE; //element not found
	} 

    if(validity)
        printf("found at index : %d\n", index);
    else
        printf("not found");

	return validity;
} //end of searchArray

double get_avg(int a[], int size){
    
    double sum = 0;
    for(int i = 0; i < size; i++){
               sum += a[i];
    }
    return sum/size;

}
			
void bubble_sort(int array[], int size){

    for(int i = 0; i<size; i++){
        for(int j = 0; j < size; j++){
            if(array[i] < array[j]){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }
}//end of bubble_sort	

void insertion_sort(int array[], int size){
    
    int i, j, k;    
    for(i = 1; i < size; i++){
    
        k = array[i]; //second element becomes k
        j = i -1; //first element becomes j

        while(j>=0 && k < array[j])//while j is >=0 and the second
        {                         //element(k) < first element(j)
            array[j+1] = array[j]; //put first element into second
            --j; //decrease j and exit loop
         }

         array[j+1] = k;//original second element becomes new first element
     } 

}//end insertion_sort

void string_swap(char str[], int size){
    
    int j = size;

    for(int i=0; j > i; i++, j--){
        char temp = str[i];
        str[i] = str[size - 1 - i];
        str[size-1-i] = temp;
    }   
    for(int i = 0; i<size; i++)
        printf("%c", str[i]);

    printf("\n");
}//end of string swap	

void search_string(char str[], char c){

    int validity, index;
    for(int i=0; i < strlen(str); i++){
        
        if(str[i] == c){
            validity = 1;
            index = i + 1;
            break;
        }
        else
            validity = 0;
    }
    
    if(validity == 1)
        printf("%c found at index: %d\n", c, index);
    else
        printf("%c not found in %s", c, str);
    
} //end of search_string
		
void merge_array(int a[], int s1, int b[], int s2){
    
    int size = s1+s2;
    int ab[size];

    for(int i = 0; i < s1; i++)
        ab[i] = a[i];

    for(int i = s1; i < size; i++)
        ab[i] = b[i-s1];

    for(int i = 0; i < size; i++)
        printf("%d ", ab[i]);
    
}//end merge_array



;


