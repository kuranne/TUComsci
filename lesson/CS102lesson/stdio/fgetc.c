#include <stdio.h>

int main() {
    FILE *inFile;
    int c;

    if ((inFile = fopen("file.txt", "rw")) == NULL) return 1;

    while((c = fgetc(inFile)) != EOF) printf("%c", c); // read a character until found EOF (or ctrl + D in getc)
    printf("\n");

    return 0;
}