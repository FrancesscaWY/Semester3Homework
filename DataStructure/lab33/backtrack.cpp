#include "backtrack.h"
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

