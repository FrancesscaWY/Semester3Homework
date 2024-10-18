//
// Created by francessca on 24-10-16.
//

#ifndef EMPLOYEE_H
#define EMPLOYEE_H
#include <string>

class Employee{
  private:
      std::string name;
      double grossPay;
public:
    Employee();

    void input(int id,const std::string& name,double grossPay);

    void output()const;

    void operator=(const Employee& other);

    bool operator>(const Employee& other)const;

    std::string getName()const;

};

#endif //EMPLOYEE_H
