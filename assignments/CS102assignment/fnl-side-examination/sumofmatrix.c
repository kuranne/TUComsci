/*
LANG: C
COMPILER: WCB
*/
/*
NAME: WIRAKORN THANABAT
SID: 6809617415
*/

#include <stdio.h>

int main() {
    int row, col, matrix[4][4], i, j, sum = 0;
    for (i = 0; i < 4; i++)
        for (j = 0; j < 4; j++)
            scanf("%d", &matrix[i][j]);
    scanf("%d %d", &row, &col);

    for (i = 0; i < 4; i++) {
        sum += matrix[row][i];
        sum += matrix[i][col];
    }

    printf("%d\n", sum);

    return 0;
}