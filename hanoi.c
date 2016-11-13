#include <stdio.h>

void hanoi(int rings, int left, int middle, int right)
{
    if(rings <= 1)
        printf("Move 1 ring from tower %d to tower %d\n", left, middle);
    else
        {
            hanoi(rings -1, left, right, middle);
            printf("Move 1 ring from tower %d to tower %d\n", left, middle);

            hanoi(rings -1, right, middle, left);
        }
}
int main(int argc, char *argv[])
{   
    int rings, left = 1, middle = 2, right = 3;
    printf("How many rings?\n");
    scanf("%d", &rings);
    
    hanoi(rings, left, middle, right);

    return 0;
}
