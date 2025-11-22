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
    int n, i, tmp, max;
    scanf("%d", &n);
    int a[n];
    for (i = 0; i < n; i++)
        scanf("%d", &a[i]);
    for (i = 0; i + 4 < n; i++) {
        tmp = a[i] + a[i+1] + a[i+2] + a[i+3] + a[i+4];
        if (i == 0) max = tmp;
        else if (max < tmp) max = tmp;
    }
    printf("%d\n", max);
    return 0;
}