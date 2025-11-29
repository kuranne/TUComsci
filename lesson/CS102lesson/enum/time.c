#include <stdio.h>

typedef struct {
    int hour;
    int minute;
    int second;
} Time;

void format(Time *time);

int main() {
    Time time;
    scanf("%d", &time.second);
    format(&time);
    printf("%d:%d:%d\n", time.hour, time.minute, time.second);
    return 0;
}

__attribute__((weak))
void format(Time *time) {
    time->minute = time->second / 60;
    time->hour = time->minute / 60;
    time->minute %= 60;
    time->second %= 60;
}