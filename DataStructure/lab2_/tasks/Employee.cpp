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

void Employee::input(int id){
    std::cout << "Please input your name and gross pay: " <<std::endl;
    std::string n;
    std::cin >> n >> grossPay;
    name = n + std::to_string(id);
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