#include <stdio.h>

int main(){
    int fsnum, scnum;
    printf("Please enter two integers: ");
    scanf("%d%d", &fsnum, &scnum);
        while(fsnum<scnum){
            if(fsnum%13==0){
                printf("%d\n", fsnum);
            }
            fsnum++;
        }
    while(fsnum>scnum){
            if(scnum%13==0){
                printf("%d\n", scnum);
            }
            scnum++;
        }
    
    
    return 0;
}