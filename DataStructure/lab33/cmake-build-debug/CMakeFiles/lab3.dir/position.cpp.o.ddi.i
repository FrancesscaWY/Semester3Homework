# 0 "/home/francessca/OtherProjects/Semester3H/DataStructure/lab33/position.cpp"
# 1 "/home/francessca/OtherProjects/Semester3H/DataStructure/lab33/cmake-build-debug//"
# 0 "<built-in>"
# 0 "<命令行>"
# 1 "/usr/include/stdc-predef.h" 1 3 4
# 0 "<命令行>" 2
# 1 "/home/francessca/OtherProjects/Semester3H/DataStructure/lab33/position.cpp"
# 1 "/home/francessca/OtherProjects/Semester3H/DataStructure/lab33/position.h" 1



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
# 2 "/home/francessca/OtherProjects/Semester3H/DataStructure/lab33/position.cpp" 2

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
int Position::getRow() const {
 return row;
}
int Position::getColumn() const {
 return column;
}
int Position::getValue()const {
 return value;
}
