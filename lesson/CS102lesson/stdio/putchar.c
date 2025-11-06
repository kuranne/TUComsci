#include <stdio.h>

int lio() {
    char c = 'h';
    putchar(c);
    putchar('h');
    putchar(2014);

    return 0;
}

int main() {
    int ret = 0;
    ret += lio();
    return ret;
}