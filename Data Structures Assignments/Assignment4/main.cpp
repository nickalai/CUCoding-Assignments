/*
Name: Nick Lai
Student ID#: 2282417
Chapman email: lai137@mail.chapman.edu
Course Number and Section: 350-02
Assignment: 4
*/

#include <iostream>
#include <cstring>
#include "assignment4.h"

using namespace std;

int main(int argc, char** argv)
{
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

  Simulation s;
  string file = argv[1];

  int currTime = 0;
  int openWindows = 0;

  bool running = true;

  if(s.importFile(file))
  {
    while(running)
    {
      if(s.studentQueue.isEmpty())
      {
        int temp = 0;

        for(int i = 0; i < s.totalWindows; ++i)
        {
          if((s.windowArray[i] -> windowTime) < 1)
          {
            temp++;
          }
        }

        if(temp == s.totalWindows)
        {
          running = false;
        }
      }
      for(int i = 0; i < s.totalWindows; ++i)
      {
        if(s.windowArray[i]->windowTime < 1)
        {
          if(!s.studentQueue.isEmpty())
          {
            Students* student = s.studentQueue.qFront();

            if(student->entryTime <= currTime)
            {
              if(s.windowArray[i]->idleTime > 0)
              {
                s.idleStats.enqueue(s.windowArray[i]->idleTime);
              }

              s.windowArray[i] = s.studentQueue.dequeue();
              s.waitStats.enqueue(s.windowArray[i]->queueTime);
            }
          }
        }
      }

      currTime++;
      s.timeTracker(currTime);
    }

    for(int i = 0; i < s.totalWindows; ++i)
    {
      if(s.windowArray[i]->idleTime > 0)
      {
        s.idleStats.enqueue(s.windowArray[i]->idleTime);
      }
    }

    cout << "\n--- Simulation Complete ---" << endl;
    cout << "\nStudent Related Calculations" << endl;
    cout << "Mean Student Wait Time: " << s.meanTime() << " minutes" << endl;
    cout << "Median Student Wait Time: " << s.medianTime() << " minutes" << endl;
    cout << "Longest Student Wait Time: " << s.longestTime() << " minutes" << endl;
    cout << "Students Waiting Over Ten Minutes: " << s.timesOverTen() << " times" << endl;
    
    cout << "\nWindow Related Calculations" << endl;
    cout << "Mean Window Idle Time: " << s.meanIdleTime() << " minutes" << endl;
    cout << "Longest Window Idle Time: " << s.longestIdleTime() << " minutes" << endl;
    cout << "Idle Time Over Five Minutes: " << s.timesIdleOverFive() << " times\n" << endl;
  }
  return 0;
}
