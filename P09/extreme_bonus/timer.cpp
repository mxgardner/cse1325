#include "timer.h"

Timer::Timer(int h, int m, int s) : Clock(h, m, s) {}

void Timer::tic() {
    if (--seconds < 0) {
        seconds = 59;
        if (--minutes < 0) {
            minutes = 59;
            if (--hours < 0) {
                hours = 0;
                minutes = 0;
                seconds = 0;
                throw Timer_expired("Timer expired");
            }
        }
    }
}
