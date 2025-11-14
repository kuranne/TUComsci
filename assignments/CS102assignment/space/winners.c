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
    n, i, j, count = 0;

    scanf("%d", &n);
    int *vec = (int*)calloc(n, sizeof(int));

    for (i = 0; i < n; i++)
        scanf("%d", &vec[i]);
    
    for (i = 0; i < n - 1; i++) 
        if (vec[i] >= vec[n - 1])
            count++;
            
    
    printf("%d\n%d\n", vec[n - 1], count);
    free(vec);
    return 0;
}