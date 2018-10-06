/*
Name: Nick Lai
Student ID#: 2282417
Chapman email: lai137@mail.chapman.edu
Course Number and Section: 350-02
Assignment: 1
*/
#include "assignment1.h"

using namespace std;

int main(int argc, char** argv)
{
  //instantiates ouput and input file
  ofstream outputFile;
  ifstream inputFile;
  //opens an output file with this name.
  outputFile.open("nicklai.out");
  //error check to make sure the file can be created
  if(outputFile.is_open())
  {
    cout << "Output file located!" << endl;
  }

  else
  {
    cout << "Error. Output file not located." << endl;
  }
  //error checks command line input
  if(argc == 1)
  {
    cout << "Syntax error. Please specify a file name." << endl;
    return -1;
  }

  if(argc >= 3)
  {
    cout << "Syntax error. Too many arguments." << endl;
    cout << "Input should be: ./" << endl;
    return -1;
  }
  //sets input from command line to the filepath
  string filePath = argv[1];

  //continues the program until set otherwise
  while(true)
  {
    //opens the input file
    inputFile.open(filePath.c_str());
    //creates instance of dnaStrands
    dnaStrands dna1;

    //calculates stats, prints them to .out file, and prints out 1000 new DNA strands
    dna1.calcStats(inputFile);
    dna1.printStats(outputFile);
    dna1.gaussianDistribution(outputFile);
    //closes the input file
    inputFile.close();
    //checks if user wishes to continue
    cout << "Would you like to input another list? (y/n): " << endl;
    char choice;
    cin >> choice;
    if(choice == 'y' || choice == 'Y')
    {
      cout << "Enter the name of the file: " << endl;
      string fileName;
      cin >> fileName;
      filePath = fileName;
      continue;
    } else break;
  }
  return 0;
}
