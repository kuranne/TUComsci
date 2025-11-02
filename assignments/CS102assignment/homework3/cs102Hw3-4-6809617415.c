#include <stdio.h>
#include <stdlib.h>

int main() {
    int n, i, j, k;
    scanf("%d", &n);

    double *nums = (double*)calloc(n, sizeof(double));
    if (!nums) return 1;

    for (i = 0; i < n; i++) {
        scanf("%lf", (nums + i));
    }

    double *pnums = nums; 
    double min = *pnums, max = *pnums;
    short int imin = 0, imax = 0;

    for (i = 1; i < n; i++) {
        double *cur = nums + i;
        if (max < *cur) {
            max = *cur;
            imax = i;
        }
        if (min > *cur) {
            min = *cur;
            imin = i;
        }
    }

    printf("Maximum value: %10.2lf\nMinimum value: %10.2lf\nMaximum index: %10d\nMinimum index: %10d\n",
           max, min, imax, imin);

    double ave = 0.0;
    for (pnums = nums; pnums < nums + n; pnums++) {
        ave += *pnums;
    }
    ave /= n;
    printf("Average: %10.2lf\n", ave);

    printf("Reverse order: ");
    double *rev = nums + n - 1;
    for (; rev >= nums; rev--) {
        printf("%.2lf ", *rev);
    }
    printf("\n");

    printf("Above average list: ");
    for (rev = nums + n - 1; rev >= nums; rev--) {
        if (*rev > ave) {
            printf("%.2lf ", *rev);
        }
    }
    printf("\n");

    printf("Negative coordinates: ");
    double *used = (double*)calloc(n * n, sizeof(double));
    if (!used) return 1;

    for (i = 0; i < n; i++) {
        double *a = nums + i;
        for (j = 0; j < n; j++) {
            double *b = nums + j;
            if (*a != *b && *a < 0 && *b < 0) {
                int pass = 1;
                for (k = 0; k < n * n; k++) {
                    if (*a + *b == *(used + k)) {
                        pass = 0;
                        break;
                    }
                }
                if (pass) {
                    printf("(%.2lf, %.2lf), ", *a, *b);
                    *(used + (i * n + j)) = *a + *b;
                }
            }
        }
    }

    printf("\n");

    free(nums);
    free(used);
    return 0;
}