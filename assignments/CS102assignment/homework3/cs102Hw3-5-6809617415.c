#include <stdio.h>

// Question 5 of Homework 3 (CS102 HW3 1/2567)
// Your program will Not successfully be compiled and run properly until readSquare and findMagicNumber functions are defined correctly.
// Let's define readSquare and findMagicNumber functions here !

void readSquare(int arr[8][8], int N) {
    int i, j;
    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) scanf("%d", &arr[i][j]);
    }
}

int findMagicNumber(int arr[8][8], int N) {
    int ans = 0, sum = 0, i, j;
    {
        for (i = 0; i < N; i++) sum += arr[0][i];
        for (i = 0; i < N; i++) ans += arr[i][i];
        for (i = 0; i < N; i++) ans += arr[N-i-1][i];
        for (j = 0; j < N; j++) {
            for (i = 0; i < N; i++) {
                ans += arr[i][j];
            }
        }
        for (i = 0; i < N; i++){
            for (j = 0; j < N; j++){
                ans += arr[i][j];
            }
        }
    }
    return (ans % sum == 0) ? sum : -1;
}

int main(){

    int arr[8][8];
    int N;

    scanf("%d", &N);
    readSquare(arr, N);

    int magicNumber = findMagicNumber(arr, N);

    if (magicNumber == -1) {
        printf("Your square is NOT a magic square.");
    } else {
        printf("Your square is a magic square!! with the magic constant = %d.", magicNumber);
    }

    return 0;
}