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

int main() {
    int fal, cad, i, j, tmp, m, n, max = 0, imax, t;

    scanf("%d %d", &fal, &cad);

    int *vec = (int*)calloc(cad, sizeof(int));
    if (!(vec)) return 1;

    while (fal--) {
        t = cad;
        while (t--) {
            scanf("%d %d %d", &m, &n, &tmp);
            vec[n] += tmp;
            if (max < vec[n]) {
                max = vec[n];
                imax = n;
            }
        }
    }

    printf("%d\n%d\n", imax, max);

    free(vec);
    return 0;
}