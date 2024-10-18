#include <iostream>
#include <ctime>
#include <cstdlib>
#include "tasks/company.h"
#include <chrono>

using namespace std;

int main()
{
    srand(time(0));
    int  numEmployee =100;


    while(numEmployee!=1600) {
        Company company;
        clock_t addHeadStart,addHeadEnd,addTailStart,addTailEnd;
        addHeadStart = clock();
        company.inputEmployeeHead(numEmployee);
        addHeadEnd = clock();

        Company company2;
        addTailStart = clock();
        company2.inputEmployeeTail(numEmployee);
        addTailEnd = clock();

        cout << "Clock ticks  per second " << CLOCKS_PER_SEC<< endl;
        cout << "The time input " << numEmployee << " employees form head: " << addHeadEnd - addHeadStart << endl;
        cout << "The time input "<< numEmployee<<" employees from tail: " << addTailEnd - addTailStart << endl;
        company2.findBestPaid();
        company2.printBestPaid();
        numEmployee += 100;
    }

    return 0;
}
