#include <iostream>
#include "company.h"

using namespace std;

void Company::inputEmployee()
{
	Employee employee;
	employee.input();
	empContainer.addHead(employee);
	//Task 1: please implement this!
}

void Company::findBestPaid()
{
	//Task 2: please implement this!
	ListCont<Employee>::Iterator it = empContainer.Begin();
	for( ;!(it == empContainer.End());it++) {
		if(*it > bestPaid) {
			bestPaid = *it;
		}
	}
}

void Company::printBestPaid() const
{
	cout << "The best-paid employee and gross pay: " << endl;
	bestPaid.output();
} // printBestPaid
