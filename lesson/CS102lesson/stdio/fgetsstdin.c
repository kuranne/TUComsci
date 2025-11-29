#include <stdio.h>
#define BUFSIZE 100

int main() {
    char buf[BUFSIZE];
    fgets(buf, BUFSIZE, stdin);
    fclose(stdin); // ASM?
    fputs(buf, stdout);
    fclose(stdout);
    return 0;
}

/*
 Similar to
 int main() {
    char buf[BUFSIZE];
    scanf("%s", buf);
    printf("%s\n", buf);
    return 0;
 }

 But scanf() wouldn't read after <space> aka. 32 by default
*/