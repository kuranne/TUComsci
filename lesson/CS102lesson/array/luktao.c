#include <stdio.h>

int main(){
    int arry[6][6], i, j;
    for (i = 0; i < 6; i++){
        for (j = 0; j < 6; j++){
            arry[i][j] = i + j + 2;
        }
    }
    
    for (i = 0; i < 6; i++){
        for (j = 0; j < 6; j++){
            printf("%3d", arry[i][j]);
        }
        printf("\n");
    }
    return 0;
}