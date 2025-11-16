#include "get_n_terms.h"
#include <math.h>
#include <limits.h>
#include <stdio.h>
#include <string.h>
#define dll long long int
#define s(x) 1.0/((x) * 2.0 + 1.0)

double picalc(dll x) {
    dll i;
    double ans = 1;
    for (i = 1; i <= x; i++) {
        ans += (i % 2 == 0)? s(i): -s(i);
    }
    return ans * 4.0;
}

void get_n_terms(const dll a[], int N, int pos[]){
    int i, j;
    double dPI = M_PI;
    char pi[40];
    snprintf(pi, sizeof(pi), "%.35f", dPI);
    
    //printf("pi: %s\n", pi);

    for (i = 0; i < N; i++) {
        dll x = (i > 0)? (a[i] - (dll)UINT_MAX - 1LL): a[i];
        double dcpi = picalc(x);
        char cpi[40];
        snprintf(cpi, sizeof(cpi), "%.35f", dcpi);
        
        //printf("cpi: %s\n", cpi);
        
        for (j = 0; j < strlen(cpi); j++) {
            if (cpi[j] != pi[j]) {
                pos[i] = (j == 0)? 0: (j <= 2)? 1: j -1;
                pos[i] -= (pos[i] > 0)? 1: 0;
                break;
            }
        }
    }
}

#undef dll
#undef s
