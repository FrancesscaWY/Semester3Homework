//
// Created by francessca on 10/13/24.
//

#ifndef EMPLOYEE_H
#define EMPLOYEE_H

#include <string>

class Employee {
private:
    std::string name;
    double grossPay;
public:

    Employee();  // PostCondition: this employee's name has been set to "" and gross pay to 0.00.

    void input();   //PostCondition:The name and gross pay of this Employee have been read in.

    void output()const;  //PostCondition: this Employee's name and gross pay have been written out.

    void operator=(const Employee& other);

    bool operator>(const Employee& other)const;

    std::string getName()const;

};
#endif //EMPLOYEE_H
