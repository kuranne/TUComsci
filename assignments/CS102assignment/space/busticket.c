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
    char 
    *ticket = cdyin();

    int
    i, 
    gab,
    tmp = 0;

    for (i = 0; i < (int)strlen(ticket) && ticket[i] != '\0'; i++)
        tmp += (ticket[i] >= '0' && ticket[i] <= '9')? ticket[i] - '0': 0;

    while (tmp > 9) {
        gab = 0;
        while (tmp > 0) {
            gab += tmp % 10;
            tmp /= 10;
        }
        tmp = gab;
    }

    printf("%d\n", tmp);
    
    free(ticket);
    return 0;
}