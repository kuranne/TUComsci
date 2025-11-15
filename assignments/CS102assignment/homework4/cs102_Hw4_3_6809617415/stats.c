#include "stats.h"
#include <stdlib.h>

void stats(int *data, int N, struct statistics *stats) {
    int i;
    
    bubbleSort(data, N);

    // minmax
    stats -> min = data[0];
    stats -> max = data[0];

    for (i = 0; i < N; i++) {
        if (stats -> min > data[i]) stats -> min = data[i];
        if (stats -> max < data[i]) stats -> max = data[i];
    }

    // range
    stats -> range = data[N - 1] - data[0];

    // mean
    for (i = 0; i < N; i++) 
        stats -> mean += data[i];
    stats -> mean /= N;

    // median
    i = (N % 2 == 0)? N/2 - 1: N/2;
    stats -> median = data[i];

    // mode
    #define smax stats->max
    int *fq = (int*)calloc(smax + 1, sizeof(int));

    for (i = 0; i < N; i++) fq[data[i]] += 1;
    
    i = smax;
    while (i--) if (fq[smax] <= fq[i]) {
        fq[smax] = fq[i];
        stats -> mode = i;
    }

    free(fq);
    #undef smax

    // amount
    stats -> N = N;
}