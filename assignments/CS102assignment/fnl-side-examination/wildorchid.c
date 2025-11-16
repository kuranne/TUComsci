#include <stdio.h>

int main() {
    int month, type, mapping[12][26] = {0}, m, max = 0;

    while ((month = getchar()) != '\n' && month != EOF)
        if ((type = getchar()) != '\n' && type != EOF) {
            type -= 'A';
            month -= (month >= 'A')? 'A' - 9: '1';
            if (!(mapping[month][type])) mapping[month][type] = 1;
        }
    
    for (month = 0; month < 12; month++) {
        m = 0;
        for (type = 0; type < 26; type++) {
            m += mapping[month][type];
        }
        if (m > max) max = m;
        printf("%d\n", m);
    }

    printf("%d\n", max);

    return 0;
}