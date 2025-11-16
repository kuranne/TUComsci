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
    int row, col, i, j;
    scanf("%d %d", &row, &col);
    for (i = 0; i < row; i++) {
        for (j = 0; j < col; j ++) {
            printf("%c", (j % 2 == 0)?'@':'#');
        }
        printf("\n");
    }
    return 0;
}