//
// Created by francessca on 10/13/24.
//

#ifndef COMPANY_H
#define COMPANY_H
#include "Employee.h"
#include "doublyLink.h"

class Company {
private:
    Employee bestPaid;
    doublyLink<Employee> empContainer;

public:

    void inputEmployee();//PostCondition:when input employee from keyboard,
                        // store the input data in the container for later use;

    void findBestPaid();//PostCondition:go through the container to find the
                        // best paid employee

    void findBestPaidReverse();//PostCondition:go reverse through the container
                              // to find the best paid employee
    void printBestPaid()const;//PostCondition:print the bestPaid information

    void getNumber()const;
};
#endif //COMPANY_H
