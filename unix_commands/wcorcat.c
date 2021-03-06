#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <dirent.h>
#include <errno.h>

extern int errno ;

int main(int argc, char *argv[]){
    
    char ch;     
    int count = 0, err;

    FILE *file = fopen(argv[2], "r");
    if(file == NULL){
        err = errno;    
        fprintf(stderr,"Error opening file: %s\n", strerror(err));
        exit(EXIT_FAILURE);
    }
    //cp command
    if (argc == 4 && (!strcmp(argv[1],"cp"))){
    
        FILE *copyFile = fopen(argv[3], "w");
        while((ch = getc(file)) != EOF)
            putc(ch, copyFile);
    }

    else if(argc > 3){
       perror("Too many arguments, exiting");
        exit(EXIT_FAILURE);
    }

    //wc command
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

    }//cat command
    else if (!strcmp(argv[1], "cat")){
        while((ch = getc(file)) != EOF) putchar(ch); 
    }

    //ls command
    else if (!strcmp(argv[1], "ls")){
        
        DIR *dir = opendir(argv[2]);
        struct dirent *folder;

        if(dir == NULL)
            perror("Error opening directory.");
    
        while((folder = readdir(dir)) != NULL && strcmp(folder->d_name,".")){
                if((strcmp(folder->d_name, "..")))  
                            printf("%s ", folder->d_name);
        }
        closedir(dir);    
    }
    else 
        perror("Operation not found.\n");

    return 0;
}//end of main
