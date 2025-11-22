#include <stdio.h>
#define BUFSIZE 128

int main() {
    char buf[BUFSIZE];
    gets(buf);
    printf("%s", buf);

    return 0;
}