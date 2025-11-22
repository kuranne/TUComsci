#include <stdio.h>

 int main(){
    int arry[3][3], i, j;
    for (i = 0; i < 3; i++){
        for (j = 0; j < 3; j++){
            scanf("%d", &arry[i][j]);
        }
    }

    for (i = 0; i<3; i++){
        for(j = 0; j < 3; j++){
            printf("%d ", arry[i][j]);
        }
        printf("\n");
    }

    return 0;
 }