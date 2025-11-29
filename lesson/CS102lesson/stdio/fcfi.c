#include <stdio.h>

int main() {
    fclose(stdin);
    char buf[100];
    scanf("%s", buf);
    printf("%s", buf);
    return 0;
}