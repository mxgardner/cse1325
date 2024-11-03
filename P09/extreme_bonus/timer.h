#ifndef TIMER_H
#define TIMER_H

#include "clock.h"
#include "timer_expired.h"

class Timer : public Clock {
public:
    Timer(int h, int m, int s);
    virtual ~Timer() {}

    void tic() override;
};

#endif
