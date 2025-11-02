#include <stdio.h>

int main(){
    int a = 0, *b;
    printf("%d\n%d\n%p\n%p\n", a, *b, &a, &*b);
    b = &a;
    a++;
    printf("%d\n%d\n%p\n%p\n", a, *b, &a, &*b);
    *b += 3;
    printf("%d\n%d\n%p\n%p\n", a, *b, &a, &*b);
    
    return 0;
}