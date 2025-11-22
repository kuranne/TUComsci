#include <stdio.h>

void double_arry(int arry[], int size) {
    int i = 0;
    for (i = 0; i < size; i++) arry[i] *= i;
}

int main() {
    int a[3] = {2, 3, 4};
    int size = sizeof(a) / sizeof(int), i;
    double_arry(a, size);
    for (i = 0; i < size; i++) printf("%d\n", a[i]);

    return 0;
}