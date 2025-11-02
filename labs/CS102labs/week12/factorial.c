#include <stdio.h>
#define int long long

int factorial(int number) {
    if (number <= 1) return 1;
    else return (number * factorial(number - 1));
}

signed main () {
    int n;
    scanf("%lld", &n);
    printf("%lld! = %lld\n", n, factorial(n));
    return 0;
}