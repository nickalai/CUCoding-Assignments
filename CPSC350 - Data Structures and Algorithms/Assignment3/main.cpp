/*
Name: Nick Lai
Student ID#: 2282417
Chapman email: lai137@mail.chapman.edu
Course Number and Section: 350-02
Assignment: 3
*/

#include <iostream>
#include <fstream>
#include <string>
#include "GenStack.h"
#include "assignment3.h"

using namespace std;

int main(int argc, char** argv)
{
  //checks for correct number of arguments in command line
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

  DelimiterChecker delim;
  string fileName = argv[1]; //sets the filename to the command line argument
  delim.checkDelims(fileName); //calls checkDelims method to check for delimiters in the inputted file

  return 0;
}
