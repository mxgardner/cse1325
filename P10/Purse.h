#ifndef PURSE_H
#define PURSE_H

#include <iostream>
#include <compare>

class Purse {
private:
    int _pounds, _shillings, _pence;
    void rationalize();

public:
    Purse(int pounds = 0, int shillings = 0, int pence = 0) : _pounds(pounds), _shillings(shillings), _pence(pence) { rationalize(); }

    friend std::ostream& operator<<(std::ostream& os, const Purse& purse);
    auto operator<=>(const Purse&) const = default;
    Purse& operator++();
    Purse operator++(int);
    Purse operator+(const Purse&) const;
    Purse operator-(const Purse&) const;
    Purse& operator+=(const Purse&);
    Purse& operator-=(const Purse&);
};

#endif // PURSE_H