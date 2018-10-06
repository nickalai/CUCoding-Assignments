/*
Name: Nick Lai
Student ID#: 2282417
Chapman email: lai137@mail.chapman.edu
Course Number and Section: 350-02
Assignment: 4
*/

#include <iostream>
#include "ListNode.h"

using namespace std;

template <class T>
class DoublyLinkedList
{
  private:

  public:
    unsigned int size;
    ListNode<T> *front;
    ListNode<T> *back;

    DoublyLinkedList(); //constructor
    ~DoublyLinkedList(); //destructor

    void insertBack(T data);
    T removeFront();
    T getFront();

    void printList();
    int deletePos(int pos);

    bool isEmpty();
    unsigned int getSize();
};

template <class T>
DoublyLinkedList<T>::DoublyLinkedList()
{
  size = 0;
  front = NULL;
  back = NULL;
}

template <class T>
DoublyLinkedList<T>::~DoublyLinkedList()
{

}

template <class T>
void DoublyLinkedList<T>::insertBack(T d)
{
  ListNode<T> *node = new ListNode<T>(d);
  //if the linkedlist is empty
  if(size == 0)
    front = node;

  else
  {
    back->next = node;
    node->prev = back;
  }

  back = node;
  ++size;
}

template <class T>
T DoublyLinkedList<T>::removeFront()
{
  if(!isEmpty())
  {
    ListNode<T> *node = front;
    //if the front node is the only node in the linkedlist
    if(front->next = NULL)
    {
      front = NULL;
      back = NULL;
    }
    //if the front node is not the only node in the linkedlist
    else
    {
      front->next->prev = NULL;
      front = front->next;
    }

    T temp = node->data;

    delete node;
    --size;
    return temp;
  }

  else
    return T();
}

template <class T>
T DoublyLinkedList<T>::getFront()
{
  return front->data;
}

template <class T>
void DoublyLinkedList<T>::printList()
{
  ListNode<T> *curr = front;

  while(true)
  {
    if(curr->next == NULL)
      break

    cout << curr->data << endl;
    curr = curr->next;
  }
}

template <class T>
void DoublyLinkedList<T>::deletePos(int pos)
{
  int idx = 0;
  ListNode<T> *curr = front;
  ListNode<T> *prev = front;

  while(idx != pos)
  {
    prev = curr;
    curr = curr->next;
    ++idx;
  }

  prev->next = curr->next;
  curr->next->prev = prev;
  curr->next = NULL;
  curr->prev = NULL;
  curr->data = NULL;

  --size;
  delete curr;
}

template <class T>
bool DoublyLinkedList<T>::isEmpty()
{
  return (size == 0);
}

template <class T>
unsigned int DoublyLinkedList<T>::getSize()
{
  return size;
}
