#include "application.h"
#include <iostream>
using namespace std;

#define NULL 0


#include "application.h"
#include <iostream>
using namespace std;

// Board
int chessboard[8][8] = {0};

void Application::initialize() {
    // Reset the chessboard if needed
    for (int i = 0; i < 8; i++)
        for (int j = 0; j < 8; j++)
            chessboard[i][j] = 0;
}

Position Application::getStartPosition() {
    return Position(0, 0, chessboard[0][0]);
}

bool Application::isValid(const Position& p) {
    const int row = p.getRow();
    const int column = p.getColumn();
    if (row < 0 || column < 0 || column >= 8 || row >= 8) {
        return false;
    }

    int sum1 = 0,sum2=0,sum3=0,sum4=0;
    // Check column and row for existing queens
    for (int i = 0; i < 8; i++) {
        sum1+=chessboard[row][i];
        sum2+=chessboard[i][column];
    }
    for(int i=0;i<8;i++) {
        int j = column - row + i;
        if(j>=0&&j<8) {
            sum3+=chessboard[i][j];
        }
    }
    for(int i=0;i<8;i++) {
        int j = column + row - i;
        if(j>=0&&j<8) {
            sum4+=chessboard[i][j];
        }
    }

    // std::cout << sum1 << " " << sum2 << " " << sum3 << " " << sum4 << std::endl;
    return sum1==0&&sum2==0&&sum3==0&&sum4==0;
}

void Application::progress(const Position& p) {
    chessboard[p.getRow()][p.getColumn()] = 1; // Place a queen
}

bool Application::success(const Position& p) {
    int count = 0;
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if (chessboard[i][j] == 1) {
                count++;
            }
        }
    }
    return count == 8;
}

void Application::goBack(const Position& p) {
    chessboard[p.getRow()][p.getColumn()] = 0; // Remove the queen
}

void Application::print() {
    cout << "Solution Found:\n";
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            cout << (chessboard[i][j] ? "Q " : ". ");
        }
        cout << endl;
    }
    cout << endl; // Extra line for better readability
}

// Application::Iterator and other methods remain unchanged
//======================================================================
struct itrPosition {
    int row;
    int column;
    int value;
};

//application iterator
Application::Iterator::Iterator() {
    currItrPosPtr = NULL;
}

Application::Iterator::Iterator(const Position& currPos) {
    itrPosition* p = new itrPosition;
    p->row = currPos.getRow();
    p->column = currPos.getColumn();
    p->value = currPos.getValue();
    currItrPosPtr = p;
}

Position Application::Iterator::getNextPosition() {
    int row = ((itrPosition*)currItrPosPtr)->row;
    int column = ((itrPosition*)currItrPosPtr)->column;
    int value = ((itrPosition*)currItrPosPtr)->value;
    column++;
    if(column == 8) {
        column =0;
        row++;
    }
    currItrPosPtr = new itrPosition{row, column, value};
    return Position(row, column, value); //return the new position
}

bool Application::Iterator::noNextPosition() {
    return ((itrPosition*)currItrPosPtr)->column == 7 && ((itrPosition*)currItrPosPtr)->row == 7;
}

Application::Iterator::~Iterator() {
    delete (itrPosition*)currItrPosPtr;
}