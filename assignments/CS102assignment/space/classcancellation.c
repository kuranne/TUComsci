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
    int n, ps, late, i, pass = 0, stu;
    scanf("%d %d %d", &n, &ps, &late);
    for (i = 0; i < n; i++) {
        scanf("%d", &stu);
        if (stu <= late) pass++;
    }
    printf("%d\n%d\n", (pass * 100 / n >= ps)? 1: 0, n - pass);
    return 0;
}