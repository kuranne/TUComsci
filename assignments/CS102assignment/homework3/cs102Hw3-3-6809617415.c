#include <stdio.h>
#include <stdlib.h>

int main() {
    int n, i, j;
    scanf("%d", &n);
    int array_n[n][n];
    
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            scanf("%d", &array_n[i][j]);
        }
    }

    int ans = 0, sum = 0;
    { //X_|
        for (i = 0; i < n; i++) sum += array_n[0][i];
        for (i = 0; i < n; i++) ans += array_n[i][i];
        for (i = 0; i < n; i++) ans += array_n[n-i-1][i];
        for (j = 0; j < n; j++) {
            for (i = 0; i < n; i++) {
                ans += array_n[i][j];
            }
        }
        for (i = 0; i < n; i++){
            for (j = 0; j < n; j++){
                ans += array_n[i][j];
            }
        }
    }

    if(ans % sum == 0) {
        printf("This is a magic square!\n");
    } else{
        printf("This is NOT a magic square!\n");
    }

    return 0;
}