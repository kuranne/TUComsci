#include <stdio.h>

int main(){
    char the_n[5];
    int number = 0;
    scanf("%s", the_n);
    
    for(int i = 0; i < 5; i++){
        number += (int)the_n[i] - 48;
    }
    while(number > 9){
        int soad, numbers;
        for(int i=1; i <= number; i*=10){
            soad = i;
        }
        for(;soad > 1;soad/=10) {
            number += (number/soad)-(number/soad*10) ;
        }
    
    }

    printf("%d\n", number);
    return 0;
}