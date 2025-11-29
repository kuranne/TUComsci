#include <stdio.h>
#include <stdlib.h>

int main() {
    int n, i, j, sum, max = 0;
    scanf("%d", &n);
    int **matrix = (int**)calloc(n, sizeof(int*));
    for (i = 0; i < n; i++) matrix[i] = (int*)calloc(n, sizeof(int));

    for (i = 0; i < n; i++)
        for (j = 0; j < n; j++)
            scanf("%d", &matrix[i][j]);
    
    for (i = 0; i < n; i++) max += matrix[i][i];

    sum = 0;
    for (i = 0; i < n; i++) sum += matrix[i][n-i-1];
    if (max < sum) max = sum;

    sum = 0;
    for (i = 0; i < n; i++) {
        sum += matrix[i][n/2];
        if (n % 2 == 0) sum += matrix[i][(n/2)-1];
    }
    if (n%2 == 0) sum /= 2;
    if (max < sum) max = sum;

    sum = 0;
    for (i = 0; i < n; i++) {
        sum += matrix[n/2][i];
        if (n%2==0) sum += matrix[(n/2)-1][i];
    }
    if (n%2 == 0) sum /= 2;
    if (max < sum) max += sum;

    printf("%d\n", max);

    return 0;
}