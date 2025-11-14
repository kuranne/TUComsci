/*
LANG: C
COMPILER: WCB
*/
/*
NAME: WIRAKORN THANABAT
SID: 6809617415
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *cdyin() {
    size_t
    size = 2,
    length= 0;

    char
    *buf, 
    *tmp, 
    *fnl;

    int
    c;

    if ((buf = (char*)calloc(size, sizeof(char))) == NULL) 
        return NULL;

    while ((c = getchar()) != '\0' && c!= EOF && c != '\n') {
        if (length + 1 == size) {
            if ((tmp = (char*)realloc(buf, (++size)*sizeof(char))) == NULL) return NULL;
            buf = tmp;
        }
        buf[length++] = c;
    }
    buf[length] = '\0';
    return ((fnl = (char*)realloc(buf, (length + 1) * sizeof(char))) == NULL)? buf: fnl;
}

int main() {
    char x, *buf;
    int i, j, n, *vec;
    scanf(" %c %d", &x, &n);
    getchar();
    vec = (int*)calloc(n, sizeof(int));
    for (i = 0; i < n; i++) {
        buf = cdyin();
        for (j = 0; j < strlen(buf); j++) {
            if (buf[j] == x) vec[i] += 1;
        }
    }
    for (i = 0; i < n; i++) printf("%d\n", vec[i]);
    free(vec);
    free(buf);
    return 0;
}