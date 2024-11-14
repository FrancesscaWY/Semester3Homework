//
// Created by francessca on 24-11-6.
//

#include "List.h"
#include <iostream>
template <typename T>
List<T>::List() {
    head = nullptr;
    tail = nullptr;
    length = 0;
}

template <typename T>
List<T>::List(const List<T>& x) {
    head = nullptr;
    tail = nullptr;
    Node* temp = x.head;
    while (temp != nullptr) {
        push_back(temp->data);
        temp = temp->next;
        length++;
    }
}

template <typename T>
List<T>::~List() {
    while(head!=nullptr) {
        Node* temp = head;
        head = head->next;
        delete temp;
    }
}

template <typename T>
void List<T>::push_front(const T& x) {
    Node* newNode = new Node;
    newNode->data = x;
    newNode->pre = nullptr;
    newNode->next = head;
    if (head == nullptr) {
        head = newNode;
        tail = newNode;
    } else {
        head->pre = newNode;
        head = newNode;
    }
    length++;
}

template <typename T>
void List<T>::push_back(const T& x) {
    Node* newNode = new Node;
    newNode->data = x;
    newNode->next = nullptr;
    newNode->pre = tail;
    if (tail == nullptr) {
        head = newNode;
        tail = newNode;
    } else {
        tail->next = newNode;
        tail = newNode;
    }
    length++;
}

template <typename T>
typename List<T>::Iterator List<T>::insert(Iterator position,const T& x) {
    Node* newNode = new Node;
    newNode->data = x;
    newNode->next = position.curr;
    newNode->pre = position.curr->pre;
    position->pre->next = newNode;
    position->pre = newNode;
    length++;
}

template <typename T>
void List<T>::pop_front() {
    if(head==nullptr) {
        return;
    }
    Node* temp = head;
    head = head->next;
    delete temp;
    length--;
}

template <typename T>
void List<T>::pop_back() {
    if(tail==nullptr) {
        return;
    }
    Node* temp = tail;
    tail = tail->pre;
    delete temp;
    length--;
}

template <typename T>
typename List<T>::Iterator List<T>::erase(Iterator first,Iterator last) {
    Node* temp = new Node;
    while(temp!=last.curr) {
        temp = first.curr;
        first.curr = first->next;
        delete temp;
        length--;
    }
}
template <typename T>
typename List<T>::Iterator List<T>::erase(Iterator position) {
    Node* temp = position.curr;
    position.curr->pre->next = position.curr->next;
    position.curr->next->pre = position.curr->pre;
    delete temp;
    length--;
}

template <typename T>
unsigned List<T>::size() const {
    return length;
}

template <typename T>
bool List<T>::empty() const {
    return head == nullptr;
}

template <typename T>
typename List<T>::Iterator List<T>::begin() {
    return Iterator(head);
}

template <typename T>
typename List<T>::Iterator List<T>::end() {
    return Iterator(tail);
}

template <typename T>
List<T>& List<T>::operator=(const List<T>& x) {
    if(this == &x) {
        return *this;
    }
    while(head!=nullptr) {
        Node* temp = head;
        head = head->next;
        delete temp;
    }
    length = 0;
    *this = List(x);
    return *this;
}

template <typename T>
void List<T>::splice(Iterator position,List<T>& x) {
    if(x.empty()) {
        return;
    }
    x.head->pre = position.curr->pre;
    x.tail->next = position.curr;
    position.curr->pre->next = x.head;
    position.curr->pre = x.tail;
    length += x.size();
    x.head = nullptr;
    x.tail = nullptr;
    x.length = 0;
}

template <typename T>
typename List<T>::Iterator& List<T>::Iterator::operator++() {
    return Iterator(curr->next);
}

template <typename T>
typename List<T>::Iterator List<T>::Iterator::operator++(int) {
    Iterator temp = *this;
    curr = curr->next;
    return temp;
}

template <typename T>
typename List<T>::Iterator List<T>::Iterator::operator--() {
    return Iterator(curr->pre);
}

template <typename T>
typename List<T>::Iterator List<T>::Iterator::operator--(int) {
    Iterator temp = *this;
    curr = curr->pre;
    return temp;
}

template <typename T>
T& List<T>::Iterator::operator*() {
    return curr->data;
}
template <typename T>
bool List<T>::Iterator::operator==(const Iterator& x) {
    return curr == x.curr;
}

template <typename T>
void List<T>::show() {
    Node* temp = head;
    while(temp!=nullptr) {
        std::cout<<temp->data<<" ";
        temp = temp->next;
    }
    std::cout << std::endl;
}