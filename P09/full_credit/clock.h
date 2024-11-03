#ifndef CLOCK_H
#define CLOCK_H

#include <iostream>
#include <stdexcept>
#include <iomanip>

class Clock {
protected:
    int _hours, _minutes, _seconds;

public:
    Clock(int hours, int minutes, int seconds);
    virtual ~Clock() = default;
    void print() const;
    virtual void tic();
};

#endif