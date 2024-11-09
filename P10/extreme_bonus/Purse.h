#ifndef PURSE_H
#define PURSE_H

#include <iostream>
#include <compare>
#include <string>

class Purse {
private:
    int _pounds, _shillings, _pence;
    void rationalize();
    static const std::string pound_utf8;

public:
    Purse(int pounds = 0, int shillings = 0, int pence = 0) : _pounds(pounds), _shillings(shillings), _pence(pence) { rationalize(); }

    friend std::ostream& operator<<(std::ostream& os, const Purse& purse);
    friend std::istream& operator>>(std::istream& is, Purse& purse);
    auto operator<=>(const Purse&) const = default;
    Purse& operator++();
    Purse operator++(int);
    Purse operator+(const Purse&) const;
    Purse operator-(const Purse&) const;
    Purse& operator+=(const Purse&);
    Purse& operator-=(const Purse&);

    int operator[](const std::string& unit) const;
};

#endif // PURSE_H
