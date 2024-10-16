#include <iostream>
#include <ctime>
#include <cstdlib>
#include "tasks/company.h"
using namespace std;
int main()
{
    Company company;
    clock_t addHeadStart,addHeadEnd,addTailStart,addTailEnd;
    addHeadStart = clock();
    company.inputEmployeeHead(3);
    addHeadEnd = clock();

    Company company2;
    addTailStart = clock();
    company2.inputEmployeeTail(3);
    addTailEnd = clock();
    cout << "Clock ticks  per second " << CLOCKS_PER_SEC<< endl;
    cout << "The time input form head: " << addHeadEnd - addHeadStart << endl;
    cout << "The time input from tail: " << addTailEnd - addTailStart << endl;
    company2.findBestPaid();
    company2.printBestPaid();
    return 0;
}
