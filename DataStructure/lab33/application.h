#ifndef APPLICATION_H
#define APPLICATION_H
#include "position.h"
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
#endif
