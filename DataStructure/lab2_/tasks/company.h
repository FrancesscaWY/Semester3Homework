//
// Created by francessca on 24-10-16.
//

#ifndef COMPANY_H
#define COMPANY_H
#include "Employee.h"
#include "listTemp.h"

class Company{
private:
    Employee bestPaid;
    ListTemp<Employee> empContainer;
public:
        void inputEmployeeHead(int total_num);
        void inputEmployeeTail(int total_num);
        void findBestPaid();
        void printBestPaid()const;
};


#endif //COMPANY_H
