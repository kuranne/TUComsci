#include "../header_files/collection.h"

void summary(int x, int y, double *prom, double *prop);

signed main() {
    int x = 5, y = 3;
    double res_mul = 0, res_sum = 0;
    summary(x, y, &res_mul, &res_sum);
    printf("%d, %d, %lf, %lf \n",x, y, res_mul, res_sum);
    return 0;
}

void summary(int x, int y, double *prom, double *prop) {
    *prom = x * y;
    *prop = x + y;
    return;
}