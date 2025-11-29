#include <stdio.h>

int main() {
    fclose(stdout);
    printf("Hello World\n");
    putc('H', stdout);
    return 0;
}