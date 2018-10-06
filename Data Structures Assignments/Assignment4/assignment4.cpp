/*
Name: Nick Lai
Student ID#: 2282417
Chapman email: lai137@mail.chapman.edu
Course Number and Section: 350-02
Assignment: 4
*/

#include <iostream>
#include <fstream>
#include <cstring>
#include <algorithm>
#include <sstream>
#include "assignment4.h"

using namespace std;

Simulation::Simulation()
{
  type = 1;
  entryTime = 0;
  timeAtWindow = 0;

  numStudentsPerTick = 0;
  medianCount = 0;
  idleCount = 0;

  totalWindows = 0;
  totalStudents = 0;
}

Simulation::~Simulation()
{
  delete [] windowArray;
  delete [] idleArray;
  delete [] medianArrary;
}

bool Simulation::importFile(string file)
{
  string line;
  int lineNum = 1;

  ifstream inputStream;
  inputStream.open(file.c_str());

  try
  {
    getline(inputStream, line);
    totalWindows = atoi(line.c_str());

    windowArray = new Students*[totalWindows];

    for(int i = 0; i < totalWindows; ++i)
    {
      Students* student = new Students();
      windowArray[i] = student;
    }
    lineNum++;
  }

  catch(exception e)
  {
    cout << "Error." << endl;
    return false;
  }

  while(getline(inputStream, line))
  {
    switch(type)
    {
      //time ticks
      case(1):
      {
        try
        {
          entryTime = atoi(line.c_str());
          type++;
          lineNum++;
        }
        catch(exception e)
        {
          cout << "Error." << endl;
          return false;
        }
        break;
      }
      //number of students
      case(2):
      {
        try
        {
          if(line != "")
          {
            numStudentsPerTick = atoi(line.c_str());

            for(int i = 0; i < numStudentsPerTick; ++i)
            {
              getline(inputStream, line);
              lineNum++;

              try
              {
                timeAtWindow = atoi(line.c_str());
              }
              catch(exception e)
              {
                cout << "Error." << endl;
                return false;
              }

              totalStudents++;

              Students* student = new Students(timeAtWindow, entryTime);

              studentQueue.enqueue(student);
            }
            type--;
          }
        }
        catch(exception e)
        {
          cout << "Error." << endl;
          return false;
        }
        break;
      }
      default:
        break;
    }
  }
  return true;
}

bool Simulation::timeTracker(int t)
{
  for(int i = 0; i < totalWindows; ++i)
  {
    if(windowArray[i]->windowTime > 0)
      windowArray[i]->windowTime--; //decreases when a student is at the window.

    else
      windowArray[i]->idleTime++; //increases when a student isn't at the window
  }

  if(!studentQueue.isEmpty())
  {
    ListNode<Students*> *curr = studentQueue.front;

    while(curr != NULL)
    {
      if(curr->data->entryTime < t)
        curr->data->queueTime += 1;

      curr = curr->next;
    }
  }
  return true;
}

double Simulation::meanTime()
{
  ListNode<int> *curr = waitStats.front;

  double mnWait = 0;
  double sum = 0;
  double counter = 0;

  while(curr != NULL)
  {
    sum += curr->data;
    curr = curr->next;
    counter++;
  }
  if(counter == 0)
    return 0;

  mnWait = sum / counter;
  return mnWait;
}

double Simulation::medianTime()
{
  ListNode<int> *curr = waitStats.front;

  double medWait = 0;
  medianCount = 0;

  while(curr != NULL)
  {
    curr = curr->next;
    medianCount++;
  }

  if(medianCount == 0)
    return 0;

  else
  {
    medianArrary = new int[medianCount];
    curr = waitStats.front;

    for(int i = 0; i < medianCount; ++i)
    {
      medianArrary[i] = curr->data;
      curr = curr->next;
    }

    //puts values in increasing order
    sort(medianArrary, medianArrary + medianCount);
    //for odd numbers
    if(medianCount % 2 == 1)
    {
      double d = 0;
      int r = 0;

      r = (medianCount/2) + 1;
      d = medianArrary[r];

      return d;
    }

    else
    {
      double d = 0;
      int a = 0;
      int z = 0;

      a = medianCount/2;
      z = (medianCount/2) + 1;

      if(medianArrary[z] == 0)
        return 0;

      d = double(medianArrary[a])/double(medianArrary[z]);

      return d;
    }
  }
}

int Simulation::longestTime()
{
  if(medianCount == 0)
    return 0;

  else
    return medianArrary[medianCount - 1];
}

int Simulation::timesOverTen()
{
  if(medianCount == 0)
    return 0;

  else
  {
    int temp = 0;

    for(int i = 0; i < medianCount; ++i)
    {
      if(medianArrary[i] > 10)
      {
        ++temp;
      }
    }
    return temp;
  }
}

double Simulation::meanIdleTime()
{
  ListNode<int> *curr = idleStats.front;

  double mnIdle = 0;
  double sum = 0;
  double counter = 0;

  while(curr != NULL)
  {
    sum += curr->data;
    curr = curr->next;

    counter++;
  }

  if(counter == 0)
    return 0;

  mnIdle = sum / counter;
  return mnIdle;
}

int Simulation::longestIdleTime()
{
  ListNode<int> *curr = idleStats.front;

  idleCount = 0;

  while(curr != NULL)
  {
    curr = curr->next;
    idleCount++;
  }

  idleArray = new int[idleCount];

  curr = idleStats.front;

  for(int i = 0; i < idleCount; ++i)
  {
    idleArray[i] = curr->data;
    curr = curr->next;
  }

  sort(idleArray, idleArray + idleCount);

  return(idleArray[idleCount - 1]);
}

int Simulation::timesIdleOverFive()
{
  int temp = 0;

  for(int i = 0; i < idleCount; ++i)
  {
    if(idleArray[i] > 5)
    {
      ++temp;
    }
  }
  return temp;
}
