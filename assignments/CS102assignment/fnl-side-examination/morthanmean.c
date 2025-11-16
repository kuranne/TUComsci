/*
LANG: C
COMPILER: WCB
*/
/*
NAME: WIRAKORN THANABAT
SID: 6809617415
*/

#include <stdio.h>

double mean(double arry[], int n) {
    int i;
    double sum = 0;
    for (i = 0; i < n; i++)
        sum += arry[i];
    return sum / n;
}

int main() {
    int n, i, count = 0;
    scanf("%d", &n);
    {
        double arry[n], mn;

        for (i = 0; i < n; i++)
            scanf("%lf", &arry[i]);
        
        mn = mean(arry, n);
        for (i = 0; i < n; i++)
            if (arry[i] > mn)
                count++;
    }
    printf("%d\n", count);

    return 0;
}