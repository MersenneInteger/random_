#include <stdio.h>
#include <stdlib.h>

int fibonacci(int number);

int main(int argc, char *argv[]){
        
    if(argc > 1){
        int num = atoi(argv[1]);
        printf("%dth fibonacci term: %d", num, fibonacci(num));
    }
    //print first ten terms in fibonacci sequence
    else
        for(int i = 1; i <= 10; i++)
            printf("%d ", fibonacci(i));
    
    return 0;    
}

int fibonacci(int number){
    
    if(number == 1 || number == 2)
        return 1;
    else
        return fibonacci(number -1) + fibonacci(number -2);
}
