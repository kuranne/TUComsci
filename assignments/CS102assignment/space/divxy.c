/*
LANG: C
COMPILER: WCB
*/
/*
NAME: WIRAKORN THANABAT
SID: 6809617415
*/

#include <stdio.h>

int main() {
    int
    i,
    x, y, tmp
    ;

    scanf("%d %d", &x, &y);
    if (x > y) {
        tmp = x;
        x = y;
        y = tmp;
    }

    tmp = 0;
    for (i = x; i <= y; i++) {
        if (y % i == 0) tmp++;
    }

    printf("%d\n", tmp);
    return 0;
}