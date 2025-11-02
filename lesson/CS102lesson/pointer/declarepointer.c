#include <stdio.h>

int main(){
    int *ptr, i = 1;
    ptr = &i;
    printf("%d\n", *ptr);
    return 0;
}