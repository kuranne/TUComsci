/*
LANG: C
COMPILER: WCB
*/
/*
NAME: WIRAKORN THANABAT
SID: 6809617415
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

int main() {
    int
    i, j, n
    ;
    
    scanf("%d", &n);
    
    int
    (*date)[2] = calloc(n, sizeof(int[0])),
    w, d, dt, tmp;
    ;
    if (date == NULL) return 1;

    for (i = 0; i < n; i++) {
        scanf("%d %d",&w, &d);
        dt = d;
        tmp = 0;
        if (dt > 9) {
            tmp += pow((double) (dt % 10), 4);
            dt /= 10;
        }
        tmp += pow((double) dt, 4);
        tmp *= w;
        if (tmp % 10 == 4)
            for (j = 0; j < n; j++)
                if (date[j][0] == 0) {
                    date[j][0] = w;
                    date[j][1] = d;
                    break;
                }
    }
    j = 0;
    for (i = 0; date[i][1] != 0; i++) {printf("%d %d\n", date[i][0], date[i][1]); j++;}
    if (j == 0) printf("0\n");
    free(date);
    return 0;
}