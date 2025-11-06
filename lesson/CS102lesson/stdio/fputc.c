#include <stdio.h>
#define BufSize 80

int main() {
    FILE *infile, *outfile; int i;
    char c;

    if ((infile = fopen("ftor.txt", "r")) == NULL) return 1;
    if ((outfile = fopen("ftow.txt", "w")) == NULL) return 1;

    while ((c = fgetc(infile)) != EOF) {
        fputc(c, outfile); // write a char to file
    }

    return 0;
}