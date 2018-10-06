/*
Name: Nick Lai
Student ID#: 2282417
Chapman email: lai137@mail.chapman.edu
Course Number and Section: 350-02
Assignment: 4
*/

#include <iostream>

using namespace std;

class Students
{
  private:

  public:
    Students();
    Students(int t, int e);
    ~Students();

    int windowTime;
    int entryTime;
    int queueTime;
    int idleTime;
};
