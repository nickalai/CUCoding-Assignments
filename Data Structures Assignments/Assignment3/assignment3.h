/*
Name: Nick Lai
Student ID#: 2282417
Chapman email: lai137@mail.chapman.edu
Course Number and Section: 350-02
Assignment: 3
*/

#include <iostream>
#include <string>
#include <fstream>
using namespace std;

class DelimiterChecker
{
  public:
    DelimiterChecker(); //constructor
    ~DelimiterChecker(); //destructor

    int checkDelims(string fileName); //code for checking delimiters given an input file
};
