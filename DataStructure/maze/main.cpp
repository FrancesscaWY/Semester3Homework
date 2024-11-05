#include <iostream>
using namespace std;
int fib(int x) {
    if(x==0||x==1) {
        return 1;
    }else {
        return fib(x-1)+fib(x-2);
    }

}

int maze[8][13] = { {1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1} ,
                    {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1} ,
                    {1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1} ,
                    {1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1} ,
                    {1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1} ,
                    {1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0} ,
                    {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0} ,
                    {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1} };
void printMaze() {
    for(int i=0;i<8;i++) {
        for(int j=0;j<13;j++)
            cout << maze[i][j] << " ";
        cout << endl;
    }
}

bool isValidNextUp(int row,int column) {
    return ((row-1)>=0)&&(maze[row-1][column]==1);
}
bool isValidNextRight(int row,int column) {
    return ((column+1)<=12)&&(maze[row][column+1]==1);
}
bool isValidNextDown(int row,int column) {
    return ((row+1)<=7) && maze[row+1][column]==1;
}
bool isValidNextLeft(int row,int column) {
    return ((column-1)>=0) && maze[row][column-1]==1;
}
bool success(int row,int column) {
    return (row==7 && column==12);
}

void progressTo(int row,int column) {
    maze[row][column]=9;
}

void goBackFrom(int row,int column) {
    maze[row][column]=2;
}
bool tryWithBackTrack(int row,int column) {
    progressTo(row,column);
    if(success(row,column))
        return true;
    else {
        if (isValidNextUp(row,column) && tryWithBackTrack(row-1,column))
            return true;
        else if(isValidNextRight(row,column) && tryWithBackTrack(row,column+1))
            return true;
        else if(isValidNextDown(row,column) && tryWithBackTrack(row+1,column))
            return true;
        else if(isValidNextLeft(row,column) && tryWithBackTrack(row,column-1))
            return true;
        else
            goBackFrom(row,column);
            return false;
    }
}
int main() {
    std::cout << "Hello, World!" << std::endl;
    int n = 5;
    cout << "fib" << n  << ": " <<fib(n) << endl;
    if(tryWithBackTrack(0,0))
        printMaze();
    else
        cout << "No path exists! \n";
    return 0;
}
