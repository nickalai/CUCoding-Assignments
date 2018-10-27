/*
Name: Nick Lai
Student ID#: 2282417
Chapman email: lai137@mail.chapman.edu
Course Number and Section: 350-02
Assignment: 3
*/

#include <iostream>
#include <string>

using namespace std;

template <class T>
class GenStack
{
  public:
    GenStack(int maxsize); //constructor
    ~GenStack(); //destructor

    int top;
    int max;

    T *myArray;
    T *tempArray;

    void push(T data); //adds data to the top of the stack
    T pop(); //removes data from the top of the stack
    T peek(); //shows the top element of the stack

    bool isFull(); //checks if stack is full
    bool isEmpty(); //checks if stack is empty

    void expand(); //increases the size of the stack if it is full
};

//constructor
template <class T>
GenStack<T>::GenStack(int maxsize)
{
  myArray = new T[maxsize];
  max = maxsize;
  top = -1;
  tempArray = new T[max];
}

//destructor
template <class T>
GenStack<T>::~GenStack()
{
  delete []myArray;
  delete []tempArray;

  cout << "objects destroyed" << endl;
}

//adds data to the top of the stack
template <class T>
void GenStack<T>::push(T data)
{
  //checks if the stack is full before adding onto it
  if (isFull() == true)
  {
    expand();
    push(data);
  }
  else
    myArray[++top] = data;
}

//removes data from the top of the stack
template <class T>
T GenStack<T>::pop()
{
  //checks if the stack is empty before removing from it
  if (isEmpty() == true)
  {
    cout << "ERROR: current stack is empty\n" << endl;
    return 0;
  }
  else
    return myArray[top--];
}

//shows the top element of the stack
template <class T>
T GenStack<T>::peek()
{
  if (top == -1)
    return 0;
  else
    return myArray[top];
}

//checks if stack is full
template <class T>
bool GenStack<T>::isFull()
{
  return (top == max-1);
}

//checks if stack is empty
template <class T>
bool GenStack<T>::isEmpty()
{
  return (top == -1);
}

//increases the size of the stack if it is full
template <class T>
void GenStack<T>::expand()
{
  tempArray = new T[max];

  for (int i = top; i > -1; --i)
  {
    tempArray[i] = myArray[i];
  }

  max += 1;
  myArray = new T[max];

  for (int i = top; i > -1; --i)
  {
    myArray[i] = tempArray[i];
  }
}
