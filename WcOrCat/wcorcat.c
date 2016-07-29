#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(int argc, char *argv[]){
    
    char ch;     
    int count = 0;

    if(argc > 3){
        printf("Too many arguments, exiting");
        exit(EXIT_FAILURE);
    }

    FILE *file = fopen(argv[2], "r");
    if(file == NULL){
        printf("Error opening file");
        return 0;
    }

    if(!strcmp(argv[1],"wc")){ 
        
        //get number of lines and words
        int lines = 0, words = 1;
        while((ch = getc(file)) != EOF){
            if(ch == '\n')
               lines++;
            if(ch == ' ')
                words++;
        }

        //get file size in bytes
        fseek(file, 0, SEEK_END);
        int size = ftell(file);
        
        printf(" %d %d %d %s\n", lines, words, size, argv[2]);

    }
    else if (!strcmp(argv[1], "cat")){
        while((ch = getc(file)) != EOF) putchar(ch); 
        }
    else
        printf("Operation not found.");

    return 0;
}
