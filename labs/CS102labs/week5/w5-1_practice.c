#include <stdio.h>

int main(){
    int number[4];
    scanf("%d", number);
    for(int i = 1; i < 4; i++){
        number[i] = number[i-1] + 1;
        printf("%d\n", number[i]);
    }
    return 0;
}