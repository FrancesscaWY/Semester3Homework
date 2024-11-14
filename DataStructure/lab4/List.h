//
// Created by francessca on 24-11-6.
//

#ifndef LIST_H
#define LIST_H
#include <complex.h>
#include <iostream>


template<typename T>
class List {
private:
    struct Node {
        Node *pre;
        Node *next;
        T data;
    };
    Node *head;
    Node *tail;
    unsigned int length;
public:
    List();
    ~List();
    List(const List<T> &x);
    void push_front(const T &x);
    void push_back(const T &x);
    class Iterator {
        friend class List<T>;

    protected:
        Node *curr;

        Iterator(Node *x) {
            curr = x;
        };

    public:
        Iterator() { curr = nullptr; }

        Iterator &operator++();

        Iterator operator++(int);

        Iterator operator--();

        Iterator operator--(int);

        T &operator*();

        bool operator==(const Iterator &x);
    };
    Iterator insert(Iterator position, const T &x);
    void pop_front();
    void pop_back();
    Iterator erase(Iterator position);
    Iterator erase(Iterator first, Iterator last);
    unsigned size() const;
    bool empty() const;
    Iterator begin();
    Iterator end();
    List<T> &operator=(const List<T> &x);
    void splice(Iterator position, List<T> &x);
    void show();
};

template<typename T>
List<T>::List() {
    head = nullptr;
    tail = nullptr;
    length = 0;
}
template<typename T>
List<T>::List(const List<T> &x) {
    head = nullptr;
    tail = nullptr;
    Node *temp = x.head;
    while (temp != nullptr) {
        push_back(temp->data);
        temp = temp->next;
    }
    this->length = x.length;
}
template<typename T>
List<T>::~List() {
    while (head != nullptr) {
        Node *temp = head;
        head = head->next;
        delete temp;
    }
}

template<typename T>
void List<T>::push_front(const T &x) {
    Node *newNode = new Node;
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

template<typename T>
void List<T>::push_back(const T &x) {
    Node *newNode = new Node;
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

template<typename T>
typename List<T>::Iterator List<T>::insert(Iterator position, const T &x) {
    Node *newNode = new Node;
    newNode->data = x;
    if(position.curr == head) {
        position.curr->pre = newNode;
        newNode->next = position.curr;
        head = newNode;
        length ++;
        return Iterator(newNode);
    }
    if(position.curr == tail) {
        newNode->pre = tail;
        tail->next = newNode;
        newNode->next = nullptr;
        tail = newNode;
        length++;
        return Iterator(newNode);
    }
    if(empty()) {
        newNode->pre = nullptr;
        newNode->next = nullptr;
        head = newNode;
        tail = newNode;
        length++;
        return Iterator(newNode);
    }
    if(position.curr != nullptr) {
        newNode->pre = position.curr->pre;
        position.curr->pre = newNode;
        newNode->next = position.curr;
        newNode->pre->next = newNode;
        length++;
        return Iterator(newNode);
    }else{
        return Iterator(nullptr);
    }
}

template<typename T>
void List<T>::pop_front() {
    if (head == nullptr) {
        return;
    }
    Node *temp = head;
    head = head->next;
    delete temp;
    length--;
}

template<typename T>
void List<T>::pop_back() {
    if (tail == nullptr) {
        return;
    }
    Node *temp = tail;
    tail = tail->pre;
    tail->next = nullptr;
    delete temp;
    --length;
}

template<typename T>
typename List<T>::Iterator List<T>::erase(Iterator first, Iterator last) {
    if(first.curr!=head && last.curr != tail) {
        while(first.curr!=last.curr) {
            Node* temp = first.curr;
            first.curr = first.curr->next;
            temp->pre->next = first.curr;
            delete temp;
            length--;
        }
    }
    if(first.curr==head && last.curr == tail) {
        while(first.curr!=nullptr) {
            Node* temp = first.curr;
            first.curr = first.curr->next;
            first.curr->pre = nullptr;
            delete temp;
            length--;
        }
        head = nullptr;
        tail = nullptr;
    }
    if(first.curr == head && last.curr !=tail) {
        while(head!=last.curr){
            Node* temp = head;
            head = head->next;
            head->pre = nullptr;
            delete temp;
            length--;
        }
    }
    if(first.curr != head && last.curr == tail) {
        while(first.curr!=nullptr) {
            Node* temp = first.curr;
            first.curr = first.curr->next;
            delete temp;
            length--;
        }
        tail = first.curr->pre;
        tail->next = nullptr;
    }
    return last;
}

template<typename T>
typename List<T>::Iterator List<T>::erase(Iterator position) {
    if(position.curr == nullptr) {
        return position;
    }
    Node *temp = position.curr;
    Node *nextNode =position.curr->next;
    if(temp==head) {
        head = nextNode;
    }
    if(temp == tail) {
        tail = temp->pre;
    }
    if(temp->pre!=nullptr) {
        temp->pre->next = nextNode;
    }
    if(nextNode != nullptr) {
        nextNode ->pre =  temp->pre;
    }
    delete temp;
    length--;
    return Iterator(nextNode);
}

template<typename T>
unsigned List<T>::size() const {
    return length;
}

template<typename T>
bool List<T>::empty() const {
    return head == nullptr;
}

template<typename T>
typename List<T>::Iterator List<T>::begin() {
    return head;
}

template<typename T>
typename List<T>::Iterator List<T>::end() {
    return Iterator(tail);
}

template<typename T>
List<T> &List<T>::operator=(const List<T> &x) {
    if (this == &x) {
        return *this;
    }
    while (head != nullptr) {
        Node *temp = head;
        head = head->next;
        delete temp;
    }
    length = 0;
    *this = List(x);
    return *this;
}

template<typename T>
void List<T>::splice(Iterator position, List<T>& x) {
    // 如果 x 为空列表，直接返回
    if (x.empty()) return;
    length += x.size();
    // 获取插入位置的节点
    Node* posNode = position.curr;  // position 指向插入点的节点

    // 获取 x 的头尾节点
    Node* firstNode = x.head;
    Node* lastNode = x.tail;

    // 断开 x 中的所有节点
    x.head = nullptr;
    x.tail = nullptr;
    x.length = 0;  // 更新 x 的长度为 0

    // 插入到空列表或头部（position 为 nullptr 或 head）
    if (posNode == nullptr) {
        // 插入到当前列表的尾部
        if (tail != nullptr) {  // 当前列表非空
            tail->next = firstNode;
            firstNode->pre = tail;
            tail = lastNode;  // 更新尾节点
        } else {  // 当前列表为空
            head = firstNode;
            tail = lastNode;
        }
    } else {  // 插入到 position 之前
        Node* preNode = posNode->pre;  // position 前一个节点
        Node* nextNode = posNode;      // position 自己

        // 将 x 的第一个节点链接到 position 前
        if (preNode != nullptr) {
            preNode->next = firstNode;
            firstNode->pre = preNode;
        } else {  // position == head，插入到头部
            head = firstNode;
        }

        // 将 x 的最后一个节点连接到 position
        nextNode->pre = lastNode;
        lastNode->next = nextNode;
    }

    // 更新当前列表的长度
}



template<typename T>
typename List<T>::Iterator &List<T>::Iterator::operator++() {
    if (curr != nullptr) {
        curr = curr->next;
        return *this;
    } else {
        return *this;
    }
}

template<typename T>
typename List<T>::Iterator List<T>::Iterator::operator++(int) {
    Iterator temp = *this;
    curr = curr->next;
    return temp;
}

template<typename T>
typename List<T>::Iterator List<T>::Iterator::operator--() {
    return Iterator(curr->pre);
}

template<typename T>
typename List<T>::Iterator List<T>::Iterator::operator--(int) {
    Iterator temp = *this;
    curr = curr->pre;
    return temp;
}

template<typename T>
T &List<T>::Iterator::operator*() {
    return curr->data;
}

template<typename T>
bool List<T>::Iterator::operator==(const Iterator &x) {
    return curr == x.curr;
}

template<typename T>
void List<T>::show() {
    Node *temp = head;
    while (temp != nullptr) {
        std::cout << temp->data << " ";
        temp = temp->next;
    }
    if (head == nullptr && tail == nullptr) {
        std::cout << "nullptr";
    }
    std::cout << std::endl;
}
#endif //LIST_H
