#include <stdio.h>

int main(){
    int i = 123;
    char *p = &i;
    printf("%d", *p);
    return 0;
}