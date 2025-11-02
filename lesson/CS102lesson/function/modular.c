#include <stdio.h>

int mod(int a, int b) {
    return a % b;
}

int main(){
    printf("%d", mod(981625, 10));
    return 0;
}