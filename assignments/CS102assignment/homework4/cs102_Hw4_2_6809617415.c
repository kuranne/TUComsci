#include <stdio.h>
#define MAX_STUDENTS 5
#define MAX_NAME_LENGTH 50
typedef struct {
    int id;
    char name[MAX_NAME_LENGTH];
    float score;
} Student;

void inputStudentData(Student *stu) {
    int i;
    for (i = 0; i < MAX_STUDENTS; i++) {
        printf("Enter student %d's ID: ", i + 1);
        scanf("%d", &stu[i].id);
        printf("Enter student %d's name: ", i + 1);
        scanf("%s", stu[i].name);
        printf("Enter student %d's score: ", i + 1);
        scanf("%f", &stu[i].score);
    }
    printf("*************************************\n");
}

void printStudentData(Student *stu) {
    printf("\nStudent Data:\nID       Name    Score:\n");
    int i;
    for (i = 0; i < MAX_STUDENTS; i++) {
        printf("%-9d%-8s%-5.2f\n", stu[i].id, stu[i].name, stu[i].score);
    }
    printf("*************************************\n");
}

void findHighestScore(Student *stu) {
    printf("\nStudent with a highest score:\n");
    float maxsc = stu[0].score;
    char maxname[MAX_NAME_LENGTH];
    int i, j;
    for (i = 0; i < MAX_NAME_LENGTH; i++) {
        if (stu[0].name[i] != '\0') maxname[i] = stu[0].name[i];
        else {maxname[i] = '\0'; break;}
    }
    int maxid = stu[0].id;
    for (i = 1; i < MAX_STUDENTS; i++) {
        if (stu[i].score > maxsc) {
            maxsc = stu[i].score;
            for (j = 0; j < MAX_NAME_LENGTH; j++) {
                if (stu[i].name[j] != '\0') maxname[j] = stu[i].name[j];
                else {maxname[j] = '\0'; break;}
            }
            maxid = stu[i].id;
        }
    }
    printf("ID: %d  Name: %s  Score: %.2f\n", maxid, maxname, maxsc);
    printf("*************************************\n");
}

int main() {
    Student students[MAX_STUDENTS];
    inputStudentData(students);
    printStudentData(students);
    findHighestScore(students);
    return 0;
}
