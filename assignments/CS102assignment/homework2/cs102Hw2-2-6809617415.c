#include <stdio.h>

int main(){
    int a,b,c;
    printf("Please enter length of each side of your triangle: ");
    scanf("%d%d%d", &a, &b, &c);

    if(a==b&&b==c&&c==a){
        printf("This is a equilateral triangle.\n");
        return 0;
    }
    if(a<=0||b<=0||c<=0||a+b<c||b+c<a||c+a<b){
        printf("This is NOT a possible triangle.\n");
        return 0;
    }else if(a!=b && b!=c && c!=a){
        printf("This is a scalene triangle.\n");
        return 0;
    }else{
        printf("This is a isosceles triangle.\n");
    }
    return 0;
}