#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *input() {
    size_t size = 1, length = 0;
    char *strarr = (char*)calloc(size, sizeof(char));
    if (strarr == NULL){return NULL;}
    int c;
    while ((c = getchar()) != '\0' && c != EOF && c != '\n') {
        if (length == size - 1) {
            size += 1;
            char *temp = (char*)realloc(strarr, size);
            if (temp == NULL) {free(strarr); return NULL;}
            strarr = temp;
        }
        strarr[length++] = c;
    }
    if (length == 0){return NULL;}
    strarr[length] = '\0';
    char *fnl_strarr = (char*)realloc(strarr, length + 1);
    return (fnl_strarr == NULL)?strarr:fnl_strarr;
}

char *strsort(char arr[]) {
    int i, arr_len = strlen(arr);
    char temp;
    for (i = 1; i < arr_len; i++){
        if (arr[i] < arr[i-1]) {
            temp = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = temp;
            i = 0;
        }
    }
    return arr;
}

int main(){
    char *cin = input(), *used = (char*)calloc(strlen(cin), sizeof(char)), *dup = (char*)calloc(strlen(cin), sizeof(char));
    int cin_len = strlen(cin), i, j, check;
    cin = strsort(cin);
    
    for (i = 0; cin[i] != '\0'; i++) {
        check = 0;
 
        for (j = 0; j < cin_len; j++) {
            if (cin[i] == used[j]) {
                check = 1;
                break;
            }
            if (used[j] == '\0') {
                used[j] = cin[i];
                break;
            }
        }
        
        if (check) {
            for (j = 0; j < cin_len; j++) {
                if (dup[j] == cin[i]) {
                    check = 0;
                }
            }
            if (check) {
                for (j = 0; j < cin_len; j++) {
                    if (dup[j] == '\0') {
                        dup[j] = cin[i];
                        break;
                    }
                }
            }
        }
    }   

    int used_len = strlen(used);
    char *missing = (char*)calloc(cin_len, sizeof(char));
    char c;

    for (i = 0; i < cin_len; i++) {
        check = 1;
        c = 'A' + i;
        for(j = 0; j < used_len; j++) {
            if (c == used[j]) {
                check = 0;
                break;
            }
        }

        if (check) {
            for (j = 0; j < cin_len; j++){
                if (missing[j] == '\0') {
                    missing[j] = c;
                    break;
                }
            }
        }
    }

    int missing_len = strlen(missing);
    if (missing_len > 0) {
        if (strlen(dup) > 0) {
            printf("%s\n%s\n", dup, missing);
        } else {
            printf("NO DUPLICATE\n%s\n", missing);
        }
    } else {
        printf("NO MISSING\n");
    }
    return 0;
}