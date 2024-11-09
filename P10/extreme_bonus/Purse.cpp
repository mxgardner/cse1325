#include "Purse.h"
#include <regex>
#include <string>

const std::string Purse::pound_utf8 = "£";

void Purse::rationalize() {
    if (_pence >= 12) { _shillings += _pence / 12; _pence %= 12; }
    if (_shillings >= 20) { _pounds += _shillings / 20; _shillings %= 20; }
}

std::ostream& operator<<(std::ostream& os, const Purse& purse) {
    os << "£" << purse._pounds << " " << purse._shillings << "s" << purse._pence << "d";
    return os;
}

std::istream& operator>>(std::istream& is, Purse& purse) {
    std::string line;
    std::getline(is, line); // Read the entire line

    // Regular expression to match input format "£pounds shillings s pence d"
    std::regex pattern(R"(£\s*(\d+)\s+(\d+)s\s*(\d+)d)");
    std::smatch matches;

    if (std::regex_match(line, matches, pattern)) {
        purse._pounds = std::stoi(matches[1].str());
        purse._shillings = std::stoi(matches[2].str());
        purse._pence = std::stoi(matches[3].str());
        purse.rationalize();
    } else {
        is.setstate(std::ios::failbit); // Set failbit if the input does not match the pattern
    }

    return is;
}

int Purse::operator[](const std::string& unit) const {
    if (unit == pound_utf8) return _pounds;
    if (unit == "s") return _shillings;
    if (unit == "d") return _pence;
    throw std::invalid_argument("Invalid unit");
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
