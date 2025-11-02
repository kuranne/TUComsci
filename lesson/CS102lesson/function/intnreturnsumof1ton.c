#include <stdio.h>

int summari(int n) {
    int res = 0, i;
    for (i = 1; i <= n; i++){
        res += i;
    }
    return res;
}

int main(){
    int n;
    scanf("%d", &n);
    printf("%d\n", summari(n));
    return 0;
}