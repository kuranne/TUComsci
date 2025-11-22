#include <stdlib.h>
#include <stdio.h>
#include <time.h>

int main(){
    srand(time(0));
    int rd = rand();
    printf("%d", rd%10);
    return 0;
}