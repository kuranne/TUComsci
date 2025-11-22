#include <stdio.h>
#include <string.h>

int main() {
    char str[20] = "Hello";
    char str2[10] = " World!";
    
    strcat(str, str2);

    printf("%s\n", str);

    return 0;
}