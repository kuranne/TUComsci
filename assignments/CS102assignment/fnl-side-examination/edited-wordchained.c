#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *cin() {
    size_t size = 2, length = 0;
    int c;
    char *buf, *tmp, *fnl;

    if (!(buf = (char*)calloc(size, sizeof(char)))) return NULL;

    while ((c = getchar()) != EOF && c != '\n') {
        if (size == length + 1) {
            size *= 2;
            if (!(tmp = realloc(buf, sizeof(char) * size))) return NULL;
            buf = tmp;
        }
        buf[length++] = c;
    }
    buf[length] = '\0';
    return (!(fnl = realloc(buf, (length + 1) * sizeof(char))))? buf: fnl;
}

int main() {
    char *str = cin();
    int pos = 0, n = 1, chain = 1;

    while (str[pos] != '\0' && pos < (int)strlen(str)) {
        if (str[pos] == '_') {
            n++;
            if (str[pos - 1] != str[pos + 1]) chain++;
        }
        pos++;
    }

    printf("%d %d\n", n, chain);

    return 0;
}