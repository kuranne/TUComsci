#include <stdio.h>

typedef union {
    char name[20];
    u_int8_t age;
    float salary;
} Person;

int main() {
    Person Maisa;

    scanf("%s", &Maisa.name);
    printf("name: %s with %u\n", Maisa.name, sizeof(Maisa));
    
    scanf("%u", &Maisa.age);
    printf("age: %u with %u\n", Maisa.age, sizeof(Maisa));
    
    scanf("%f", &Maisa.salary);
    printf("salary: %.2f with %u\n", Maisa.salary, sizeof(Maisa));

    return 0;
}