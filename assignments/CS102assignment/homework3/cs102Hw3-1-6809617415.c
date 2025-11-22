#include <stdio.h>
#include <stdlib.h>

int main() {
    int n, i, j, k;
    scanf("%d", &n); 
    double *nums = (double*)calloc(n, sizeof(double));
    
    for (i = 0; i < n; i++){
        scanf("%lf", &nums[i]);
    }

    double min = nums[0], max = nums[0];
    short int imin = 0, imax = 0;
    
    for (i = 1; i < n; i++) {
        if (max < nums[i]) {
            max = nums[i];
            imax = i;
        }
        if (min > nums[i]) {
            min = nums[i];
            imin = i;
        }
    }

    printf("Maximum value: %10.2lf\nMinimum value: %10.2lf\nMaximum index: %10d\nMinimum index: %10d\n", max, min, imax, imin);

    double ave = 0.0;
    for (i = 0; i < n; i++) {
        ave += nums[i];
        if (i == n - 1) {
            ave /= n;
        }
    }

    printf("Average: %10.2lf\n", ave);

    int cn = n;
    printf("Reverse order: ");
    while (cn) {
        printf("%.2lf ", nums[--cn]);
    }

    printf("\n");

    cn = n;
    printf("Above average list: ");
    while (cn) {
        if (nums[--cn] > ave) {
            printf("%.2lf ", nums[cn]);
        }
    }

    printf("\n");

    printf("Negative coordinates: ");
    double *used = (double*)calloc(n*n, sizeof(double));
    for (i = 0; i < n; i++) {
        if (nums[i] >= 0) continue;
        for (j = 0; j < n; j ++) {
            int pass = 1;
            if ( nums[j] < 0 && nums[i] != nums[j]) {
                for (k = 0; k < n*n; k++) {
                    if (nums[i] + nums[j] == used[k]) {
                        pass = 0;
                    }
                }
                if (pass) {
                    printf("(%.2lf, %.2lf), ", nums[i], nums[j]);
                    used[i * j] = nums[i] + nums[j];
                }
            }
        }
    }

    printf("\n");

    free(nums);
    free(used);
    return 0;
} 