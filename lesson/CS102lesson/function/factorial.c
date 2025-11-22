#include <stdio.h>
#define int long long

int fac(int n) {
    int result = (n > 1) ? n * fac(n-1) : 1;
    return result;
}

signed main() {
    int n;
    scanf("%lld", &n);
    int x = fac(n);
    printf("%lld\n", x);
    return 0;
}
