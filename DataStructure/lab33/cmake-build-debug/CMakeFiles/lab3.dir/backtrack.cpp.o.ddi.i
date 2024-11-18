# 0 "/home/francessca/OtherProjects/Semester3H/DataStructure/lab33/backtrack.cpp"
# 1 "/home/francessca/OtherProjects/Semester3H/DataStructure/lab33/cmake-build-debug//"
# 0 "<built-in>"
# 0 "<命令行>"
# 1 "/usr/include/stdc-predef.h" 1 3 4
# 0 "<命令行>" 2
# 1 "/home/francessca/OtherProjects/Semester3H/DataStructure/lab33/backtrack.cpp"
# 1 "/home/francessca/OtherProjects/Semester3H/DataStructure/lab33/backtrack.h" 1


# 1 "/home/francessca/OtherProjects/Semester3H/DataStructure/lab33/application.h" 1


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
# 4 "/home/francessca/OtherProjects/Semester3H/DataStructure/lab33/application.h" 2
class Application {
public:
    void initialize();
    Position getStartPosition();
    static bool isValid(const Position& p);
    void progress(const Position& p);
    bool success(const Position& p);
    void goBack(const Position& p);
    void print();
    class Iterator {
    public:
        Iterator();
        Iterator(const Position& curP);
        ~Iterator();
        Position getNextPosition();
        bool noNextPosition();

    private:
        void *currItrPosPtr;
    };
};
# 4 "/home/francessca/OtherProjects/Semester3H/DataStructure/lab33/backtrack.h" 2


class BackTrack {
private:
    Application app;
public:
    BackTrack();
    explicit BackTrack(const Application& thisApp);
    bool backTrack(const Position& currPos);
};
# 2 "/home/francessca/OtherProjects/Semester3H/DataStructure/lab33/backtrack.cpp" 2

BackTrack::BackTrack() {};
BackTrack::BackTrack(const Application& thisApp) {
    this->app = thisApp;
}
bool BackTrack::backTrack(const Position& currPos) {
    app.progress(currPos);
    if(app.success(currPos)) {
        return true;
    }else {
        Application::Iterator itr(currPos);
        Position nextPos;
        while(!itr.noNextPosition()) {
            nextPos = itr.getNextPosition();
            if(app.isValid(nextPos)&&backTrack(nextPos))
                return true;
        }
        app.goBack(currPos);
        return false;
    }

}
