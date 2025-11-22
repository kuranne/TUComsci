#include <stdio.h>
#include <string.h>

int main() {
    unsigned int n;
    char buf[128] = "Hello World!";

    n = strlen(buf);

    printf("text: %s is have length: %u\n", buf, n);
    
    return 0;
}