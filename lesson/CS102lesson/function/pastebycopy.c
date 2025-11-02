#include "../header_files/collection.h"

double sum(double x, double y) {
    return x + y;
}

double mul(double x, double y) {
    return x * y;
}

signed main() {
    double x = 5, y = 3;
    double res_sum = sum(x, y);
    double res_mul = mul(x, y);

    printf("%lf, %lf, %lf, %lf \n", x, y, res_mul, res_sum);
    return 0;
}