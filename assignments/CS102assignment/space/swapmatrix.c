/*
LANG: C
COMPILER: WCB
*/
/*
NAME: WIRAKORN THANABAT
SID: 6809617415
*/

#include <stdio.h>
#include <stdlib.h>

int main() {
    int 
    **matrix,
    q[2][2],
    i, j, tmp, max
    ;

    if ((matrix = (int**)calloc(4, sizeof(int*))) == NULL) return 1;
    for (i = 0; i < 4; i++) {
        matrix[i] = (int*)calloc(5, sizeof(int));
        if (matrix[i] == NULL) {
            for (j = 0; j < i; j++) free(matrix[j]);
            free(matrix);
            return 1;
        }
    }
    
    for (i = 0; i < 4; i++) 
        for (j = 0; j < 5; j++)
            scanf("%d", &matrix[i][j]);
    for (i = 0; i < 2; i++)
        for (j = 0; j < 2; j++)
            scanf("%d", &q[i][j]);
    
    tmp = matrix[q[0][0]][q[0][1]];
    matrix[q[0][0]][q[0][1]] = matrix[q[1][0]][q[1][1]];
    matrix[q[1][0]][q[1][1]] = tmp;

    for (i = 0; i < 4; i++){
        max = matrix[i][0];
        for (j = 1; j < 5; j++) {
            if (max < matrix[i][j]) max = matrix[i][j];
        }
        printf("%d ", max);
    }
    printf("\n");

    for (i = 0; i < 4; i++)
        free(matrix[i]);
    free(matrix);
    return 0;
}