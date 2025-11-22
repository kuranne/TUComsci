#include <stdio.h>
#define BUFSIZE 100

int main() {
    FILE *infile, *outfile;
    infile = fopen("file.txt", "r");
    outfile = fopen("cpyfile.txt", "w");
    char str[BUFSIZE];
    
    while (!feof(infile)) {
        fgets(str, BUFSIZE, infile);
        fprintf(outfile, "%s", str);
    }
    
    return 0;
}