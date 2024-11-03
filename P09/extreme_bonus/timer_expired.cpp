#include "timer_expired.h"

Timer_expired::Timer_expired(const std::string& message)
    : std::runtime_error(message) {}
