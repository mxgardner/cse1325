#include "Purse.h"
#include <iostream>
#include <map>
#include <string>

int main() {
    std::map<std::string, Purse> vault;
    int num_accounts;
    std::cout << "How many accounts to create? ";
    std::cin >> num_accounts;

    for (int i = 0; i < num_accounts; ++i) {
        std::string name;
        int pounds, shillings, pence;
        std::cout << "Enter account name: ";
        std::cin.ignore();
        std::getline(std::cin, name);
        std::cout << "Enter initial deposit (pounds shillings pence): ";
        std::cin >> pounds >> shillings >> pence;
        vault[name] = Purse(pounds, shillings, pence);
    }

    Purse total;
    for (const auto& [name, purse] : vault) {
        std::cout << name << ": " << purse << "\n";
        total += purse;
    }
    std::cout << "Total amount in the bank: " << total << "\n";
    return 0;
}
