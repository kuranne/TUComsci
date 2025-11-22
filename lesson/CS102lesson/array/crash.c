#include <stdio.h>
#include <stdlib.h>

int main(){
    int num[5];
    for (int i = 0; i < 5 ; i++){num[i] = rand();}
    for (int i = 0; i < 10 && printf("%d\n", num[i]); i++);
    return 0;
}