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

char *cdyin() {
    size_t
    size = 2,
    length = 0;

    int c;

    char
    *buf,
    *tmp,
    *fnl;

    if (!(buf = (char*)calloc(size, sizeof(char)))) return NULL;

    while ((c = getchar()) != EOF && c != '\n' && c != '\0') {
        if (length + 1 == size) {
            size *= 2;
            if (!(tmp = realloc(buf, sizeof(char) * size))) {
                free(buf);
                return NULL;
            }
            buf = tmp;
        }
        buf[length++] = c;
    }
    buf[length] = '\0';
    return (!(fnl = realloc(buf, sizeof(char) * (length + 1))))? buf: fnl;
}

int spc(char spw[], char cpr) {
    int i;
    if (cpr >= 'a') {
        for (i = 0; i < 5; i++) {
        if (spw[i] == cpr) {
                return 1;
            }
        }
    } else {
        for (i = 5; i < 10; i++) {
        if (spw[i] == cpr) {
                return 1;
            }
        }
    }
    return 0;
}

int main() {
    char *str = cdyin(), spw[] = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
    int i = 0, word = 1, spe = 0;
    
    while (str[i] != '\0'){
        if (i == 0 && spc(spw, str[0])) spe++;
        if (str[i] == '_') {
            if (spc(spw, str[i + 1])) {
                spe++;
            }
            word++;
        }
        i++;
    }
    printf("%d %d\n", word, spe);

    free(str);
    return 0;
}