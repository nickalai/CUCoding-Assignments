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
#include "assignment3.h"
#include "GenStack.h"

using namespace std;

//constructor
DelimiterChecker::DelimiterChecker()
{

}

//destructor
DelimiterChecker::~DelimiterChecker()
{
  cout << "objects destroyed" << endl;
}

//code for checking delimiters given an input file
int DelimiterChecker::checkDelims(string fileName)
{
  bool isChecking = true;

  GenStack<char> s(10);

  while (isChecking)
  {
    string inputCode;
    int lineNum = 1;

    ifstream inputFile;
    inputFile.open(fileName.c_str());

    while (getline(inputFile, inputCode))
    {
      for (int i = 0; i < inputCode.size(); ++i)
      {
        if ((inputCode[i] == '(')||(inputCode[i] == ')')||(inputCode[i] == '[')||(inputCode[i] == ']')||(inputCode[i] == '{')||(inputCode[i] == '}'))
        {
          if ((inputCode[i] == '(')||(inputCode[i] == '[')||(inputCode[i] == '{'))
            s.push(inputCode[i]);
          else if ((s.peek() == '(')&&(inputCode[i] == ')'))
            s.pop();
          else if ((s.peek() == '[')&&(inputCode[i] == ']'))
            s.pop();
          else if ((s.peek() == '{')&&(inputCode[i] == '}'))
            s.pop();
          else if ((s.peek() == '(')&&(inputCode[i] == ']' || inputCode[i] == '}'))
          {
            cout << "Error at line " << lineNum << ": ')' expected. '" << inputCode[i] << "' found instead." << endl;
            return 0;
          }
          else if ((s.peek() == '[')&&(inputCode[i] == ')' || inputCode[i] == '}'))
          {
            cout << "Error at line " << lineNum << ": ']' expected. '" << inputCode[i] << "' found instead." << endl;
            return 0;
          }
          else if ((s.peek() == '{')&&(inputCode[i] == ']' || inputCode[i] == ')'))
          {
            cout << "Error at line " << lineNum << ": '}' expected. '" << inputCode[i] << "' found instead." << endl;
            return 0;
          }
        }
      }
      ++lineNum;
    }
    //if isEmpty returns as false (0) there are extra Brackets in program (stored at the top/peek) - throws ERROR
    if (s.isEmpty() == false)
    {
      cout << "Error. Reached end of file. Missing '" << s.peek() << "'." << endl;
      return 0;
    }
    //if isEmpty returns as true (1) there are no ERRORS
    else if (s.isEmpty() == true)
    {
      char repeat;

      cout << "No errors found in this file. \nCheck another file? [y/n]: " << endl;
      cin >> repeat;

      if ((repeat == 'y')||(repeat == 'Y'))
      {
        cout << "Enter the name of the next file: " << endl;
        cin >> fileName;
        continue;
      }
      else
      {
        isChecking = false;
      }
    }
  }
  return 0;
}
