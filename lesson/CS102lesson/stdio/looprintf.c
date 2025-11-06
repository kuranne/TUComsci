#include <stdio.h>
#include <string.h>
#include <time.h>

int main() {
    const char text[] = "Hello World!";
    int text_length = strlen(text), i;

    for (i = 0; i < text_length; i++) {
        printf("\"%.*s\"\n", i, text); // .* for custom something..., maybe?
    }

    return 0;
}