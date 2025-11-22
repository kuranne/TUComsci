#include <stdio.h>
#define BufSize 80

int main() {
    FILE *infile; char buf[BufSize];
    if ((infile = fopen("file.txt", "r")) == NULL) return 1;
    
    while(!feof(infile)) {// read until EOF
        fgets(buf, BufSize, infile); // get text one line
        printf("%s", buf);
    }

    return 0;
}