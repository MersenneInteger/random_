#include <stdio.h>
#include <stdlib.h>

#define ONE_D   1
#define TWO_D   2
#define THREE_D 3
#define FOUR_D  4

void print_nxn_matrix(int sz, int mx[][sz])
{
    for(int row = 0; row < sz; row++) {
        for(int col = 0; col < sz; col++) {
            if(row != 0 && col % sz == 0)
                printf("\n");
            printf("%d ", mx[row][col]);
        }
    }
}

void add_matrices(int dim, int mx1[][dim], int mx2[][dim])
{

    int sum_mx[dim][dim];
    for(int row = 0; row < dim; row++)
        for(int col = 0; col < dim; col++)
            sum_mx[row][col] = mx1[row][col] + mx2[row][col];
    
    print_nxn_matrix(dim, sum_mx);
    printf("\n");
}

int trace(int dim, int mx[][dim])
{
    int trc = 0;
    for(int row = 0; row < dim; row++) 
        for(int col = 0; col < dim; col++) 
            if(row == col)
                trc += mx[row][col];
    return trc;
}

void swap(int dim, int mx[dim][dim], int i, int j)
{
    int tmp;
    tmp = mx[i][j];
    mx[i][j] = mx[j][i];
    mx[j][i] = tmp;
}

void transpose(int dim, int mx[][dim])
{
    int tmp;
    for(int row = 0; row < dim; row++)
        for(int col = 0; col < dim; col++)
            if(row > col) 
                swap(dim, mx, row, col);           
    print_nxn_matrix(dim, mx);
}

void scalar_mult(int k, int dim, int mx[][dim])
{
    for(int row = 0; row < dim; row++)
        for(int col = 0; col < dim; col++)
            mx[row][col] = k * mx[row][col];
    print_nxn_matrix(dim, mx);
}

int main(int argc, char **argv) {
  
   /* print trace of matrix */
   
    int matrix_size;
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
    print_nxn_matrix(matrix_size, matrix);
    printf("Trace of matrix: %d\n",trace(matrix_size, matrix));
    

    int mx1[TWO_D][TWO_D] = {{1, 1}, {1,1}};
    int mx2[TWO_D][TWO_D] = {{2, 2}, {2,2}};
    
    add_matrices(TWO_D, mx1, mx2);

    int mx3[THREE_D][THREE_D] = {{1,7,4},
				 {9,2,1},
				 {5,6,3}};
    transpose(THREE_D, mx3);
    scalar_mult(2, THREE_D, mx3);
    printf("trace of mx3: %d\n", trace(THREE_D, mx3);
    
    return 0;
}
