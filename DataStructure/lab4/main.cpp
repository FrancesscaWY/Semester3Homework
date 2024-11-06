//
// Created by francessca on 24-11-6.
//
#include "List.h"
#include <iostream>
using namespace std;
int mian() {
    //对List进行测试
    cout << "Test List" << endl;
    List<string> list;
    list.push_back("hello");
    list.push_back("world");
    list.push_back("!");
    list.push_back("This");
    list.push_back("is");
    list.push_back("a");
    list.push_back("test");
    list.pop_back();
    list.pop_front();
    list.show();

    cout << endl;
    List<string> list2(list);
    List<string>::Iterator it2 = list2.begin()++;
    list2.insert(it2,"insert");
    List<string>::Iterator it3 = it2++;
    list2.insert(it3,"insert");
    list2.erase(it3);
    List<string>::Iterator it4 = it3++;
    list2.erase(list2.begin(),it4);
    list.show();
    list.splice(it4,list2);
    list.show();
    return 0 ;

}