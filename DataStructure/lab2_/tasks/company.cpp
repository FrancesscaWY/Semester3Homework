//
// Created by francessca on 24-10-16.
//
#include "company.h"
#include <iostream>
void Company::inputEmployeeHead(int total_num){
  int i=1;
  while(total_num) {
    Employee newEmp;
    std::string name ="Employee";
    double grossPay = static_cast<double>(rand()%100000);
    newEmp.input(i,name,grossPay);
    empContainer.addHead(newEmp);
    total_num--;
    i++;
  }
}

void Company::inputEmployeeTail(int total_num) {
  int i=1;
  while(total_num) {
    Employee newEmp;
    std::string name = "Employee";
    double grossPay = static_cast<double>(rand()%100000);
    newEmp.input(i,name,grossPay);
    empContainer.addTail(newEmp);
    total_num--;
    i++;
  }
}

void Company::findBestPaid() {
  for(ListTemp<Employee>::Iterator it=empContainer.Begin();!(it==empContainer.End());it++) {
    if(*it>bestPaid) {
      bestPaid=*it;
    }
  }
}

void Company::printBestPaid() const{
  std::cout << "The best-paid employee and gross pay: " << std::endl;
  bestPaid.output();
}