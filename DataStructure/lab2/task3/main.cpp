//
// Created by francessca on 10/13/24.
//
#include "company.h"
#include <iostream>
using namespace std;
int main() {
    Company comp;//create Company object
    comp.inputEmployee();//add Employee object into comp
    comp.inputEmployee();
    comp.inputEmployee();
    comp.inputEmployee();
    comp.inputEmployee();
    comp.getNumber();    //print the number of employee
    comp.findBestPaidReverse();
    comp.printBestPaid();//print the bestPaid information
    return 0;
}

