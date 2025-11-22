#include <stdio.h>

int main(){
    double f_tall, m_tall;

    printf("Enter the height of the mother (centimeters): ");
    scanf("%lf", &m_tall);
    printf("Enter the height of the father (centimeters): ");
    scanf("%lf", &f_tall);
    
    double ave_tall = (f_tall+m_tall) /2;
    
    printf("The possible height of the child is between %.2lf to %.2lf centimeters.\n", ave_tall - 13.5, ave_tall + 13.5);    
    return 0;
}