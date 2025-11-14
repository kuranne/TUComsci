/*
LANG: C
COMPILER: WCB
*/
/*
NAME: WIRAKORN THANABAT
SID: 6809617415
*/

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

char *cdyin() {
    size_t
    size = 2,
    length= 0;

    int c;

    char
    *buf,
    *tmp,
    *fnl;

    if ((buf = (char*)calloc(size, sizeof(char))) == NULL) return NULL;

    while ((c = getchar()) != '\0' && c != EOF && c != '\n') {
        if (length + 1 == size) {
            size *= 2;
            if ((tmp = (char*)realloc(buf, sizeof(char) * size)) == NULL){
                free(buf);
                return NULL;
            }
            buf = tmp;
        }
        buf[length++] = c;
    }
    buf[length] = '\0';
    return ((fnl = (char*)realloc(buf, sizeof(char) * (length + 1))) == NULL)? buf: fnl;

}

int main() {
    char *txt = cdyin();
    int i = 1, ans = 0, c;
    while ((c = txt[i - 1]) != '\0' && c != EOF) {
        ans += ( c >= 'A' && c <= 'Z')? (c - 'A' + 1) * i:
        (c >= 'a' && c <= 'z')? (c - 'a' + 1) * i: 
        (c == ' ')? 27 * i: 0; 
        // printf(": %d\n", ans);
        i++;
        }
    
    printf("%d\n", ans);
    free(txt);
    return 0;
}