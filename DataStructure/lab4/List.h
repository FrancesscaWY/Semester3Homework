//
// Created by francessca on 24-11-6.
//

#ifndef LIST_H
#define LIST_H
#include <complex.h>

template <typename  T>
class List {
private:
    struct Node{
        Node* pre;
        Node* next;
        T data;
    };
    Node* head;
    Node* tail;
    unsigned length;
public:
    List();
    ~List();
    List(const List<T>& x);
    void push_front(const T& x);
    void push_back(const T& x);
    class Iterator {
        friend class List<T>;
    protected:
        Node* curr;
        Iterator(Node* x) {
            curr = x;
        };
    public:
        Iterator(){curr=nullptr;}
        Iterator& operator++();
        Iterator operator++(int);
        Iterator operator--();
        Iterator operator--(int);
        T& operator*();
        bool operator==(const Iterator& x);
    };
    Iterator insert(Iterator position,const T &x);
    void pop_front();
    void pop_back();
    Iterator erase(Iterator position);
    Iterator erase(Iterator first,Iterator last);
    unsigned size()const;
    bool empty()const;
    Iterator begin();
    Iterator end();
    List<T>& operator=(const List<T>& x);
    void splice(Iterator position,List<T>& x);
    void show();


};



#endif //LIST_H
