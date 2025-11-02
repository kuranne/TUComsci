#include <stdio.h>

int main(){
    int n = 1, *ptr = &n, **ptr2 = &ptr, a[4] = {1, 2, 3, 4}; 
    // init n = 1
    // ptr เก็บ address ของ n
    // ptr2 เก็บ address ของ ptr อีกที ใช้ *เพื่อเอา value ของ address นั้นๆ ออกมา
    printf("%d %d %d\n", **ptr2, *ptr, n);
    printf("%p %p %p\n", *ptr2, ptr, &n);
    printf("%p %p %p\n", ptr2, ptr, &n);
    printf("%p %p %p\n", &ptr2, &ptr, &n);
    printf("%p %d", a, *(a+2)); //a เก็บ address ของ array a
    return 0;
}