/*
Name: Nick Lai
Student ID#: 2282417
Chapman email: lai137@mail.chapman.edu
Course Number and Section: 350-02
Assignment: 6
*/

#include <iostream>
#include "Assignment6.h"

using namespace std;

int main(int argc, char** argv)
{
  Sorting s;

  //if no file specified
  if (argc == 1)
  {
    cout << "Error. Please enter a file name." << endl;
    return -1;
  }

  if (argc >= 3)
  {
    cout << "Error. Too many arguments entered. Please only enter one file name." << endl;
    return -1;
  }

  string filename = argv[1]; //sets file to argv
  s.setFile(filename);
  return 0;
}
