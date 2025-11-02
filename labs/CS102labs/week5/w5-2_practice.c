#include <stdio.h>

int main(){
    for(int i = 1; i < 11; i++){
        printf("%-3d%-d\n", i, i*2);
    }
    return 0;
}