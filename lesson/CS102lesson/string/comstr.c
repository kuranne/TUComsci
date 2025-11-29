#include <string.h>
#include <stdio.h>

int main() {
    char str[20] = "Hello";
    char str2[20] = "Hello World!";

    if (!strcmp(str, str2)) printf("both is same!\n");
    else printf("not the same text.\n");

    printf("%d\n", strcmp(str, str2));

    return 0;
}