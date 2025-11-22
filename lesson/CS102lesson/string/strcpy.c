#include <string.h>
#include <stdio.h>

int main() {
    char str[10] = "HELLO";    
    char str2[10];

    strcpy(str2, str);

    printf("%s\n%s\n", str, str2);
    return 0;
}