#include "timer.h"

Timer::Timer(int hours, int minutes, int seconds) : Clock(hours, minutes, seconds) {}

void Timer::tic() {
    if (--_seconds < 0) {
        _seconds = 59;
        if (--_minutes < 0) {
            _minutes = 59;
            if (--_hours < 0) {
                _hours = 23;
                throw std::runtime_error("Timer expired");
            }
        }
    }
}
