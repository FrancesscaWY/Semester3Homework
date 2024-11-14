//
// Created by francessca on 24-11-6.
//
#include "List.h"
#include <iostream>
using namespace std;
int main() {
    //对List进行测试
    List<string> list;
    list.push_back("hello");
    list.push_back("world");
    list.push_back("!");
    list.push_back("This");
    list.push_back("is");
    list.push_back("a");
    list.push_back("test!");
    cout << "==========Test for push_back/pop_back/pop_front============" << endl;
    cout << "使用push_back方法向list插入元素之后: " << endl;
    list.show();
    list.pop_back();
    list.pop_front();
    cout << "使用pop_back方法pop_front方法删除元素之后: " << endl;
    list.show();

    cout << endl;
    List<string> list2(list);
    cout << "======================================Test for copy constructor===============================================" << endl;
    cout << "使用构造器list复制到list2后list中的元素为: " << endl;
    list2.show();
    List<string>::Iterator it2 = list2.begin();
    cout <<"===============================Test for insert at one position =================================================" << endl;
    cout << "在it2位置(此时指向头节点)插入\"insert\"链表之前的链表:" << endl;
    list2.show();
    list2.insert(it2,"insert");
    cout << "在it2位置(此时指向头节点)插入\"insert\"链表之后的链表:" << endl;
    list2.show();
    list2.insert(it2,"insert1");
    cout << "在it2位置(此时指向节点word)插入\"insert1\"链表之后的链表:" << endl;
    list2.show();
    List<string>::Iterator it3 = ++it2;
    // list2.insert(it3,"insert");
    cout << "==================================================Test for erase===============================================" << endl;
    cout << "调用erase函数删除指向word节点的下一个节点:" << endl;
    list2.erase(it3);
    list2.show();
    cout << "===========================Test for erase from a Iterator to another===========================================" << endl;
    List<string>:: Iterator it4 = ++list2.begin();
    cout << "调用erase函数删除一段区间内的元素之前 : " << endl;
    list2.show();
    list2.erase(list2.begin(),++it4);
    cout << "调用erase函数删除[0,1)位置的元素之后 : " << endl;
    list2.show();
    cout << "=================================================Test for splice================================================" << endl;
    cout << "调用splice函数之前的list和list2:" << endl;
    list.show();
    list2.show();
    list.splice(++list.begin(),list2);
    cout << "调用splice方法在list的第二个节点之前拼接list2: " << endl;
    list.show();
    cout << "调用splice方法在list的第二个节点之前拼接list2后list的大小: " << endl;
    cout << list.size() << endl;
    return 0 ;
}