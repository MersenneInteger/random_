#include <stdio.h>

int main(int argc, char **argv) {
  
   /* print trace of matrix */
   
    int matrix_size;
    int trace = 0;
    printf("Enter number of row and columns for the matrix: ");
    scanf("%d", &matrix_size);
    int matrix[matrix_size][matrix_size];
    printf("Enter the elements: ");
    for(int row = 0; row < matrix_size; row++) {
        for(int col = 0; col < matrix_size; col++) {
            printf("\n[%d][%d] = ", row, col);
            scanf("%d", &matrix[row][col]);
        }
    }
    printf("Your matrix: \n");
    for(int row = 0; row < matrix_size; row++) {
        for(int col = 0; col < matrix_size; col++) {
            if(row != 0 && col % matrix_size == 0) 
                printf("\n");
            printf("%d ", matrix[row][col]);
            if(row == col)
                trace += matrix[row][col];
        }
    }
    printf("\nTrace of matrix: %d\n", trace);

    return 0;
}
