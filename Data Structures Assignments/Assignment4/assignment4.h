/*
Name: Nick Lai
Student ID#: 2282417
Chapman email: lai137@mail.chapman.edu
Course Number and Section: 350-02
Assignment: 4
*/

#include <iostream>
#include <cstring>
#include "Students.h"
#include "GenQueue.h"

using namespace std;

class Simulation
{
  private:
    int type; //choose type based on line order (student/time/clock)
    int entryTime;
    int timeAtWindow;
    int numStudentsPerTick; //Number of Students at Each Clock Tick
    int medianCount; //Median Array Element Count
    int idleCount; //Idle Array Element Count

  public:
    Simulation(); //constructor
    ~Simulation(); //destructor

    bool importFile(string file); //reads in the file

    bool timeTracker(int t); //keeps track of overall time

    //does all of the math relating to students
    double meanTime();
    double medianTime();
    int longestTime();
    int timesOverTen();
    //does all the math relating to the window/registrar
    double meanIdleTime();
    int longestIdleTime();
    int timesIdleOverFive();

    Students* *windowArray; //keeps track of students at the windows

    GenQueue<Students*> studentQueue; //queue of students

    GenQueue<int> waitStats;
    GenQueue<int> idleStats;

    int *medianArrary;
    int *idleArray;

    int totalWindows;
    int totalStudents;
};
