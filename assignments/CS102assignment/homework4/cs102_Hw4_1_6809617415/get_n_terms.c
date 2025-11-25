#define _GNU_SOURCE
#include <math.h>
#include <stdio.h>
#include <string.h>
#include "get_n_terms.h"

typedef unsigned long long int uint64;

void get_n_terms(const long long int a[], int N, int pos[]) {
    char pi[40], cps[40];
    sprintf(pi, "%.35f", M_PI);
    
    uint64 ua[N], j;
    int i, count, k;
    double ans;

    for (i = 0; i < N; i++) ua[i] = (uint64)a[i];
    
    for (i = 0; i < N; i++) {
        ans = 0;
        count = 0;

        #define s(x) 1.0/(2.0 * (x) + 1.0)
        for (j = 0; j <= (int)ua[i]; j++) {
            ans += s((double)j) * pow(-1.0, (double)j);
        }
        #undef s

        sprintf(cps, "%.35f", ans * 4);

        for (k = 2; k < 40; k++) {
            if (cps[k] == pi[k]) count++;
            else break;
        }

        pos[i] = count;
    }
}
