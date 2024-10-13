//
// Created by francessca on 10/13/24.
//

#ifndef DOUBLYLINK_H
#define DOUBLYLINK_H

template <typename T>
class doublyLink {
private:
    struct Node
    {
        T data;
        Node* front;
        Node* next;
    };
    Node* head;
    int size;

public:
    doublyLink();   //Constructor

    ~doublyLink();  //Destructor

    void addHead(const T& data);    //PostCondition:add element to the doublyLink container

    int getSize()const;     //PostCondition:return size of doublyLink container

    bool isEmpty()const;    //PostCondition:return true if the doublyLink container is empty

    class Iterator {
        friend class doublyLink<T>;
    private:
        Node* current;
        explicit Iterator(Node* nodePtr) {
            current=nodePtr;
        }// PostCondition: The iterator has been constructed from ptr.
    public:
        Iterator();     //PostCondition:return Iterator object with null Node pointer

        Iterator operator++(int);//PostCondition:the iterator has been positioned at
                                // the next item in the doublyLink object.

        Iterator operator--(int);//PostCondition:the iterator has been positioned at
                                // the front item in the doublyLink object.

        T& operator*(); //PostCondition:A reference to the item the iterator is
                        //positioned at has been returned.

        bool operator==(const Iterator& other);//PostCondition:true has been returned if the
                            //iterator is equal to other; otherwise false has been returned.
    };    //inner class Iterator

    Iterator Begin()const;  //PostCondition:return Iterator at begin

    Iterator End()const;    //PostCondition:return Iterator at end

    Iterator reverseBegin()const;//PostCondition:return Iterator at reverse begin

    Iterator reverseEnd()const;  //PostCondition:return Iterator at reverse end
};

//************************implementation of the iterator inner class**************************
template <typename T>
doublyLink<T>::Iterator::Iterator(){current=nullptr;}

template <typename T>
typename doublyLink<T>::Iterator doublyLink<T>::Iterator::operator++(int) {
    Iterator temp= *this;
    this->current = current->next;
    return temp;
}

template <typename T>
typename doublyLink<T>::Iterator doublyLink<T>::Iterator::operator--(int) {
    Iterator temp=*this;
    this->current=current->front;
    return temp;
}

template <typename T>
T& doublyLink<T>::Iterator::operator*(){ return current->data; }

template <typename T>
bool doublyLink<T>::Iterator::operator==(const Iterator& other) {
    return current==other.current;
}



//************************implementation of the Begin and End position**************************

template <typename T>
typename doublyLink<T>::Iterator doublyLink<T>::Begin()const { return Iterator(head);}

template <typename T>
typename doublyLink<T>::Iterator doublyLink<T>::End()const{return Iterator(nullptr);}

//**********************implementation of reverse Begin and End position*************************

template <typename T>
typename doublyLink<T>::Iterator doublyLink<T>::reverseBegin()const {
    Node* cur = head;
    while(cur !=nullptr && cur->next!=nullptr) {
        cur = cur->next;
    }
    return Iterator(cur);
}

template <typename T>
typename doublyLink<T>::Iterator doublyLink<T>::reverseEnd()const{return Iterator(nullptr);}


//************************implementation of the linked list class template**************************

template <typename T>
doublyLink<T>::doublyLink() {
    head=nullptr;
    size=0;
}

template <typename T>
doublyLink<T>::~doublyLink() {
    Node* cur = head;
    while(cur!=nullptr) {
        Node* temp = cur;
        cur = cur->next;
        delete temp;
    }
};

template <typename T>
void doublyLink<T>::addHead(const T& data) {
    Node* newPtr = new Node;
    newPtr->data=data;
    newPtr->next=head;
    newPtr->front=nullptr;
    if(head!=nullptr) {
        head->front=newPtr;
    }//If head is null,it doesn't exist front pointer
    head=newPtr;
    size++;
}

template <typename T>
int doublyLink<T>::getSize()const{ return size;}

template <typename T>
bool doublyLink<T>::isEmpty()const{return head==nullptr;}


#endif //DOUBLYLINK_H
