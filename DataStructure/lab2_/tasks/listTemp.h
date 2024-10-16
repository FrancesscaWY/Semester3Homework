//
// Created by francessca on 24-10-16.
//

#ifndef LISTTEMP_H
#define LISTTEMP_H

template <class T>
class ListTemp{
private:
  struct Node{
      T data;
      Node* next;
  };
  Node* head;
  int size;
public:
    ListTemp();

    ~ListTemp();

    int getLength()const;

    bool isEmpty();

    void addHead(const T& newData);

    void addTail(const T& newData);

    class Iterator {
        friend class ListTemp<T>;
    private:
        Node* current;
        Iterator(Node* ptr);
    public:
        Iterator();

        Iterator operator++(int);

        T& operator*()const;

        bool operator==(const Iterator other) const;
    };

    Iterator Begin()const;

    Iterator End()const;
};


/*Iterator*/
template <typename T>
ListTemp<T>::Iterator::Iterator() {
    current = nullptr;
}

template <typename T>
ListTemp<T>::Iterator::Iterator(Node* ptr) {
    current = ptr;
}

template <typename T>
typename ListTemp<T>::Iterator ListTemp<T>::Iterator::operator++(int){
    Iterator temp;
    temp = *this;
    this->current = current->next;
    return temp;
}

template <typename T>
T& ListTemp<T>::Iterator::operator*()const{
    return this->current->data;
}

template <typename T>
bool ListTemp<T>::Iterator::operator==(const Iterator other)const {
    return current == other.current;
}

/*class ListTemp*/

template <typename T>
ListTemp<T>::ListTemp() {
    head = nullptr;
    size = 0;
}
template <typename T>
ListTemp<T>::~ListTemp() {
    for(int i=0;i<size;i++) {
        Node* temp = new Node();
        temp = head;
        head = head->next;
        delete temp;
    }
}

template <typename T>
int ListTemp<T>::getLength()const{
    return size;
}

template <typename T>
typename ListTemp<T>::Iterator ListTemp<T>::Begin()const{
    return Iterator(head);
}

template <typename T>
typename ListTemp<T>::Iterator ListTemp<T>::End()const {
    return Iterator(nullptr);
}

template <typename T>
bool ListTemp<T>::isEmpty() {
    return head==nullptr;
}
template <typename T>
void ListTemp<T>::addHead(const T& newData){
    Node* newPtr = new Node();
    newPtr->data=newData;
    newPtr->next=head;
    head = newPtr;
    size++;
}

template <typename T>
void ListTemp<T>::addTail(const T& newData) {
    if(isEmpty()) {
        Node* temp = new Node();
        temp->data=newData;
        head=temp;
    }else {
        Node* tail=head;
        while(tail->next != nullptr) {
            tail = tail->next;
        }
        Node* temp=new Node();
        temp->data=newData;
        tail->next=temp;
    }
    size++;
}

#endif //LISTTEMP_H
