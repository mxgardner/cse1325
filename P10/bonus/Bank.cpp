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
        Purse purse;
        std::cout << "Enter account name: ";
        std::cin.ignore();
        std::getline(std::cin, name);
        std::cout << "Enter initial deposit (format: £pounds shillings s pence d): ";
        std::cin >> purse; 
        vault[name] = purse;
    }

    Purse total;
    for (const auto& [name, purse] : vault) {
        std::cout << name << ": " << purse << "\n";
        total += purse;
    }
    std::cout << "Total amount in the bank: " << total << "\n";
    return 0;
}
