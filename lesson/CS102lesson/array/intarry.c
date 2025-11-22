#include <stdio.h>

int main() {
    int number[10] = {[0 ... 3] = 6, [7 ... 9] = 99};
    for (int i = 0; i < 10 && printf("%d", number[i]); i++);
    return 0;
}