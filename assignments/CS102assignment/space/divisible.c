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
    int a, b, tmp, n, ans = 0, i;
    scanf("%d %d %d", &a, &b, &n);
    if (a > b) {
        tmp = a;
        a = b;
        b = tmp;
    }
    for (i = a; i <= b; i++) {
        if (i % n == 0) ans++;
    } printf("%d\n", ans);
    return 0;
}