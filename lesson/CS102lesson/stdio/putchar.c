#include <stdio.h>

int lio() {
    char c = 'h';
    putc("c", stdout);
    return 0;
}

int main() {
    return lio();
}