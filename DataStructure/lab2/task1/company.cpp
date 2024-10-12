#include <iostream>
using namespace std;

#include "company.h"


void Company::inputEmployee()
{
	//Task 1: Please implement this!
	Employee employee;
	employee.input();
	empContainer.addHead(employee);
}

int Company::getNumber() const
{
	return empContainer.getSize();
}