#include <stdio.h>

int p(int x) {
    printf("%d\n", x);
    return (x > 0)?p(x - 1):0;
}

int main() {
    return p(20);
}