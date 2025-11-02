#include <stdio.h>

int main(){
    int n;
    scanf("%d", &n);

    switch (n){
        case 0:
        case 1:
            printf("Truth");
            break;
        case 2:
            printf("Two");
        case 3:
            printf("Three");
            break;
        default:
            break;
    }

    return 0;
}