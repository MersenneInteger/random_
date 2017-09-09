#include <stdio.h>
#include <stdbool.h>
#include <string.h>

int find_largest_rep(int a[], int s)
{
    int max;
    max = a[0];
    for(int i = 0; i < s; i++)
        if(max < a[i])
            max = a[i];
    for(int i = 0; i < s; i++)
        if(max == a[i])
            max = i;
    return max;
}

int main(int argc, char **argv) {

    long long int user_num;
    int digit;
    int rep_digit = -1;
    char str[100];
    const int MAX_SIZE = 15;
    bool valid_input = false;
    bool digit_repeated[MAX_SIZE] = {false};
    int rep_storage[MAX_SIZE] = {0};
    
    while(!valid_input){
        printf("Enter a number: ");
        scanf("%lli", &user_num);
        sprintf(str, "%lli", user_num);
        if(strlen(str) > 10){
            printf("The number you entered is too large\n");
            continue;
        }
        else
            valid_input = true;
    }

    while(user_num > 0) {
        digit = user_num % 10;
        if(digit_repeated[digit]) {
            rep_storage[digit] += 1;
            rep_digit = digit;
        }
        digit_repeated[digit] = true;
        user_num /= 10;
    }

    int max = find_largest_rep(rep_storage, MAX_SIZE);
    if(rep_digit != -1) {
        printf("Repeating digits: \n");
        for(int i = 0; i < MAX_SIZE; i++)
            if(rep_storage[i] != 0)
                printf("%d ", i);
        printf("\nMost repeated: %d\n", max);
        printf("Repeated %d times.\n", rep_storage[max]+1);
    }
    else
        printf("No repeating digits.\n");

    return 0;
}
