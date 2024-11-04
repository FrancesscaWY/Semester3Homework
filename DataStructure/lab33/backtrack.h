#ifndef BACKTRACK_H
#define BACKTRACK_H
#include "application.h"
#include "position.h"

class BackTrack {
private:
    Application app;
public:
    BackTrack();
    explicit BackTrack(const Application& thisApp);
    bool backTrack(const Position& currPos);
};
#endif