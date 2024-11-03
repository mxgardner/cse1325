#include "clock.h"

Clock::Clock(int hours, int minutes, int seconds) : _hours(hours), _minutes(minutes), _seconds(seconds) {
    if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59 || seconds < 0 || seconds > 59) {
        throw std::out_of_range("Invalid time: " + std::to_string(hours) + ":" + std::to_string(minutes) + ":" + std::to_string(seconds));
    }
}

void Clock::print() const {
    std::cout << std::setw(2) << std::setfill('0') << _hours << ":"
              << std::setw(2) << std::setfill('0') << _minutes << ":"
              << std::setw(2) << std::setfill('0') << _seconds << std::endl;
}
