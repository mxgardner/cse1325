#include "Purse.h"

const std::string Purse::pound_utf8 = u8"£"; // Define the pound symbol as a UTF-8 encoded string

void Purse::rationalize() {
    if (_pence >= 12) { _shillings += _pence / 12; _pence %= 12; }
    if (_shillings >= 20) { _pounds += _shillings / 20; _shillings %= 20; }
}

std::ostream& operator<<(std::ostream& os, const Purse& purse) {
    os << "£" << purse._pounds << " " << purse._shillings << "s" << purse._pence << "d";
    return os;
}

std::istream& operator>>(std::istream& is, Purse& purse) {
    char s, d;
    std::string pound_symbol;
    is >> pound_symbol >> purse._pounds >> purse._shillings >> s >> purse._pence >> d;
    if (pound_symbol != Purse::pound_utf8) is.setstate(std::ios::failbit); // Validate pound symbol
    purse.rationalize();
    return is;
}

Purse& Purse::operator++() {
    ++_pence;
    rationalize();
    return *this;
}

Purse Purse::operator++(int) {
    Purse temp = *this;
    ++(*this);
    return temp;
}

Purse Purse::operator+(const Purse& other) const {
    return Purse(_pounds + other._pounds, _shillings + other._shillings, _pence + other._pence);
}

Purse Purse::operator-(const Purse& other) const {
    return Purse(_pounds - other._pounds, _shillings - other._shillings, _pence - other._pence);
}

Purse& Purse::operator+=(const Purse& other) {
    _pounds += other._pounds;
    _shillings += other._shillings;
    _pence += other._pence;
    rationalize();
    return *this;
}

Purse& Purse::operator-=(const Purse& other) {
    _pounds -= other._pounds;
    _shillings -= other._shillings;
    _pence -= other._pence;
    rationalize();
    return *this;
}

int Purse::operator[](const std::string& unit) const {
    if (unit == pound_utf8) return _pounds;
    if (unit == "s") return _shillings;
    if (unit == "d") return _pence;
    throw std::invalid_argument("Invalid unit");
}
