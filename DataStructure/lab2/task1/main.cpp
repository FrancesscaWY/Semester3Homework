//
// Created by francessca on 10/12/24.
//

#include "company.h"
#include <iostream>
using namespace std;

int main() {
    Company comp;
    comp.inputEmployee();
    comp.inputEmployee();
    comp.inputEmployee();
    comp.inputEmployee();
    comp.inputEmployee();
    comp.inputEmployee();
    cout << "Number of employees is : " << comp.getNumber()<<endl;
    return 0;
}