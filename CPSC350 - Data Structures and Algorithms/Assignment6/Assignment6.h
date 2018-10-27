/*
Name: Nick Lai
Student ID#: 2282417
Chapman email: lai137@mail.chapman.edu
Course Number and Section: 350-02
Assignment: 6
*/

#include <iostream>
#include <fstream>
#include <string>
#include <stdlib.h>
#include <time.h>

using namespace std;

class Sorting
{
  private:
    int numElements;
    double *quickSortArray;
    double *insertSortArray;
    double *bubbleSortArray;
    double *bogoSortArray;

  public:
    Sorting();
    ~Sorting();

    void setFile(string filename);

    void swap(double array[], int a, int b);
    int partition(double array[], int left, int right);
    bool isSorted(double array[]);
    void shuffle(double array[]);

    void quickSort(double array[], int left, int right);
    void insertSort(double array[]);
    void bubbleSort(double array[]);
    void bogoSort(double array[]);

    void sortAll();
};
