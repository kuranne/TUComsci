#include <stdio.h>

int main(){
    int seconds, minutes, hours;
    printf("Please enter the time in seconds: ");
    scanf("%d", &seconds);
    if(seconds<0){
        printf("Invalid Input");
        return 0;
    }

    minutes = seconds/60; hours = minutes/60;
    minutes%=60; seconds%=60;

    printf("The time is %d hour(s), %d minute(s), and %d second(s).\n", hours, minutes, seconds);
    return 0;
}