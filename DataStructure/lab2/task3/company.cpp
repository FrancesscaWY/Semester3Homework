//
// Created by francessca on 10/13/24.
//
#include "company.h"
#include <iostream>
void Company::inputEmployee() {
    Employee employee;
    employee.input();
    empContainer.addHead(employee);
}

void Company::findBestPaid() {
    for(doublyLink<Employee>::Iterator it = empContainer.Begin();!(it==empContainer.End());it++) {
        if(*it>bestPaid) {
            bestPaid=*it;
        }
    }
}


void Company::findBestPaidReverse() {
    for(doublyLink<Employee>::Iterator it = empContainer.reverseBegin();!(it==empContainer.reverseEnd());it--) {
        if(*it>bestPaid) {
            bestPaid=*it;
        }
    }
}

void Company::printBestPaid()const{
    std::cout << "The best-paid employee and gross pay: " << std::endl;
    bestPaid.output();
}

void Company::getNumber() const {
    std::cout << "The number of employees are: " << empContainer.getSize()<<std::endl;
}


