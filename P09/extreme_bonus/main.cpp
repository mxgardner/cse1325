#include "timer.h"
#include <iostream>
#include <stdexcept>
#include <string>

int main(int argc, char* argv[]) {
    if (argc != 4) {
        std::cerr << "usage: clock <hour> <minutes> <seconds>" << std::endl;
        return -1;
    }

    try {
        int hours = std::stoi(argv[1]);
        int minutes = std::stoi(argv[2]);
        int seconds = std::stoi(argv[3]);
        Timer timer(hours, minutes, seconds);

        std::string input;
        while (true) {
            timer.print();
            std::getline(std::cin, input);
            if (input == "q") break;
            timer.tic();
        }
    } catch (const std::out_of_range& e) {
        std::cerr << e.what() << std::endl;
        return -2;
    } catch (const Timer_expired& e) {
        std::cout << e.what() << std::endl;
    }

    return 0;
}
