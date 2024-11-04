#ifndef POSITION_H
#define POSITION_H

class Position
{
public:
	Position();
	Position(int thisRow, int thisCol,int value);
	int getRow() const;
	int getColumn() const;
	int getValue() const;
private:
	int row;
	int column;
	int value;
};


#endif
