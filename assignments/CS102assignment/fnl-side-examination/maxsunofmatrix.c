#include <stdio.h>
#include <stdlib.h>
#define s0 sum = 0;
#define mid (n+1)/2 - 1

void mws(int *max, int sum) {
    if (*max < sum) *max = sum;
}

int main() {
    int n, i, j, max, sum, sun, mean;
    scanf("%d", &n);
    int **matrix = (int**)calloc(n, sizeof(int*));
    if (! matrix) return 1;

    for (i = 0; i < n; i++) {
        matrix[i] = (int*)calloc(n, sizeof(int));
        if (! matrix[i]) return 1;
        for (j = 0; j < n; j++) scanf("%d", &matrix[i][j]);
    }

    // x
    {   
        s0
        for (i = 0; i < n; i++) sum += matrix[i][i]; // \ /
        mws(&max, sum);

        s0
        for (i = 0; i < n; i++) sum += matrix[i][n - i - 1]; // /
        mws(&max, sum);

        s0
        for (i = 0; i < n; i++) { // — |
            if (n % 2 == 0) {
                sum += (matrix[mid][i] + matrix[n/2][i])/2;
                sun += (matrix[i][mid] + matrix[i][n/2])/2;
            }
            else { 
                sum += matrix[mid][i]; 
                sun += matrix[i][mid];
            }
            if (sum < sun) sum = sun;
            if (max < sum) max = sum;
        }
    }

    printf("%d\n", max);

    for (i = 0; i < n; i++) free(matrix[i]);
    free(matrix);
    return 0;
}

#undef s0