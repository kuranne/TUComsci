#include <stdio.h>
#define BUFSIZE 1024

int main() {
    FILE *infile, *outfile;
    infile = fopen("file.txt", "r");
    outfile = fopen("cpyfile.txt", "w");
    
    char buf[BUFSIZE];
    while (!feof(infile)) {
        fscanf(infile, "%s", buf);
        fprintf(outfile, "%s\n", buf);
    }
    fclose(infile);
    fclose(outfile);
    return 0;
}