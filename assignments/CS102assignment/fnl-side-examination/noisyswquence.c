/*
LANG: C
COMPILER: WCB
*/
/*
NAME: WIRAKORN THANABAT
SID: 6809617415
*/

#include <stdio.h>
#include <stdlib.h>

void plus(int n, int *ans, int *vec, int *plused) {
    int k;
    for (k = 0; k < n; k++) {
        if (*vec == plused[k]) break;
        else if (plused[k] == 0) {
            plused[k] = *vec;
            (*ans) += (*vec);
            break;
        } 
    }
}

int main() {
    int
    i, j,
    *ques = (int*)malloc(3 * sizeof(int));

    for (i = 0; i < 3; i++) scanf("%d", &ques[i]);

    int
    *vec = (int*)calloc(ques[0], sizeof(int)),
    *used = (int*)calloc(ques[0], sizeof(int)),
    *fe = (int*)calloc(2, sizeof(int)),
    start, last, ans = 0,
    *plused = (int*)calloc(ques[0], sizeof(int)),
    pos = 1, past = ques[1];

    for (i = 0; i < ques[0]; i++) {
        scanf("%d", &vec[i]);
        if (vec[i] == ques[1] && fe[0] == 0) {
            fe[0] = vec[i];
            start = i;
        }

        if (vec[i] <= ques[2] && vec[i] >= ques[1] && fe[1] < vec[i] && vec[i] == past + 1) {
            fe[1] = vec[i];
            last = i;
            past++;
        }
    }

    for (i = start; i < last; i++) {
        // printf("\n: %d\n", ans);
        if (!(vec[i] >= fe[0] && vec[i] <= fe[1])) {
            plus(ques[0], &ans, &vec[i], plused);
            // for (j = 0; plused[j] != 0; j++) printf("+%d ", plused[j]);
            continue;
        } else {
            for (j = 0; j < ques[0]; j++) {
                if (used[j] == 0) {
                    if (vec[i] - 1 != vec[i - pos] && i > start) {
                        plus(ques[0], &ans, &vec[i], plused);
                        pos++;
                    } else {
                        used[j] = vec[i];
                        pos = 1;
                    }
                    break;
                } else if (used[j] == vec[i]) {
                    plus(ques[0], &ans, &vec[i], plused);
                    break;
                }
            }
        }
    }

    // for (i = 0; i < ques[0] && used[i] != 0; i++) {
    //     printf("%d ", used[i]);
    // } printf("\n");

    // printf("%d %d (%d, %d)\n", fe[0], fe[1], start, last);
    printf("%d\n", ans);

    free(ques);
    free(vec);
    free(used);
    free(plused);
    return 0;
}