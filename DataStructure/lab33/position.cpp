#include "position.h"

Position::Position()
{
	row = 0;
	column = 0;
}

Position::Position(int thisRow, int thisCol,int thisValue)
{
	row = thisRow;
	column = thisCol;
	value = thisValue;
}

int Position::getRow() const 
{
	return row;
}

int Position::getColumn() const 
{
	return column;
}

int Position::getValue()const {
	return value;
}