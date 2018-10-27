/*
Name: Nick Lai
Student ID#: 2282417
Chapman email: lai137@mail.chapman.edu
Course Number and Section: 350-02
Assignment: 1
*/

#include <iostream>
#include <fstream>
#include <cstdlib>
#include <cmath>
#include <cstring>

using namespace std;

class dnaStrands
{
  private:
    //stores all the statistics and input stream.
    ifstream f;
    int numChars;
    double sum;
    double mean;
    double variance;
    double stdDev;
    double pA;
    double pC;
    double pG;
    double pT;
    double pAA;
    double pAC;
    double pAG;
    double pAT;
    double pCA;
    double pCC;
    double pCG;
    double pCT;
    double pGA;
    double pGC;
    double pGG;
    double pGT;
    double pTA;
    double pTC;
    double pTG;
    double pTT;

  public:
    dnaStrands(); //constructor
    ~dnaStrands(); //destructor

    void calcStats(ifstream& f); //calculates the sum, mean, variance, standard deviation, and probabilities
    void printStats(ofstream& output); //prints the calculated stats to the .out file
    void gaussianDistribution(ofstream& output); //generates 1000 random DNA strings
};
