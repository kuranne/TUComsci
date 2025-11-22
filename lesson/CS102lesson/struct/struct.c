#include <stdio.h>

struct Person {
    int age;
    float height;
};


int main() {
    struct Person Maisa;
    Maisa.age = 18;
    Maisa.height = 1.63;

    printf("Maisa's age is %d years old\nMaisa's height is %.2f m.", Maisa.age, Maisa.height);
    return 0;
}