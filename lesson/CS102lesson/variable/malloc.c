#include <stdio.h>
#include <stdlib.h>

int main() {
    int *intarry = (int*)malloc(10*sizeof(int));
    printf("%d", (int)sizeof(intarry));
    return 0;
}