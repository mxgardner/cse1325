#ifndef CLOCK_H
#define CLOCK_H

#include <iostream>
#include <iomanip>
#include <stdexcept>

class Clock {
protected:
    int hours;
    int minutes;
    int seconds;

public:
    Clock(int h, int m, int s);
    virtual ~Clock() {}

    void print() const;
    virtual void tic();
};

#endif
