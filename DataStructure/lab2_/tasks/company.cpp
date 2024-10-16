//
// Created by francessca on 24-10-16.
//
#include "company.h"
#include <iostream>
void Company::inputEmployeeHead(int total_num){
  int i=1;
  while(total_num) {
    Employee newEmp;
    newEmp.input(i);
    empContainer.addHead(newEmp);
    total_num--;
    i++;
  }
}

void Company::inputEmployeeTail(int total_num) {
  int i=1;
  while(total_num) {
    Employee newEmp;
    newEmp.input(i);
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