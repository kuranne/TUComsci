#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *cdyin() {
    size_t
    size = 2, length = 0;
    char
    *buf,
    *fnl,
    *tmp;
    int c;

    buf = (char*)calloc(size, sizeof(char));

    while ((c = getchar()) != EOF && c != '\n' && c != '\0') {
        if (length + 1 == size) {
            size *= 2;
            tmp = realloc(buf, sizeof(char) * size);
            buf = tmp; 
        }
        buf[length++] = c;
    }
    buf[length] = '\0';

    return (!(fnl = realloc(buf, (length + 1) * sizeof(char))))? buf: fnl;
}

int main() {
    size_t size = 2, length = 1;
    char *words = cdyin(), *lc = calloc(1, sizeof(char));
    int i = 0, n = 1, *rank = (int*)calloc(size, sizeof(int)), *tmp;

    rank[0] = 1;

    while (i < (int)strlen(words)) {
        if (words[i] == '_') {
            *lc = words[i - 1];
            n++;
        } else if (*lc && words[i-1] == '_') if (words[i] != *lc) {
            if (length + 1 == size) {
                size *= 2;
                tmp = realloc(rank, sizeof(int) * size);
                rank = tmp;
            }
            rank[length++] = n;
        }
        i++;
    }

    printf("%d\n", n);

    for (i = 0; i < length && rank[i] != 0; i++) printf("%d ", rank[i]);
    printf("\n");
    
    free(lc);
    free(words);
    return 0;
}