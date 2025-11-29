#include <stdio.h>

int main() {
    short int arr[] = {100, 1000};
    int *ptr = (int*)arr;

    printf("%d", *ptr);

    return 0;
}