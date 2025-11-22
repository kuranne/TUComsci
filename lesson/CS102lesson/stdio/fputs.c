#include <stdio.h>
#define BufSize 80

int main() {
    FILE *infile, *outfile; char buff[BufSize];

    if ((infile = fopen("ftor.txt", "r")) == NULL) return 1;
    if ((outfile = fopen("ftow.txt", "w")) == NULL) return 1;

    while (!feof(infile)) {
        fgets(buff, BufSize, infile);
        fputs(buff, outfile);
    }

    return 0;
}