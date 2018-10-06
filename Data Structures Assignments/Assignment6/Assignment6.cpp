/*
Name: Nick Lai
Student ID#: 2282417
Chapman email: lai137@mail.chapman.edu
Course Number and Section: 350-02
Assignment: 6
*/

#include "Assignment6.h"

using namespace std;

Sorting::Sorting()
{

}

Sorting::~Sorting()
{
  delete[] quickSortArray;
  delete[] insertSortArray;
  delete[] bubbleSortArray;
  delete[] bogoSortArray;
}

void Sorting::setFile(string filename)
{
  string nElements;
  string line;
  double size;
  int lineNum = 1;

  ifstream inputFile;
  inputFile.open(filename.c_str());

  getline(inputFile, nElements);

  numElements = atoi(nElements.c_str());

  quickSortArray = new double[numElements];
  insertSortArray = new double[numElements];
  bubbleSortArray = new double[numElements];
  bogoSortArray = new double[numElements];

  for(int i = 0; i < numElements; ++i)
  {
    lineNum++;

    getline(inputFile, line);

    try
    {
      size = atof(line.c_str());
    }
    catch(exception e)
    {
      cout << "Error. Invalid format" << endl;
      return;
    }

    quickSortArray[i] = size;
    insertSortArray[i] = size;
    bubbleSortArray[i] = size;
    bogoSortArray[i] = size;
  }
  inputFile.close();
  sortAll();
}

void Sorting::swap(double array[], int a, int b)
{
  double tempArray = array[a];
  array[a] = array[b];
  array[b] = array[a];
}

int Sorting::partition(double array[], int left, int right)
{
  //middle value becomes pivot
  int pivot = array[(left + right) / 2];

  while(left <= right)
  {
    //objects to left of pivot in array
    while(array[left] < pivot)
    {
      left++;
    }
    //objects to right of pivot in array
    while(array[right] > pivot)
    {
      right--;
    }
    //swap left and right objects
    if(left <= right)
    {
      swap(array, left, right);
      left++;
      right--;
    }
  }
  return left;
}

bool Sorting::isSorted(double array[])
{
  for(int i = numElements - 1; i > 1; --i)
  {
    if(array[numElements] < array[numElements - 1])
      return false;
  }
  return true;
}

void Sorting::shuffle(double array[])
{
  for(int i = 0; i < numElements; ++i)
  {
    swap(array, i, rand() % numElements);
  }
}

//sorting algorithms
void Sorting::quickSort(double array[], int left, int right)
{
  int idx = partition(array, left, right);

  if(left < idx - 1)
    quickSort(array, left, idx - 1);
  if(right > idx)
    quickSort(array, idx, right);
}

void Sorting::insertSort(double array[])
{
  //marker
  for(int j = 1; j < numElements; ++j)
  {
    //store marked item
    double temp = array[j];
    //where to start shifting
    int k = j;

    //while item on the left is larger, shift
    while(k > 0 && array[k-1] >= temp)
    {
      array[k] = array[k-1];
      --k;
    }
    //puts marked item in right spot
    array[k] = temp;
  }
}

void Sorting::bubbleSort(double array[])
{
  for(int i  = 0; i < numElements; ++i)
  {
    int temp = 0;

    for(int j = i; j < numElements - 1; ++j)
    {
      if(array[j] > array[j+1])
      {
        swap(array, j, j+1);
      }
    }
  }
}

void Sorting::bogoSort(double array[])
{
  //if the array is not sorted, shuffle the array
  while(!isSorted(array))
  {
    shuffle(array);
  }
}

void Sorting::sortAll()
{
  clock_t clockStart;
  clock_t clockEnd;
  float calcTime;

  cout << "\nSorting information...\n" << endl;

  //quick sort
  clockStart = clock();
  quickSort(quickSortArray, 0, numElements - 1);
  clockEnd = clock();

  calcTime = (float(clockEnd - clockStart) / CLOCKS_PER_SEC) * 1000;
  cout << "~ QuickSort took " << calcTime << " ms to sort " << numElements << " numbers." << endl;

  //insert sort
  clockStart = clock();
  insertSort(insertSortArray);
  clockEnd = clock();

  calcTime = (float(clockEnd - clockStart) / CLOCKS_PER_SEC) * 1000;
  cout << "~ InsertSort took " << calcTime << " ms to sort " << numElements << " numbers." << endl;

  //bubble sort
  clockStart = clock();
  bubbleSort(bubbleSortArray);
  clockEnd = clock();

  calcTime = (float(clockEnd - clockStart) / CLOCKS_PER_SEC) * 1000;
  cout << "~ BubbleSort took " << calcTime << " ms to sort " << numElements << " numbers." << endl;

  //bogo sort
  clockStart = clock();
  bogoSort(bogoSortArray);
  clockEnd = clock();

  calcTime = (float(clockEnd - clockStart) / CLOCKS_PER_SEC) * 1000;
  cout << "+ BogoSort took " << calcTime << " ms to sort " << numElements << " numbers." << endl;


  cout << "\n...Sorting complete. Program exitting." << endl;
}
