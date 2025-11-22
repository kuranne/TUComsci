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
    int
    n, i, j, max, imax;

    scanf("%d" , &n);
    
    size_t
    size = n;

    int
    tmp,
    *vec,
    *rel
    ;

    if (!(vec = (int*)calloc(size, sizeof(int)))) return 1;

    for (i = 0; i < n; i++) {
        scanf("%d", &tmp);
        if (size < tmp + 2) {
            size = tmp + 2;
            if(!(rel = realloc(vec, size * sizeof(int)))) return 1;
            vec = rel;
        }
        (vec[tmp])++;
    }

    max = vec[0];
    for (i = 1; i < size; i++) {
        if (vec[i] >= max){ 
            max = vec[i];
            imax = i;
        }
    }

    printf("%d %d\n", imax, max);

    free(vec);
    return 0;
}