#include <stdio.h>

int func(int n) {
    int result = 1;
    if (n % 2 != 0) n -= 1;
    if (n > 1) result *= n * func(n -2);
    return result;
}

int main() {
    int x, n;
    scanf("%d", &n);
    x = func(n);
    printf("%d\n", x);
    return 0;
}