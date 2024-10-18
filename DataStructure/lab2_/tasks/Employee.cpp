//
// Created by francessca on 24-10-16.
//
#include "Employee.h"
#include <iostream>
#include <string>
Employee::Employee(){
    name="";
    grossPay = 0.0;
}

std::string Employee::getName()const{
  return name;
}

void Employee::input(int id,const std::string& name,double grossPay){
    this->name = name+std::to_string(id);
    this->grossPay = grossPay;
}

void Employee::output()const{
    std::cout << "name: " << name << "; gross pay: " << grossPay << std::endl;
}

void Employee::operator=(const Employee& other){
     name = other.name;
     grossPay = other.grossPay;
}

bool Employee::operator>(const Employee& other)const{
     return grossPay>other.grossPay;
}