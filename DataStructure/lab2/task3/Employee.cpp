//
// Created by francessca on 10/13/24.
//
#include <iostream>
#include "Employee.h"
using namespace std;
Employee::Employee() {
    name="";
    grossPay=0.0;
}

void Employee::input() {
    cout << "Please enter a name and gross pay; to quit, enter * followed by any number: ";
    cin >> name >> grossPay;
}

void Employee::output()const{
    cout << "name: " << name << "; gross pay: " << grossPay << endl;
}

void Employee::operator=(const Employee& other) {
    name=other.name;
    grossPay=other.grossPay;
}

bool Employee::operator>(const Employee& other)const{
    return grossPay > other.grossPay;
}

string Employee::getName()const{return name;}