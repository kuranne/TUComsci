#include <string.h>
#include <stdio.h>

int main() {
    char str[20] = "Hello World!";
    char str2[20] = "Hello World!";

    if (!strcmp(str, str2)) printf("both is same!\n");
    else printf("not the same text.\n");

    return 0;
}