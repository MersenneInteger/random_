/* This program simulates the Collatz Conjecture
 * Let n be a postive integer, if n is even divide it by two,
 * if n is odd, multiply it by three and add one.
 * Repeating this process indefinitley, all positive numbers
 * will reach one. This conjecture remains unproven for all natural numbers. 
 */

#include <iostream>

int collatz(int n);

int main(){

    int num;
    char exit = 'y';

    do {

        std::cout << "Enter an integer" << std::endl;
        std::cin >> num;
             
        if(num == 1) //if number is 1, end process
            break;

        while(num <= 0){ 
 
           if(num < 1 && isdigit(num))//check input to verify its a number
               std::cout << "You entered a number less than 1. " << std::endl;
               
           else{ //if input is char, clear buffer 
               
               std::cout << "You must enter a number. " << std::endl;
               std::cin.clear();
               std::cin.ignore(100, '\n');
            }
           //retry until valid input 
           std::cout << "Enter an integer : " << std::endl;
           std::cin >> num;
           }
        //call collatz function using positive integer as arg
        collatz(num);
        
        //if input is any char other than y, loop ends
        std::cout << "Would you like to continue (y/n)? " << std::endl;
        std::cin >> exit;

   }while(exit == 'y');

    return 0;
}
int collatz(int n){
    
    int final;

    if(n % 2 == 0) //if even, divide by two
        n /= 2;
    else
        n = (n * 3) + 1;//if odd, multiply by three and add one
    
    std::cout << n << std::endl; //print process

    if(n==1) final = 1; //once one is reached, process ends
    else final = collatz(n); //recursively call collatz using new n as arg

    return final;
}
