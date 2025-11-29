#include <stdio.h>

typedef enum {
    january = 1,
    febuary,
    march,
    april,
    may,
    june,
    july,
    august,
    september,
    october,
    november,
    december
} Month;

int main() {
    Month month;
    int day;
    scanf("%i", &month);

    switch (month) {
        case january: case march: case may: july: case august: case october: case december:
            day = 31; break;
        case april: case june: case september: case november:
            day = 30; break;
        case febuary:
            day = 28; break;
        default:
            printf("NULL month number\n");
            day = 0;
            break;
    }

    if(day) {printf("The days in month %d is %d.\n", month, day);}

    return 0;
}